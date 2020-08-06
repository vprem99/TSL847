package day8;

import org.testng.annotations.Test;

import factory.SuggestionsGoogle;
import utils.Base;

public class SuggestionRunner extends Base{
  @Test
  public void f() {
	  driver.get("http://google.com");
	  SuggestionsGoogle sg=new SuggestionsGoogle(driver);
	  sg.printSuggestions("LTI");
  }
}
