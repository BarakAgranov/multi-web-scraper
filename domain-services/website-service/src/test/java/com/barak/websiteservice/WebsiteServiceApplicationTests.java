package com.barak.websiteservice;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static reactor.core.publisher.Mono.just;

import com.barak.api.website.action_condition_api.ActionConditionDto;
import com.barak.api.website.element_action_api.ElementActionDto;
import com.barak.api.website.web_element_api.WebElementDto;
import com.barak.api.website.webpage_api.WebPageDto;
import com.barak.api.website.website_api.WebSiteDto;
import com.barak.util.exceptions.ErrorType;
import com.barak.websiteservice.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class WebsiteServiceApplicationTests extends MySqlTestBase{

	@Autowired
	private WebTestClient client;

	@Autowired
	private IWebSiteRepository webSiteRepository;
	@Autowired
	private IWebPageRepository webPageRepository;
	@Autowired
	private IWebElementRepository webElementRepository;
	@Autowired
	private IElementActionRepository elementActionRepository;
	@Autowired
	private IActionConditionRepository actionConditionRepository;

	@BeforeEach
	void setupDb() {
		webSiteRepository.deleteAll();
		webPageRepository.deleteAll();
		webElementRepository.deleteAll();
		elementActionRepository.deleteAll();
		actionConditionRepository.deleteAll();
	}

	@Test
	void getWebSiteById() {

		int websiteId = 1;

		postAndVerifyWebSite(websiteId, 200);

		assertTrue(webSiteRepository.findById(websiteId).isPresent());

		getAndVerifyWebSite(websiteId, 200).jsonPath("$.websiteId").isEqualTo(websiteId);

	}

	@Test
	void webSiteDuplicateError() {

		int websiteId = 1;

		postAndVerifyWebSite(websiteId, 200);

		assertTrue(webSiteRepository.findById(websiteId).isPresent());

		postAndVerifyWebSite(websiteId, 801)
				.jsonPath("$.path").isEqualTo("/website")
				.jsonPath("$.message").isEqualTo("Website with this ID already exist: " + websiteId);
	}

	@Test
	void deleteWebSite() {
		int websiteId = 1;

		postAndVerifyWebSite(websiteId, 200);
		assertTrue(webSiteRepository.findById(websiteId).isPresent());

		deleteAndVerifyWebsite(websiteId, 200);
		assertFalse(webSiteRepository.findById(websiteId).isPresent());

	}

	@Test
	void getWebSiteNotFound() {

		int websiteIdNotFound = 13;
		getAndVerifyWebSite(websiteIdNotFound, 803)
				.jsonPath("$.path").isEqualTo("/website/" + websiteIdNotFound)
				.jsonPath("$.message").isEqualTo("Website With this ID could not be found: " + websiteIdNotFound);
	}

	@Test
	void getPageById() {

		int pageId = 1;

		postAndVerifyPage(pageId, 200);

		assertTrue(webPageRepository.findById(pageId).isPresent());

		getAndVerifyPage(pageId, 200).jsonPath("$.pageId").isEqualTo(pageId);

	}

	@Test
	void pageDuplicateError() {

		int pageId = 1;

		postAndVerifyPage(pageId, 200);

		assertTrue(webPageRepository.findById(pageId).isPresent());

		postAndVerifyPage(pageId, 801)
				.jsonPath("$.path").isEqualTo("/page")
				.jsonPath("$.message").isEqualTo("Web page with this ID already exist: " + pageId);
	}

	@Test
	void deletePage() {
		int pageId = 1;

		postAndVerifyPage(pageId, 200);
		assertTrue(webPageRepository.findById(pageId).isPresent());

		deleteAndVerifyPage(pageId, 200);
		assertFalse(webPageRepository.findById(pageId).isPresent());

	}

	@Test
	void getPageNotFound() {

		int pageIdNotFound = 13;
		getAndVerifyPage(pageIdNotFound, 803)
				.jsonPath("$.path").isEqualTo("/page/" + pageIdNotFound)
				.jsonPath("$.message").isEqualTo("Web page With this ID could not be found: " + pageIdNotFound);
	}

	@Test
	void getElementById() {

		int elementId = 1;

		postAndVerifyElement(elementId, 200);

		assertTrue(webElementRepository.findById(elementId).isPresent());

		getAndVerifyElement(elementId, 200).jsonPath("$.elementId").isEqualTo(elementId);

	}

	@Test
	void elementDuplicateError() {

		int elementId = 1;

		postAndVerifyElement(elementId, 200);

		assertTrue(webElementRepository.findById(elementId).isPresent());

		postAndVerifyElement(elementId, 801)
				.jsonPath("$.path").isEqualTo("/element")
				.jsonPath("$.message").isEqualTo("Web element with this ID already exist: " + elementId);
	}

	@Test
	void deleteElement() {
		int elementId = 1;

		postAndVerifyElement(elementId, 200);
		assertTrue(webElementRepository.findById(elementId).isPresent());

		deleteAndVerifyElement(elementId, 200);
		assertFalse(webElementRepository.findById(elementId).isPresent());

	}

	@Test
	void getElementNotFound() {

		int elementIdNotFound = 13;
		getAndVerifyElement(elementIdNotFound, 803)
				.jsonPath("$.path").isEqualTo("/element/" + elementIdNotFound)
				.jsonPath("$.message").isEqualTo("Web element With this ID could not be found: " + elementIdNotFound);
	}

	@Test
	void getActionById() {

		int actionId = 1;

		postAndVerifyAction(actionId, 200);

		assertTrue(elementActionRepository.findById(actionId).isPresent());

		getAndVerifyAction(actionId, 200).jsonPath("$.actionId").isEqualTo(actionId);

	}

	@Test
	void actionDuplicateError() {

		int actionId = 1;

		postAndVerifyAction(actionId, 200);

		assertTrue(elementActionRepository.findById(actionId).isPresent());

		postAndVerifyAction(actionId, 801)
				.jsonPath("$.path").isEqualTo("/action")
				.jsonPath("$.message").isEqualTo("Action with this ID already exist: " + actionId);
	}

	@Test
	void deleteAction() {
		int actionId = 1;

		postAndVerifyAction(actionId, 200);
		assertTrue(elementActionRepository.findById(actionId).isPresent());

		deleteAndVerifyAction(actionId, 200);
		assertFalse(elementActionRepository.findById(actionId).isPresent());

	}

	@Test
	void getActionNotFound() {

		int actionIdNotFound = 13;
		getAndVerifyAction(actionIdNotFound, 803)
				.jsonPath("$.path").isEqualTo("/action/" + actionIdNotFound)
				.jsonPath("$.message").isEqualTo("Element action With this ID could not be found: " + actionIdNotFound);
	}

	@Test
	void getConditionById() {

		int conditionId = 1;

		postAndVerifyCondition(conditionId, 200);

		assertTrue(actionConditionRepository.findById(conditionId).isPresent());

		getAndVerifyCondition(conditionId, 200).jsonPath("$.websiteId").isEqualTo(conditionId);

	}

	@Test
	void conditionDuplicateError() {

		int conditionId = 1;

		postAndVerifyCondition(conditionId, 200);

		assertTrue(actionConditionRepository.findById(conditionId).isPresent());

		postAndVerifyCondition(conditionId, 801)
				.jsonPath("$.path").isEqualTo("/condition")
				.jsonPath("$.message").isEqualTo("Condition with this ID already exist: " + conditionId);
	}

	@Test
	void deleteCondition() {
		int conditionId = 1;

		postAndVerifyCondition(conditionId, 200);
		assertTrue(actionConditionRepository.findById(conditionId).isPresent());

		deleteAndVerifyCondition(conditionId, 200);
		assertFalse(actionConditionRepository.findById(conditionId).isPresent());

	}

	@Test
	void getConditionNotFound() {

		int conditionIdIdNotFound = 13;
		getAndVerifyCondition(conditionIdIdNotFound, 803)
				.jsonPath("$.path").isEqualTo("/condition/" + conditionIdIdNotFound)
				.jsonPath("$.message").isEqualTo("Condition With this ID could not be found: " + conditionIdIdNotFound);
	}



	private WebTestClient.BodyContentSpec getAndVerifyWebSite(int websiteId, int expectedStatus) {
		return getAndVerifyWebSite("/" + websiteId, expectedStatus);
	}

	private WebTestClient.BodyContentSpec getAndVerifyWebSite(String websiteIdPath, int expectedStatus) {
		return client.get()
				.uri("/website" + websiteIdPath).accept()
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec postAndVerifyWebSite(int websiteId, int expectedStatus) {
		WebSiteDto website = new WebSiteDto(websiteId, "Name " + websiteId, "a", "b", "c");
		return client.post()
				.uri("/website")
				.body(just(website), WebSiteDto.class)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec deleteAndVerifyWebsite(int websiteId, int expectedStatus) {
		return client.delete()
				.uri("/website/" + websiteId)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec getAndVerifyPage(int pageId, int expectedStatus) {
		return getAndVerifyPage("/" + pageId, expectedStatus);
	}

	private WebTestClient.BodyContentSpec getAndVerifyPage(String pageIdPath, int expectedStatus) {
		return client.get()
				.uri("/page" + pageIdPath).accept()
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec postAndVerifyPage(int pageId, int expectedStatus) {
		WebPageDto page = new WebPageDto(pageId, "Name " + pageId, "a", "b", 1);
		return client.post()
				.uri("/page")
				.body(just(page), WebPageDto.class)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec deleteAndVerifyPage(int pageId, int expectedStatus) {
		return client.delete()
				.uri("/page/" + pageId)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec getAndVerifyElement(int elementId, int expectedStatus) {
		return getAndVerifyElement("/" + elementId, expectedStatus);
	}

	private WebTestClient.BodyContentSpec getAndVerifyElement(String elementIdPath, int expectedStatus) {
		return client.get()
				.uri("/element" + elementIdPath).accept()
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec postAndVerifyElement(int elementId, int expectedStatus) {
		WebElementDto element = new WebElementDto(elementId, "Name " + elementId, "a", "b", "c", 1);
		return client.post()
				.uri("/element")
				.body(just(element), WebElementDto.class)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec deleteAndVerifyElement(int elementId, int expectedStatus) {
		return client.delete()
				.uri("/element/" + elementId)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec getAndVerifyAction(int actionId, int expectedStatus) {
		return getAndVerifyAction("/" + actionId, expectedStatus);
	}

	private WebTestClient.BodyContentSpec getAndVerifyAction(String actionIdPath, int expectedStatus) {
		return client.get()
				.uri("/action" + actionIdPath).accept()
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec postAndVerifyAction(int actionId, int expectedStatus) {
		ElementActionDto action = new ElementActionDto(actionId, "Name " + actionId, "a", "b", "c");
		return client.post()
				.uri("/action")
				.body(just(action), ElementActionDto.class)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec deleteAndVerifyAction(int actionId, int expectedStatus) {
		return client.delete()
				.uri("/action/" + actionId)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec getAndVerifyCondition(int conditionId, int expectedStatus) {
		return getAndVerifyCondition("/" + conditionId, expectedStatus);
	}

	private WebTestClient.BodyContentSpec getAndVerifyCondition(String conditionIdPath, int expectedStatus) {
		return client.get()
				.uri("/condition" + conditionIdPath).accept()
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec postAndVerifyCondition(int conditionId, int expectedStatus) {
		ActionConditionDto condition = new ActionConditionDto(conditionId, "Name " + conditionId, "a", "b", (short)3000, (short)200);
		return client.post()
				.uri("/conditionId")
				.body(just(conditionId), ActionConditionDto.class)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec deleteAndVerifyCondition(int conditionId, int expectedStatus) {
		return client.delete()
				.uri("/condition/" + conditionId)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectBody();
	}

}
