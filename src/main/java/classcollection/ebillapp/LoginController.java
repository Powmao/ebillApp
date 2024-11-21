package classcollection.ebillapp;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

public class LoginController {

    private HashMap<String, Customer> userDatabase = new HashMap<>();

    @FXML
    private TextField Name;

    @FXML
    private PasswordField Password;

    @FXML
    private Label loginStatus;

    @FXML
    public void initialize() {
        readcustomerData();
    }

    @FXML
    void loginButton(ActionEvent event) {
        String username = Name.getText();
        String password = Password.getText();

        if (userDatabase.containsKey(username)) {
            if (userDatabase.get(username).getPassword().equals(password)) {
                loginStatus.setVisible(true);
                loginStatus.setText("Login Successfully");

                PauseTransition pause = getPauseTransition();
                pause.play();

            } else {
                loginStatus.setVisible(true);
                loginStatus.setText("Login Failed. Try Again!");
                Name.clear();
                Password.clear();
            }
        } else {
            loginStatus.setVisible(true);
            loginStatus.setText("Account not existed");
        }
    }

    private PauseTransition getPauseTransition() {
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = (Stage) loginStatus.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        return pause;
    }

    private void readcustomerData() {
        try {
            InputStream file = getClass().getClassLoader().getResourceAsStream("Customer.txt");
            if (file == null) {
                throw new FileNotFoundException("File not found: " + "Customer.txt");
            }

            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(",");

                String fullName = data[0];
                String userName = data[1];
                String password = data[2];
                int customerId = Integer.parseInt((data[3]));
                String customerAddress = data[4];


                // Create a Pokemon object and add it to your collection
                Customer profile = new Customer(fullName, userName, password,  customerId,  customerAddress);
                userDatabase.put(profile.getUsername(), profile);
            }
            fileScanner.close();
            System.out.println("File read successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + "Customer.txt.txt");
        } catch (Exception e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }


}
