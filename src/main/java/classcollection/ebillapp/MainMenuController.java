package classcollection.ebillapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    void exitButton(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    @FXML
    void billsandpaymentsButton(ActionEvent event) {

    }

    @FXML
    void customerserviceButton(ActionEvent event) {

    }

    @FXML
    void profileButton(ActionEvent event) {

    }

    @FXML
    void transactionButton(ActionEvent event) {

    }

}
