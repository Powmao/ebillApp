package classcollection.ebillapp;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.io.IOException;

public class TransactionRecordsController {


    @FXML
    private BorderPane borderPane;

    @FXML
    private void Return(){
        HelloApplication mainApp =  new HelloApplication();
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(e->{
            try{
                mainApp.changeScene("MainMenu.fxml");
            }catch (IOException ex){
                throw new RuntimeException(ex);
            }
        });
        pause.play();
    }

    @FXML
    private void ViewInfo() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/classcollection/ebillapp/TransactionInfo.fxml"));
            Parent view = loader.load();



            borderPane.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace(); // Log error details for debugging
            showErrorAlert("TransactionInfo.fxml", e);
        }
    }

    /**
     * Utility method to show an error alert.
     */
    private void showErrorAlert(String fileName, Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Failed to Load FXML");
        alert.setContentText("Could not load " + fileName + ".\n" + e.getMessage());
        alert.showAndWait();
    }






}
