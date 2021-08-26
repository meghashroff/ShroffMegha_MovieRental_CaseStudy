package org.meghashroff.movierentals.selenium;


import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meghashroff.movierentals.config.WebAppConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@Configuration
public class SeleniumConfig {
	
	@Bean
	public WebDriver getWebDriver(Environment env) {
//		System.setProperty("webdriver.chrome.driver", env.getProperty("selenium.path"));
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rites\\OneDrive\\Documents\\Megha\\selenium\\chromedriver.exe"); // "[folder]\\chromedriver.exe"
//		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe"); // "[folder]\\chromedriver.exe"
		
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
}