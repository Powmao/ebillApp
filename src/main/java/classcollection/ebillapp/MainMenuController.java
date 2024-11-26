package classcollection.ebillapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

public class MainMenuController {
    private HashMap<String, Customer> userDatabase; // Holds the customer database
    private Customer currentCustomer;              // Stores the logged-in customer
    private CustomerTree customerTree;             // Tree to store customers

    private Stage stage;                           // Reference to the application stage
    private Scene scene;                           // Reference to the current scene

    /**
     * Sets the user database and initializes the customer tree.
     */
    public void setUserDatabase(HashMap<String, Customer> userDatabase) {
        this.userDatabase = userDatabase;
        customerTree = new CustomerTree();
        userDatabase.values().forEach(customerTree::insert); // Populate the tree
    }

    /**
     * Sets the current logged-in customer.
     */
    public void setCurrentCustomer(Customer customer) {
        this.currentCustomer = customer;
    }

    /**
     * Loads the ProfileDetails scene and passes customer data.
     */
    @FXML
    void profileButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfileDetails.fxml"));
            Parent root = loader.load();

            // Pass customer data to the ProfileDetailsController
            ProfileDetailsController profileController = loader.getController();
            profileController.setCustomerDetails(currentCustomer);

            loadScene(root, event);
        } catch (IOException e) {
            showErrorAlert("ProfileDetails.fxml", e);
        }
    }

    /**
     * Closes the application after user confirmation.
     */
    @FXML
    void exitButton(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Confirmation");
        alert.setHeaderText("Are you sure you want to exit?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
        }
    }

    /**
     * Placeholder for Bills and Payments feature.
     */
    @FXML
    void billsandpaymentsButton(ActionEvent event) {
        // TODO: Implement this feature in the future
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Feature Under Development");
        alert.setHeaderText(null);
        alert.setContentText("The Bills and Payments feature is currently under development.");
        alert.showAndWait();
    }

    /**
     * Loads the CustomerService scene.
     */
    @FXML
    void customerserviceButton(ActionEvent event) {
        try {
            loadScene("CustomerService.fxml", event);
        } catch (IOException e) {
            showErrorAlert("CustomerService.fxml", e);
        }
    }

    /**
     * Loads the Transaction scene.
     */
    @FXML
    void transactionButton(ActionEvent event) {
        try {
            loadScene("Transaction.fxml", event);
        } catch (IOException e) {
            showErrorAlert("Transaction.fxml", e);
        }
    }

    /**
     * Utility method to load an FXML file and set the scene.
     */
    private void loadScene(String fxmlFile, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        loadScene(root, event);
    }

    /**
     * Helper method to load a scene from a preloaded Parent object.
     */
    private void loadScene(Parent root, ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Displays an error alert in case of an FXML loading failure.
     */
    private void showErrorAlert(String fxmlFile, IOException e) {
        System.err.println("Failed to load " + fxmlFile + ": " + e.getMessage());
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Scene Loading Error");
        alert.setContentText("Could not load the requested scene: " + fxmlFile);
        alert.showAndWait();
    }
}
