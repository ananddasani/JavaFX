/*
Program to demonstrate the various methods/ways of handling events

Method 1 --> Implementing the event handling interface
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

public class FX_03_EH_Meth1 extends Application implements EventHandler<ActionEvent> {

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
        addButton.setOnAction(this);

        //create the subtract button
        subButton = new Button("SUB");
        subButton.setOnAction(this);

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

    /**
     * The handle method is an abstract method of EventHandler interface which we have to Override compulsory
     *
     * @param e is the event object
     */
    @Override
    public void handle(ActionEvent e) {

        //if add button is pressed then add 1 in counter else subtract 1 form the counter
        if (e.getSource() == addButton)
            count++;
        else
            count--;

        //display the result
        label.setText(Integer.toString(count));
    }
}

/*
NOTES

1.  Here "this" keyword is used because we have implemented the EventHandler interface
    so in effect our FX_03_EH_Meth1 itself handles any event that are created by it's own controls

2.  For this program, a border pane is not the appropriate type of
    layout pane. Instead, for this program, use a new type of layout
    pane called an HBox. An HBox pane arranges any controls you add
    to it in a horizontal row. The parameter 10 indicates that the controls
    should be separated from one another by a space ten pixels wide.

3.  you must call the getChildren method to get a list of all
    the child nodes that are in the HBox. Then, you call the addAll
    method to add one or more controls.

 */
