package org.meghashroff.movierentals.services;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.meghashroff.movierentals.selenium.SeleniumTests;

@RunWith(JUnitPlatform.class)
@SelectClasses({UserIT.class, RentalTransactionIT.class, MovieIT.class, UsersMockitoTest.class, MoviesMockitoTest.class, SeleniumTests.class})
@IncludeClassNamePatterns({"^.*IT?$", "^.*Test?$", "^.*Tests?$"})
public class SuiteTest {

}
