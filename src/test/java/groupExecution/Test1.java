package groupExecution;



import org.testng.annotations.Test;

public class Test1 {
	
  @Test(groups="smoke")
  public void login() {
     System.out.println("login exected");
  }
  @Test(groups="functionality")
  public void logout() {
	  System.out.println("logout exected");
  }
  @Test(groups= {"smoke","functionality"})
  public void home() {
	  System.out.println("home page exected");
  }
}
