package viewtwo.graphicalcontrollers.home;

import controllers.UserAccessController;
import engineering.LoggedUserSingleton;
import engineering.UserTypes;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import utils.SwitchPage;
import viewtwo.engegnering.MainMenuSingleton;
import viewtwo.popups.MenuPopUp;
import viewtwo.popups.abstracts.MenuPopupInterface;

import java.util.NoSuchElementException;

public class MainMenuController implements MenuPopupInterface {
    @FXML
    public ImageView menu;
    @FXML
    Pane paneSfondo;

    public void setActivity(Node e){
        try{
        paneSfondo.getChildren().removeFirst();
        }catch(NoSuchElementException ignored){}
        paneSfondo.getChildren().add(e);
    }
    @FXML
    void openMenu() {
            if(LoggedUserSingleton.getSingleton().getUserType()== UserTypes.athlete) MenuPopUp.getMenu(this,"MenuPopUpAthlete.fxml","popups",2);
            if(LoggedUserSingleton.getSingleton().getUserType()==UserTypes.pt)MenuPopUp.getMenu(this,"MenuPopUpTrainer.fxml","popups",2);
    }
    public void logout(){
        UserAccessController userAccessController=new UserAccessController();
        userAccessController.logout();
        MainMenuSingleton.getMainMenu().reset();
        SwitchPage.changePage("loginPage.fxml","launcher",2);
    }

}
