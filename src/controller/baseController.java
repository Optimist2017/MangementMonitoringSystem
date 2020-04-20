package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class baseController {

    @FXML private VBox container;

    @FXML private void loadcontent(String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/"+fxml+".fxml"));
        container.getChildren().clear();
        container.getChildren().add(root);
        VBox.setVgrow(root, Priority.ALWAYS);
    }

    @FXML private void loadcontent1(String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view1/"+fxml+".fxml"));
        container.getChildren().clear();
        container.getChildren().add(root);
        VBox.setVgrow(root, Priority.ALWAYS);
    }

    @FXML private void loadshop() throws IOException {
        loadcontent("product");
    }

    @FXML private void loadwareproducts() throws IOException {
        loadcontent1("products");

    }

    @FXML private void loadsemployees() throws IOException {
        loadcontent("employee");
    }

    @FXML private void loadwemployees() throws IOException {
        loadcontent1("employee");
    }

    @FXML private void loadwlogs() throws IOException {
        loadcontent("log");
    }
    @FXML private void loadslogs() throws IOException {
        loadcontent("saleslog");
    }

    @FXML private void loadshopsales() throws IOException {
        loadcontent("sales");
    }
    @FXML private void loadwsales() throws IOException {
        loadcontent1("salespoint");
    }
    @FXML private void loadwreport() throws IOException {
        loadcontent("wreport");
    }
    @FXML private void loadsreport() throws IOException {
        loadcontent1("sreport");
    }
    @FXML private void loadireport() throws IOException {
        loadcontent("inventoryreport");
    }
}
