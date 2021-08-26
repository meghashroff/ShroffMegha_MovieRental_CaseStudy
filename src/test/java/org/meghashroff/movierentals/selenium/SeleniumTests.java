package org.meghashroff.movierentals.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
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
class SeleniumTests {
	
	private WebDriver driver;
	
	@Autowired
	public SeleniumTests(WebDriver driver) {
		this.driver = driver;
	}
	
//	@Test
//	@Disabled
//	void testLoginPage() {
//		// Opens the login page for this web application
//		driver.get("http://localhost:8080/");
//		assertEquals("Login Page", driver.getTitle());
//	}
//	
	@Test
	void testLogin() throws InterruptedException {
		driver.get("http://localhost:8080/movierentals");
		
//		WebElement usernameInput = driver.findElement(By.cssSelector("body > h1"));
//		usernameInput.sendKeys("ALL THE MOVIES IN ONE PLACE");
		
//		WebElement passwordInput = driver.findElement(By.cssSelector("body > form > div:nth-child(2) > input[type=text]"));
//		passwordInput.sendKeys("john1234");
//	
//		Thread.sleep(3000);
//		
//		driver.findElement(By.cssSelector("body > h1"));
//		WebElement welcomeMessage = driver.findElement(By.cssSelector("body > h2"));
//		
//		Thread.sleep(3000);
//		assertEquals("Home Page", driver.getTitle());
//		assertTrue(welcomeMessage.getText().contains("ALL THE MOVIES IN ONE PLACE"));

	}
}