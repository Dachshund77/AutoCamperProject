package Application;

import Application.Controllers.Controllers;
import UI.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Can be used to change the scenes easily.
 * The enum class will store the relative path to the fxml so that we don't need to type it multiple times.
 */
public enum ViewController {
    WELCOME_CONTROLLER("Model/Welcome.fxml"),
    NEW_CUSTOMER("Model/NewCustomer.fxml");


    private final String URL;

    ViewController(String url) {
        this.URL = url;
    }

    /**
     * Loads a new scene.
     * The scene URL is defined in the Enum constructor.
     *
     * @param stage The stage where the scene will be loaded
     */
    public void load(Stage stage) { //TODO figure out weird as bug about resizing
        try {
            Parent root = FXMLLoader.load(getClass().getResource(URL));
            Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads a new scene and passes a value to the new controller.
     * The scene URL is defined in the Enum constructor.
     * <br><br>
     * <p>
     * <font color="red">
     * IMPORTANT:
     * </font>
     * In order to pass a value the new controller needs to extends the 'Controller' abstract class and override its methods.
     * </p>
     * @param stage Stage where the scene will be loaded in
     * @param string Value that will passed on to the controller
     * @see Application.Controllers.Controller
     * @see Main
     */
            /*
            If another parameter needs to passed follow thees steps:
            1) Create a initValues( - your parameters -) in the Controllers interface
            2) Create the same initValues in the Abstract class Controller, and please keep the style of error messages
            3) Copy paste this method in here and change the parameter
            4) Make sure you call the correct initValues in this method
            */
    public void load(Stage stage, String string) {
        load(stage);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(URL));
        Controllers newController = loader.getController();
        newController.initValues(string);


    }
}
