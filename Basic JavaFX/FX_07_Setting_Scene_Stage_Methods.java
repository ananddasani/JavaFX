package sample;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FX_07_Setting_Scene_Stage_Methods extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Button btn;
    @Override
    public void start(Stage primaryStage) {

        btn = new Button("Click Me !!");

        //set the control in layout layout
        BorderPane pane = new BorderPane(btn);


    }
}
