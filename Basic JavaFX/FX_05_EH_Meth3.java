/*
Program to demonstrate the various methods/ways of handling events

Method 3 --> Handling event with Anonymous inner classes
 */
package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FX_05_EH_Meth3 extends Application {

    public static void main(String[] args) {
        System.out.println("Launching the app");
        launch(args);
        System.out.println("Finished :)");
    }

    //Buttons
    Button addButton;
    Button subButton;

    //labels
    Label label;

    //counter
    int count = 0;

    @Override
    public void start(Stage primaryStage) {

        //create the add button
        addButton = new Button("ADD");
        addButton.setOnAction(
                //inner anonymous class (with no name )
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        count++;
                        label.setText(Integer.toString(count));
                    }
                }
        );

        //create the subtract button
        subButton = new Button("SUB");
        subButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        count--;
                        label.setText(Integer.toString(count));
                    }
                }
        );

        //create a label
        label = new Label(Integer.toString(count));

        //Add this all in the layout
        HBox pane = new HBox(10);
        pane.getChildren().addAll(addButton, subButton, label);

        //add layout to the scene
        Scene scene = new Scene(pane);

        //add scene to the stage
        primaryStage.setTitle("The add/sub App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

/*
WHAT IS ANONYMOUS INNER CLASS ?

An anonymous inner class, usually just called an anonymous class, is a class
that’s defined on the spot, right at the point where you need it. Because you
code the body of the class right where you need it, you don’t have to give it a
name; that’s why it’s called an anonymous class.
-------------------------------------------------------------------------------

NOTES

1.  This line no 42. calls the setOnAction method of the Add button and
    creates an anonymous instance of the EventHandler class, specifying ActionEvent as the type.

2.  The handle method must be defined within the body of the anonymous class.

3.  Because this handle method will be called only when the Add
    button is clicked it does not need to determine the event source.

----------------------------------------------------------------------------
One advantage of using anonymous classes for event handlers is that you can
easily create a separate event handler for each control that generates events.

 */
