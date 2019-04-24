package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../Application/Model/Welcome.fxml"));
        Scene scene = new Scene(root,850,850);
        primaryStage.setScene(scene);

        primaryStage.setTitle("AutoCamper Application");
        primaryStage.show();
        //TODO popper close on exist
    }

    public static void main(String[] args) {
        launch(args);
    }

}
