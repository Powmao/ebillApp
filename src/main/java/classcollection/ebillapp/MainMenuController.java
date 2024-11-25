package classcollection.ebillapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class MainMenuController {
    private HashMap<String, Customer> userDatabase;
    private Customer currentCustomer; // To store the logged-in customer

    private CustomerTree customerTree; // Tree to store customers

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void setUserDatabase(HashMap<String, Customer> userDatabase) {
        this.userDatabase = userDatabase;
        // Insert all customers into the tree
        customerTree = new CustomerTree();
        userDatabase.values().forEach(customerTree::insert);
    }

    public void setCurrentCustomer(Customer customer) {
        this.currentCustomer = customer;
    }


    @FXML
    void profileButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProfileDetails.fxml"));
        root = loader.load();

        ProfileDetailsController profileController = loader.getController();
        profileController.setCustomerDetails(currentCustomer);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void exitButton(ActionEvent event) {
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }

    @FXML
    void billsandpaymentsButton(ActionEvent event) {
    }

    @FXML
    void customerserviceButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerService.fxml"));
        Parent root2 = loader.load();


        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root2);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void transactionButton(ActionEvent event) {
    }
}
