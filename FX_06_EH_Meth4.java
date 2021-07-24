/*
Program to demonstrate the various methods/ways of handling events

Method 4 --> Using Lambda Expression for Handling event
 */
package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FX_06_EH_Meth4 extends Application {

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
        addButton.setOnAction(e ->
                {
                    count++;
                    label.setText(Integer.toString(count));
                }
        );

        //create the subtract button
        subButton = new Button("SUB");
        subButton.setOnAction(e -> subButtonClicked());

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
     * The subButtonClicked method will decrement the counter by 1 when the user will click the button
     */
    public void subButtonClicked() {
        count--;
        label.setText(Integer.toString(count));
    }
}

/*
WHAT IS LAMBDA EXPRESSION ?
a Lambda expression
lets you create an anonymous class that implements a specific type of interface
— a functional interface — which has one and only one abstract method.

NOTES
what if you have to write logic of 100 lines of code to handle event ?
So at that time you must write logic in the different method as practiced for sub button


------------------------------------------------------------------------------------
The EventHandler interface used to handle JavaFX events meets that definition: It has just one abstract method, handle.
Thus, EventHandler is a functional interface and can be used with Lambda expressions.

One of the interesting things about Lambda expressions is that you don’t
need to know the name of the method being called. This is possible because
a functional interface used with a Lambda expression can have only one
abstract method. In the case of the EventHandler interface, the method is
named handle.

You also do not need to know the name of the interface being implemented.
This is possible because the interface is determined by the context. The
setOnAction method takes a single parameter of type EventHandler.
Thus, when you use a Lambda expression in a call to setOnAction, the
Java compiler can deduce that the Lambda expression will implement
the EventHandler interface. And because the only abstract method of
EventHandler is the handle method, the compiler can deduce that the
method body you supply is an implementation of the handle method.

In a way, Lambda expressions take the concept of anonymous classes two
steps further. When you use an anonymous class to set an event handler, you
must know and specify the name of the class (EventHandler) and the name
of the method to be called (handle), so the only sense in which the class is
anonymous is that you don’t need to provide a name for a variable that will
reference the class. But when you use a Lambda expression, you don’t have
to know or specify the name of the class, the method, or a variable used to
reference it. All you have to do, essentially, is provide the body of the handle
method.
 */