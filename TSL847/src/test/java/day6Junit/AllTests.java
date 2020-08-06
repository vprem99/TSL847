package day6Junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CookieTest.class, MyFirstJunit_Test.class, Title_Test.class, CookieFronAccounting.class })
public class AllTests {

}