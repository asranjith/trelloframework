package trelloScenario;

import java.io.IOException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.trello.qsp.genericutility.BaseClass;
import com.trello.qsp.genericutility.ListenerClass;
import com.trello.qsp.pomrepo.TrelloBoardsPage;
import com.trello.qsp.pomrepo.TrelloCreatedBoardPage;

@Listeners(ListenerClass.class)

public class EndToEndScenario extends BaseClass {
	
	@Test
	public void createAndDeleteBoard() throws IOException  {
		
		TrelloBoardsPage boardspage=new TrelloBoardsPage(driver);
		TrelloCreatedBoardPage createboardpage=new TrelloCreatedBoardPage(driver);
		/*
		Dont touch this line
		*/
		boardspage.getCreateoption().click();
		boardspage.getCreateboardoption().click();
		boardspage.getBoardtitletextfield().sendKeys(fileutils.readTheDataFromPropertyFile("title"));
		boardspage.getCreatebutton().click();
		webdriverutils.waitUntilElementToBeClickable(driver, createboardpage.getShowMenuButton(), 10);
		createboardpage.getShowMenuButton().click();
		webdriverutils.waitUntilElementToBeClickable(driver, createboardpage.getCloseboardlink(), 10);
		createboardpage.getCloseboardlink().click();
		createboardpage.getCloseoption().click();
		
	}
	

}
