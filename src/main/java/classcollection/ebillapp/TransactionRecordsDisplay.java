package classcollection.ebillapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.LinkedList;

public class TransactionRecordsDisplay {

    @FXML
    private Label Amount;

    @FXML
    private Label Consumption;

    @FXML
    private Label Monthly;

    @FXML
    private Label amountDue;

    @FXML
    private Label dueDate;

    @FXML
    private Label paidStatus;

    LinkedList<TransactionHistory> records = new LinkedList<>();


    Customer currentCustomer;

    public void setCustomerDetails(Customer customer) {
        this.currentCustomer = customer;
    }

    public void setTransactionDetails(LinkedList<TransactionHistory> currentRecord) {
        this.records = currentRecord;
        initData();

    }

    public void initialize(){


    }
    public void initData(){
        TransactionHistory details = records.get(0);

        Amount.setText(String.valueOf(records.get(0)));
        Consumption.setText(String.valueOf(records.get(1)));


    }
}
