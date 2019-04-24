package Application.Controllers;

import Application.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;

public class MenuBarController {

    @FXML
    public MenuBar mainMenuBar;

    @FXML
    public void navigateToNewCustomerController(ActionEvent actionEvent) {
        ViewController.NEW_CUSTOMER.reLoad(mainMenuBar.getScene());
    }
}
