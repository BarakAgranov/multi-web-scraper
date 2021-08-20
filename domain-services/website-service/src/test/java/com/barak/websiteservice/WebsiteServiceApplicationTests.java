package com.barak.websiteservice;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import com.barak.websiteservice.repositories.IWebSiteRepository;
import org.junit.Assert;
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

	@BeforeEach
	void setupDb() {
		webSiteRepository.deleteAll();
	}

//	@Test
//	void getWebSite() {
//
//		int websiteId = 1;
//
//		Assert.assertEquals(0,webSiteRepository.findById());
//	}

}
