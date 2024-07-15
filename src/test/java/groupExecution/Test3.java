package groupExecution;

import org.testng.annotations.Test;

public class Test3 {
  @Test(groups="smoke")
  public void createBoard() {
	  System.out.println("createdBoard exected");
	  
  }
  @Test(groups="smoke")
  public void deleteBoard() {
	  System.out.println("deleteBoard exected");
  }
}
