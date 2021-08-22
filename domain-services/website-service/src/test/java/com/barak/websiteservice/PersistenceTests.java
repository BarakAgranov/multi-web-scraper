package com.barak.websiteservice;

import static org.junit.jupiter.api.Assertions.*;

import com.barak.api.website.action_condition_api.ConditionType;
import com.barak.api.website.element_action_api.ActionType;
import com.barak.api.website.web_element_api.ElementIdentifierType;
import com.barak.api.website.website_api.BrowserType;
import com.barak.websiteservice.entities.*;
import com.barak.websiteservice.repositories.*;
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

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersistenceTests extends MySqlTestBase {

    @Autowired
    private IWebSiteRepository siteRepository;
    @Autowired
    private IWebPageRepository pageRepository;
    @Autowired
    private IWebElementRepository elementRepository;
    @Autowired
    private IElementActionRepository actionRepository;
    @Autowired
    private IActionConditionRepository conditionRepository;

    private WebSiteEntity savedSite;
    private WebPageEntity savedPage;
    private WebElementEntity savedElement;
    private ElementActionEntity savedAction;
    private ActionConditionEntity savedCondition;

    @BeforeEach
    void setupDb() {

        siteRepository.deleteAll();
        pageRepository.deleteAll();
        elementRepository.deleteAll();
        actionRepository.deleteAll();
        conditionRepository.deleteAll();

        WebSiteEntity siteEntity = new WebSiteEntity(1, "a", "b", "c", BrowserType.CHROME);
        WebPageEntity pageEntity = new WebPageEntity(1, "a", "b", "c", siteEntity);
        WebElementEntity elementEntity = new WebElementEntity(1, "a", "b", "c", ElementIdentifierType.CSS_SELECTORS, pageEntity);
        ElementActionEntity actionEntity = new ElementActionEntity(1, "a", "b", ActionType.GET_ELEMENT, "c");
        ActionConditionEntity conditionEntity = new ActionConditionEntity(1, "a", "b", ConditionType.TITLE_IS_PRESENT, (short) 5000, (short) 100);

        savedSite = siteRepository.save(siteEntity);
        assertEqualsSite(siteEntity, savedSite);
        savedPage = pageRepository.save(pageEntity);
        assertEqualsPage(pageEntity, savedPage);
        savedElement = elementRepository.save(elementEntity);
        assertEqualsElement(elementEntity, savedElement);
        savedAction = actionRepository.save(actionEntity);
        assertEqualsAction(actionEntity, savedAction);
        savedCondition = conditionRepository.save(conditionEntity);
        assertEqualsCondition(conditionEntity, savedCondition);
    }

    @Test
    void createSite() {

        WebSiteEntity newEntity = new WebSiteEntity(2, "d", "e", "f", BrowserType.FIREFOX);
        siteRepository.save(newEntity);

        WebSiteEntity foundEntity = siteRepository.findById(newEntity.getId()).get();
        assertEqualsSite(newEntity, foundEntity);

        assertEquals(2, siteRepository.count());
    }

    @Test
    void createPage() {

        WebPageEntity newEntity = new WebPageEntity(2, "d", "e", "f", savedSite);
        pageRepository.save(newEntity);

        WebPageEntity foundEntity = pageRepository.findById(newEntity.getId()).get();
        assertEqualsPage(newEntity, foundEntity);

        assertEquals(2, pageRepository.count());
    }

    @Test
    void createElement() {

        WebElementEntity newEntity = new WebElementEntity(2, "d", "e", "f", ElementIdentifierType.XPATH, savedPage);
        elementRepository.save(newEntity);

        WebElementEntity foundEntity = elementRepository.findById(newEntity.getId()).get();
        assertEqualsElement(newEntity, foundEntity);

        assertEquals(2, elementRepository.count());
    }

    @Test
    void createAction() {

        ElementActionEntity newEntity = new ElementActionEntity(2, "d", "e", ActionType.GET_ELEMENT, "f");
        actionRepository.save(newEntity);

        ElementActionEntity foundEntity = actionRepository.findById(newEntity.getId()).get();
        assertEqualsAction(newEntity, foundEntity);

        assertEquals(2, actionRepository.count());
    }

    @Test
    void createCondition() {

        ActionConditionEntity newEntity = new ActionConditionEntity(2, "c", "d", ConditionType.TITLE_IS_PRESENT,(short)1000, (short)300);
        conditionRepository.save(newEntity);

        ActionConditionEntity foundEntity = conditionRepository.findById(newEntity.getId()).get();
        assertEqualsCondition(newEntity, foundEntity);

        assertEquals(2, conditionRepository.count());
    }

    @Test
    void updateSite() {
        savedSite.setName("t5");
        siteRepository.save(savedSite);

        WebSiteEntity foundEntity = siteRepository.findById(savedSite.getId()).get();
        assertEquals(1, (long)foundEntity.getVersion());
        assertEquals("t5", foundEntity.getName());
    }

    @Test
    void updatePage() {
        savedPage.setName("t5");
        pageRepository.save(savedPage);

        WebPageEntity foundEntity = pageRepository.findById(savedPage.getId()).get();
        assertEquals(1, (long)foundEntity.getVersion());
        assertEquals("t5", foundEntity.getName());
    }

    @Test
    void updateElement() {
        savedElement.setName("t5");
        elementRepository.save(savedElement);

        WebElementEntity foundEntity = elementRepository.findById(savedElement.getId()).get();
        assertEquals(1, (long)foundEntity.getVersion());
        assertEquals("t5", foundEntity.getName());
    }

    @Test
    void updateAction() {
        savedAction.setName("t5");
        actionRepository.save(savedAction);

        ElementActionEntity foundEntity = actionRepository.findById(savedAction.getId()).get();
        assertEquals(1, (long)foundEntity.getVersion());
        assertEquals("t5", foundEntity.getName());
    }

    @Test
    void updateCondition() {
        savedCondition.setName("t5");
        conditionRepository.save(savedCondition);

        ActionConditionEntity foundEntity = conditionRepository.findById(savedCondition.getId()).get();
        assertEquals(1, (long)foundEntity.getVersion());
        assertEquals("t5", foundEntity.getName());
    }

    @Test
    void deleteSite() {
        siteRepository.delete(savedSite);
        assertFalse(siteRepository.existsById(savedSite.getId()));
    }

    @Test
    void deletePage() {
        pageRepository.delete(savedPage);
        assertFalse(pageRepository.existsById(savedPage.getId()));
    }

    @Test
    void deleteElement() {
        elementRepository.delete(savedElement);
        assertFalse(elementRepository.existsById(savedElement.getId()));
    }

    @Test
    void deleteAction() {
        actionRepository.delete(savedAction);
        assertFalse(actionRepository.existsById(savedAction.getId()));
    }

    @Test
    void deleteCondition() {
        conditionRepository.delete(savedCondition);
        assertFalse(conditionRepository.existsById(savedCondition.getId()));
    }

    @Test
    void getSiteById() {
        Optional<WebSiteEntity> entity = siteRepository.findById(savedSite.getId());

        assertTrue(entity.isPresent());
        assertEqualsSite(savedSite, entity.get());
    }

    @Test
    void getPageById() {
        Optional<WebPageEntity> entity = pageRepository.findById(savedPage.getId());

        assertTrue(entity.isPresent());
        assertEqualsPage(savedPage, entity.get());
    }

    @Test
    void getElementById() {
        Optional<WebElementEntity> entity = elementRepository.findById(savedElement.getId());

        assertTrue(entity.isPresent());
        assertEqualsElement(savedElement, entity.get());
    }

    @Test
    void getActionById() {
        Optional<ElementActionEntity> entity = actionRepository.findById(savedAction.getId());

        assertTrue(entity.isPresent());
        assertEqualsAction(savedAction, entity.get());
    }

    @Test
    void getConditionById() {
        Optional<ActionConditionEntity> entity = conditionRepository.findById(savedCondition.getId());

        assertTrue(entity.isPresent());
        assertEqualsCondition(savedCondition, entity.get());
    }

    @Test
    void duplicateError() {
        assertThrows(DuplicateKeyException.class, () -> {
            WebSiteEntity entity = new WebSiteEntity(savedSite.getId(), "w", "t", "f", BrowserType.IE);
            siteRepository.save(entity);
        });
    }

    @Test
    void optimisticLockError() {

        // Store the saved entity in two separate entity objects
        WebSiteEntity entity1 = siteRepository.findById(savedSite.getId()).get();
        WebSiteEntity entity2 = siteRepository.findById(savedSite.getId()).get();

        // Update the entity using the first entity object
        entity1.setName("n1");
        siteRepository.save(entity1);

        // Update the entity using the second entity object.
        // This should fail since the second entity now holds an old version number, i.e. an Optimistic Lock Error
        assertThrows(OptimisticLockingFailureException.class, () -> {
            entity2.setName("n2");
            siteRepository.save(entity2);
        });

        // Get the updated entity from the database and verify its new state
        WebSiteEntity updatedEntity = siteRepository.findById(savedSite.getId()).get();
        assertEquals(1, (int)updatedEntity.getVersion());
        assertEquals("n1", updatedEntity.getName());
    }


    private void assertEqualsSite(WebSiteEntity expectedEntity, WebSiteEntity actualEntity) {
        assertEquals(expectedEntity.getId(), actualEntity.getId());
        assertEquals(expectedEntity.getVersion(), actualEntity.getVersion());
        assertEquals(expectedEntity.getName(), actualEntity.getName());
        assertEquals(expectedEntity.getUrl(), actualEntity.getUrl());
    }

    private void assertEqualsPage(WebPageEntity expectedEntity, WebPageEntity actualEntity) {
        assertEquals(expectedEntity.getId(), actualEntity.getId());
        assertEquals(expectedEntity.getVersion(), actualEntity.getVersion());
        assertEquals(expectedEntity.getName(), actualEntity.getName());
        assertEquals(expectedEntity.getUrl(), actualEntity.getUrl());
    }

    private void assertEqualsElement(WebElementEntity expectedEntity, WebElementEntity actualEntity) {
        assertEquals(expectedEntity.getId(), actualEntity.getId());
        assertEquals(expectedEntity.getVersion(), actualEntity.getVersion());
        assertEquals(expectedEntity.getName(), actualEntity.getName());
        assertEquals(expectedEntity.getIdentifier(), actualEntity.getIdentifier());
        assertEquals(expectedEntity.getIdentifierType(), actualEntity.getIdentifierType());
    }

    private void assertEqualsAction(ElementActionEntity expectedEntity, ElementActionEntity actualEntity) {
        assertEquals(expectedEntity.getId(), actualEntity.getId());
        assertEquals(expectedEntity.getVersion(), actualEntity.getVersion());
        assertEquals(expectedEntity.getName(), actualEntity.getName());
        assertEquals(expectedEntity.getActionInput(), actualEntity.getActionInput());
        assertEquals(expectedEntity.getActionType(), actualEntity.getActionType());
    }

    private void assertEqualsCondition(ActionConditionEntity expectedEntity, ActionConditionEntity actualEntity) {
        assertEquals(expectedEntity.getId(), actualEntity.getId());
        assertEquals(expectedEntity.getVersion(), actualEntity.getVersion());
        assertEquals(expectedEntity.getName(), actualEntity.getName());
        assertEquals(expectedEntity.getConditionType(), actualEntity.getConditionType());
        assertEquals(expectedEntity.getMillisecondsToWait(), actualEntity.getMillisecondsToWait());
        assertEquals(expectedEntity.getMillisecondsToCheck(), actualEntity.getMillisecondsToCheck());
    }
}

