package trelloScenario;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.trello.qsp.genericutility.BaseClass;
import com.trello.qsp.genericutility.ListenerClass;
import com.trello.qsp.pomrepo.TrelloBoardsPage;
import com.trello.qsp.pomrepo.TrelloCreatedBoardPage;

@Listeners(ListenerClass.class)
public class TrelloMethodTest extends BaseClass{
  @Test
  public void createSimpleProject() {
	  TrelloBoardsPage boardspage=new TrelloBoardsPage(driver);
	  TrelloCreatedBoardPage createdboardpage=new  TrelloCreatedBoardPage(driver);
	  boardspage.getTemplateButton().click();
	  boardspage.getSimpleprojectboardoption().click();
	  boardspage.getCreatebutton().click();
	  webdriverutils.waitUntilElementToBeClickable(driver,createdboardpage.getBrainstromAddoption() , 10);
	  createdboardpage.getBrainstromAddoption().click();
	  webdriverutils.switchToActiveElement(driver, "brain");
  }

}
