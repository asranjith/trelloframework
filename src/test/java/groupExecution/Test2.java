package groupExecution;

import org.testng.annotations.Test;

public class Test2 {
  @Test(groups="integration")
  public void boardsPage() {
	  System.out.println("boardsPage Executed");
  }
  @Test(groups="functionality")
  public void createPage() {
	  System.out.println("createPage exected"); 
  }
}
