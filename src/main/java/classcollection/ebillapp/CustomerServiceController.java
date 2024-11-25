package classcollection.ebillapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.PriorityQueue;

public class CustomerServiceController {

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    @FXML
    private TextArea TextArea;

    @FXML
    private Label TicketNumber;


    @FXML
    public void initialize(){



    }

    @FXML
    void generateTicket(ActionEvent event) {

        int randomNum = (int)(Math.random() * 101);  // 0 to 100
        TextArea.setText("Your ticked number is :" + randomNum);
        TextArea.setText("Waiting in line....");
        TicketNumber.setText(String.valueOf(randomNum));

    }



}
