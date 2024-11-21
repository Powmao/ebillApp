module classcollection.ebillapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens classcollection.ebillapp to javafx.fxml;
    exports classcollection.ebillapp;
}