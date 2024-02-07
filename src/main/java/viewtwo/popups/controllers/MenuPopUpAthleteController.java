package viewtwo.popups.controllers;

import controllers.UserAccessController;
import exceptions.logger.CostumeLogger;
import javafx.fxml.FXML;
import utils.SwitchPage;
import viewtwo.engegnering.MainMenuSingleton;

import java.io.IOException;

public class MenuPopUpAthleteController extends MenuPopUpController {
    @FXML
    void goToManageMembership() {
        try {
            MainMenuSingleton.getMainMenu().setActivity("ManageMembershipAthlete.fxml", "athlete");
        } catch (IOException e) {
            CostumeLogger.getInstance().logError(e);
        }
        clear();
    }

    @FXML
    void goToProfile() {
        try {
            MainMenuSingleton.getMainMenu().setActivity("PersonInfoPage.fxml", "home");
        } catch (IOException e) {
            CostumeLogger.getInstance().logError(e);
        }
        clear();
    }
    public void logout(){
        UserAccessController userAccessController=new UserAccessController();
        userAccessController.logout();
        MainMenuSingleton.reset();
        SwitchPage.changePage("loginPage.fxml","launcher",2);
        clear();
    }
}
