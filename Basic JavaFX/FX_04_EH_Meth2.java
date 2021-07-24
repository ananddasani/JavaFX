/*
Program to demonstrate the various methods/ways of handling events

Method 2 --> Handling event with inner classes
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

public class FX_04_EH_Meth2 extends Application {

    public static void main(String[] args) {
        System.out.println("Launching the app");
        launch(args);
        System.out.println("Finished :)");
    }

    //create a ClickHandler instance (an inner class)
    ClickHandler ch = new ClickHandler();

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
        addButton.setOnAction(ch);

        //create the subtract button
        subButton = new Button("SUB");
        subButton.setOnAction(ch);

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

    private class ClickHandler implements EventHandler<ActionEvent> {

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
}

/*
NOTES

1. The FX_04_EH_Meth2 class still extends Application but doesn't implement EventHandler.

2. The ClickHandler class is declared as an inner class by placing its declaration completely within the FX_04_EH_Meth2 class.
The ClickHandler class implements the EventHandler interface so that it can handle events.

3. statement 43 and 47 sets ch as the action listener for the Add button and for the Subtract.

 */
