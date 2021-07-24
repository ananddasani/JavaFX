/*
Program to count the clicking of button and to learn about labels

The Click me counter app will count the clicking of button by the user
 */
package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FX_02_ClickMe_Counter extends Application {

    public static void main(String[] args) {

        System.out.println("Launching ClickMe Counter App");
        launch(args);
        System.out.println("Finished");
    }

    //create a button
    Button button;

    //create a label
    Label label;

    //the counter
    int clicks = 0;

    @Override
    public void start(Stage primaryStage) {

        //create a button
        button = new Button();
        button.setText("Click Me.");
        button.setOnAction(e -> buttonClicked());

        //create a label
        label = new Label();
        label.setText("You didn't clicked the button :(");

        //create layout and set the button inside it
        BorderPane pane = new BorderPane();
        pane.setCenter(button);
        pane.setTop(label);

        //put layout in a scene
        Scene scene = new Scene(pane, 300, 200);

        //put the scene in the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Click Me Counter App");
        primaryStage.show();
    }

    /**
     * Method to handle event
     */
    public void buttonClicked() {
        clicks++;
        if (clicks == 1)
            label.setText("You Clicked Once !!");
        else
            label.setText("You clicked button " + clicks + " Times :)");
    }
}


/*
NOTES

1.  The ClickMe class extends javafx.application.Application,
    thus specifying that the ClickMe class is a JavaFX application.

2.  The declaration of the start method uses the @override annotation, indicating that this method overrides the default start
    method provided by the Application class. The start method
    accepts a parameter named primaryStage, which represents
    the window in which the Click Me application will display its user
    interface

3.  A border pane object is created by calling the constructor of the
    BorderPane class, referencing the border pane via a variable
    named pane. The border pane will be used to control the layout of
    the controls displayed on the screen.
 */
