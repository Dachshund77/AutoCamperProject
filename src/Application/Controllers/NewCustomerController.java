package Application.Controllers;

import Domain.Zip;
import Foundation.DB;
import Persistance.DbFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class NewCustomerController {
    @FXML public TextField addressTextfield;
    @FXML public TextField eMailTextField;
    @FXML public TextField phoneTextField;
    @FXML public TextField nameTextField;
    @FXML public MenuButton zipMenuButton;
    @FXML public TextField zipTextField;

    private ArrayList<Zip> allZips;
    private Zip selectedZip;

    public void initialize(){
        try {
            DB.connect();
            //Get all Zips
            allZips = DbFacade.getAllZip();
            for (Zip zip : allZips) {
                addMenuItemToZipMenuButton(zip);
            }
        } finally {
            DB.disconnect();
        }
    }


    @FXML
    public void finishNewCustomer(ActionEvent actionEvent) {
        //First validation
    }

    public void navigateToNewZipController(ActionEvent actionEvent) {
    }

    public void selectZip(Zip zip) {
        selectedZip = zip;
        zipMenuButton.setText(zip.getZip());
        zipTextField.setText(zip.getCity());
    }

    private void addMenuItemToZipMenuButton(Zip addedZip){ //TODO this might bug out severely if enough zips are selected
        MenuItem newMenuItem = new MenuItem(addedZip.getZip());
        newMenuItem.setOnAction(event -> selectZip(addedZip));
        zipMenuButton.getItems().add(newMenuItem);
    }

    public void test(MouseEvent mouseEvent) {
        System.out.println("test2");
    }
}
