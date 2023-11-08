package viewone.graphical_controllers.gym;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import utils.MainStage;
import utils.SwitchPage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class GymEquipmentGUIController implements Initializable {

    @FXML
    private ListView<String> athletesList;

    @FXML
    public void goBack() throws Exception {
        String path = "/viewone/gym/GymHome.fxml";
        SwitchPage.setStage(MainStage.getStage(),"GymRegistrationUser.fxml","gym",1);
    }

    @FXML
    public void goForward() throws Exception {
        SwitchPage.setStage(MainStage.getStage(),"GymRegistrationUser.fxml","gym",1);
    }


    @FXML
    public void addEquipment() throws Exception {
        //TODO fai la GUI appropriata
        SwitchPage.setStage(MainStage.getStage(),"GymRegistrationUser.fxml","gym",1);
    }

    public void logout() throws Exception {
        SwitchPage.setStage(MainStage.getStage(),"GymFirst.fxml","launcher",1);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> lista = new ArrayList<>(Arrays.asList("Panca Piana", "Panca Inclinata", "Lat Machine"));
        athletesList.getItems().addAll(lista);
    }
}
