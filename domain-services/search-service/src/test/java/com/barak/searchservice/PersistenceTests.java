package com.barak.searchservice;

import com.barak.searchservice.entities.SearchEntity;
import com.barak.searchservice.entities.SearchStepEntity;
import com.barak.searchservice.repositories.ISearchRepository;
import com.barak.searchservice.repositories.ISearchStepRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersistenceTests extends MySqlTestBase {

    @Autowired
    private ISearchRepository searchRepository;
    @Autowired
    private ISearchStepRepository stepRepository;


    private SearchEntity savedSearch;
    private SearchStepEntity savedStep;

    @BeforeEach
    void setupDb() {

        searchRepository.deleteAll();
        stepRepository.deleteAll();

        SearchEntity searchEntity = new SearchEntity(1, "a", "b", 2, "c", "d", "e");
        SearchStepEntity stepEntity = new SearchStepEntity(1, "a", 2, "b", "c", 3, "d", "e", "f", 4, "g", "h", "i", 5, "j", "k", 5000, 300);

        savedSearch = searchRepository.save(searchEntity);
        assertEqualsSearch(searchEntity, savedSearch);
        savedStep = stepRepository.save(stepEntity);
        assertEqualsStep(stepEntity, savedStep);

    }

    @Test
    void createSearch() {

        SearchEntity newEntity = new SearchEntity(2, "a", "b", 3, "c", "d", "e");
        searchRepository.save(newEntity);

        SearchEntity foundEntity = searchRepository.findById(newEntity.getId()).get();
        assertEqualsSearch(newEntity, foundEntity);

        assertEquals(2, searchRepository.count());
    }

    @Test
    void createStep() {

        SearchStepEntity newEntity = new SearchStepEntity(2, "c", 3, "d", "c", 4, "d", "e", "f", 4, "g", "h", "i", 5, "j", "k", 5000, 300);
        stepRepository.save(newEntity);

        SearchStepEntity foundEntity = stepRepository.findById(newEntity.getId()).get();
        assertEqualsStep(newEntity, foundEntity);

        assertEquals(2, stepRepository.count());
    }

    @Test
    void updateSearch() {
        savedSearch.setName("t5");
        searchRepository.save(savedSearch);

        SearchEntity foundEntity = searchRepository.findById(savedSearch.getId()).get();
        assertEquals(1, (long) foundEntity.getVersion());
        assertEquals("t5", foundEntity.getName());
    }

    @Test
    void updateStep() {
        savedStep.setName("t5");
        stepRepository.save(savedStep);

        SearchStepEntity foundEntity = stepRepository.findById(savedStep.getId()).get();
        assertEquals(1, (long) foundEntity.getVersion());
        assertEquals("t5", foundEntity.getName());
    }

    @Test
    void deleteSearch() {
        searchRepository.delete(savedSearch);
        assertFalse(searchRepository.existsById(savedSearch.getId()));
    }

    @Test
    void deleteStep() {
        stepRepository.delete(savedStep);
        assertFalse(stepRepository.existsById(savedStep.getId()));
    }

    @Test
    void getSearchById() {
        Optional<SearchEntity> entity = searchRepository.findById(savedSearch.getId());

        assertTrue(entity.isPresent());
        assertEqualsSearch(savedSearch, entity.get());
    }

    @Test
    void getStepById() {
        Optional<SearchStepEntity> entity = stepRepository.findById(savedStep.getId());

        assertTrue(entity.isPresent());
        assertEqualsStep(savedStep, entity.get());
    }

    @Test
    void duplicateError() {
        assertThrows(DuplicateKeyException.class, () -> {
            SearchEntity entity = new SearchEntity(savedSearch.getId(), "c", "o", 2, "o", "l", "e");
            searchRepository.save(entity);
        });
    }

    @Test
    void optimisticLockError() {

        // Store the saved entity in two separate entity objects
        SearchEntity entity1 = searchRepository.findById(savedSearch.getId()).get();
        SearchEntity entity2 = searchRepository.findById(savedSearch.getId()).get();

        // Update the entity using the first entity object
        entity1.setName("n1");
        searchRepository.save(entity1);

        // Update the entity using the second entity object.
        // This should fail since the second entity now holds an old version number, i.e. an Optimistic Lock Error
        assertThrows(OptimisticLockingFailureException.class, () -> {
            entity2.setName("n2");
            searchRepository.save(entity2);
        });

        // Get the updated entity from the database and verify its new state
        SearchEntity updatedEntity = searchRepository.findById(savedSearch.getId()).get();
        assertEquals(1, (int) updatedEntity.getVersion());
        assertEquals("n1", updatedEntity.getName());
    }


    private void assertEqualsSearch(SearchEntity expectedEntity, SearchEntity actualEntity) {
        assertEquals(expectedEntity.getId(), actualEntity.getId());
        assertEquals(expectedEntity.getVersion(), actualEntity.getVersion());
        assertEquals(expectedEntity.getName(), actualEntity.getName());
        assertEquals(expectedEntity.getWebsiteUrl(), actualEntity.getWebsiteUrl());
    }

    private void assertEqualsStep(SearchStepEntity expectedEntity, SearchStepEntity actualEntity) {
        assertEquals(expectedEntity.getId(), actualEntity.getId());
        assertEquals(expectedEntity.getVersion(), actualEntity.getVersion());
        assertEquals(expectedEntity.getName(), actualEntity.getName());
        assertEquals(expectedEntity.getPageUrl(), actualEntity.getPageUrl());
    }

}
