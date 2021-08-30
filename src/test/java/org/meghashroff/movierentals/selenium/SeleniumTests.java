package org.meghashroff.movierentals.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meghashroff.movierentals.config.WebAppConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WebAppConfig.class })
@WebAppConfiguration("webapp")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SeleniumTests {
	
	private WebDriver driver;
	
	@Autowired
	public SeleniumTests(WebDriver driver) {
		this.driver = driver;
	}
	
	@Test
	void testHomePage() throws InterruptedException {
		driver.get("http://localhost:8080/movierentals");
		assertEquals("Home Page", driver.getTitle());

	}
	
	@Test
	void testHeadingInHomePage() throws InterruptedException {
		driver.get("http://localhost:8080/movierentals");
		WebElement welcomeMessage = driver.findElement(By.cssSelector("body > h1"));
		assertTrue(welcomeMessage.getText().contains("ALL THE MOVIES IN ONE PLACE!"));
	}
}