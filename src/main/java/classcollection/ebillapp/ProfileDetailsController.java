package classcollection.ebillapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class ProfileDetailsController {

    @FXML
    private BorderPane borderPane;
    @FXML
    private TreeView<String> profileTreeView;

    private Customer currentCustomer;
    @FXML
    public void initialize() {
        initializeTreeView();

    }

    public void setCustomerDetails(Customer customer) {
        this.currentCustomer = customer;
        initializeTreeView();
    }

    private void initializeTreeView() {
        TreeItem<String> rootItem = new TreeItem<>("Customer Profile");
        rootItem.setExpanded(true);

        TreeItem<String> billingInfoItem = new TreeItem<>("Billing Information");
        TreeItem<String> usageDataItem = new TreeItem<>("Usage Data");
        TreeItem<String> basicInformation = new TreeItem<>("Basic Information");

        rootItem.getChildren().addAll(billingInfoItem, usageDataItem, basicInformation);

        profileTreeView.setRoot(rootItem);
    }

    @FXML
    void selectItem(MouseEvent event) throws IOException {
        TreeItem<String> item = profileTreeView.getSelectionModel().getSelectedItem();
        if (item != null && "Basic Information".equals(item.getValue())) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/classcollection/ebillapp/BasicInformation.fxml"));
            Parent view = loader.load();

            BasicInformationController controller = loader.getController();
            controller.setCustomer(currentCustomer);
            borderPane.setCenter(view); // Use setCenter instead of setAll for BorderPane
        }
    }
}
