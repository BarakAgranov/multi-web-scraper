package com.barak.searchservice;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static reactor.core.publisher.Mono.just;

import com.barak.api.search.search_api.SearchDto;
import com.barak.api.search.search_step_api.SearchStepDto;
import com.barak.searchservice.repositories.ISearchRepository;
import com.barak.searchservice.repositories.ISearchStepRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class SearchServiceApplicationTests extends MySqlTestBase{



	@Autowired
	private WebTestClient client;

	@Autowired
	private ISearchRepository searchRepository;
	@Autowired
	private ISearchStepRepository stepRepository;


	@BeforeEach
	void setupDb() {
		searchRepository.deleteAll();
		stepRepository.deleteAll();
	}

	@Test
	void getSearchById() {

		int searchId = 1;

		postAndVerifySearch(searchId, 200);

		assertTrue(searchRepository.findById(searchId).isPresent());

		getAndVerifySearch(searchId, 200).jsonPath("$.searchId").isEqualTo(searchId);

	}

	@Test
	void searchDuplicateError() {

		int searchId = 1;

		postAndVerifySearch(searchId, 200);

		assertTrue(searchRepository.findById(searchId).isPresent());

		postAndVerifySearch(searchId, 801)
				.jsonPath("$.path").isEqualTo("/search")
				.jsonPath("$.message").isEqualTo("Search with this ID already exist: " + searchId);
	}

	@Test
	void deleteSearch() {
		int searchId = 1;

		postAndVerifySearch(searchId, 200);
		assertTrue(searchRepository.findById(searchId).isPresent());

		deleteAndVerifySearch(searchId, 200);
		assertFalse(searchRepository.findById(searchId).isPresent());

	}

	@Test
	void getSearchNotFound() {

		int searchIdNotFound = 13;
		getAndVerifySearch(searchIdNotFound, 803)
				.jsonPath("$.path").isEqualTo("/search/" + searchIdNotFound)
				.jsonPath("$.message").isEqualTo("Search With this ID could not be found: " + searchIdNotFound);
	}

	@Test
	void getStepById() {

		long stepId = 1;

		postAndVerifyStep(stepId, 200);

		assertTrue(stepRepository.findById(stepId).isPresent());

		getAndVerifyStep(stepId, 200).jsonPath("$.stepId").isEqualTo(stepId);

	}

	@Test
	void stepDuplicateError() {

		long stepId = 1;

		postAndVerifyStep(stepId, 200);

		assertTrue(stepRepository.findById(stepId).isPresent());

		postAndVerifyStep(stepId, 801)
				.jsonPath("$.path").isEqualTo("/step")
				.jsonPath("$.message").isEqualTo("Step with this ID already exist: " + stepId);
	}

	@Test
	void deleteStep() {
		long stepId = 1;

		postAndVerifyStep(stepId, 200);
		assertTrue(stepRepository.findById(stepId).isPresent());

		deleteAndVerifyStep(stepId, 200);
		assertFalse(stepRepository.findById(stepId).isPresent());

	}

	@Test
	void getStepNotFound() {

		long stepIdNotFound = 13;
		getAndVerifyStep(stepIdNotFound, 803)
				.jsonPath("$.path").isEqualTo("/step/" + stepIdNotFound)
				.jsonPath("$.message").isEqualTo("Step With this ID could not be found: " + stepIdNotFound);
	}

	private WebTestClient.BodyContentSpec getAndVerifySearch(int searchId, int expectedStatus) {
		return getAndVerifySearch("/" + searchId, expectedStatus);
	}

	private WebTestClient.BodyContentSpec getAndVerifySearch(String searchIdPath, int expectedStatus) {
		return client.get()
				.uri("/search" + searchIdPath).accept()
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec postAndVerifySearch(int searchId, int expectedStatus) {
		SearchDto search = new SearchDto(1, "a", "b", 2, "c", "d", "e");
		return client.post()
				.uri("/search")
				.body(just(search), SearchDto.class)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec deleteAndVerifySearch(int searchId, int expectedStatus) {
		return client.delete()
				.uri("/search/" + searchId)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec getAndVerifyStep(long stepId, int expectedStatus) {
		return getAndVerifyStep("/" + stepId, expectedStatus);
	}

	private WebTestClient.BodyContentSpec getAndVerifyStep(String stepIdPath, int expectedStatus) {
		return client.get()
				.uri("/step" + stepIdPath).accept()
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec postAndVerifyStep(long stepId, int expectedStatus) {
		SearchStepDto step = new SearchStepDto(stepId, "a", 2, "b", "c", 3, "d", "e", "f", 4, "g", "h", "i", 5, "j", "k", 5000, 300);
		return client.post()
				.uri("/step")
				.body(just(step), SearchStepDto.class)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec deleteAndVerifyStep(long stepId, int expectedStatus) {
		return client.delete()
				.uri("/step/" + stepId)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectBody();
	}


}
