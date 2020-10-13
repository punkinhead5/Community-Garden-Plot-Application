
package SussexBoroughCommunityGarden1;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SussexBoroughCommunityGarden1 extends Application{
        public static void main(String[] args){
        //Launch the application
        launch(args);
    }
           
    @Override
    public void start(Stage primaryStage)
    {       
        //Create an Image object      
        Image gardenMapImage = new Image("file:C:\\Users\\morisson5\\Pictures\\CS115\\gardenmap.png\\");
        
        //Create ImageView object
        ImageView gardenMapIV = new ImageView(gardenMapImage);
        gardenMapIV.setFitWidth(130);
        gardenMapIV.setPreserveRatio(true);
        
        //Create a ListView for the ImageView objects
        ListView<Integer> listView = new ListView<>();
        listView.setPrefSize(100, 100);
        listView.getItems().addAll(1,2,3,5,7,8,9);
          
        //Create a Label to display the selection
        Label plotChoice = new Label("Please choose a garden plot.");
        
        //Create a Button to get the selection
        Button submitButton = new Button("Submit");
               
        //Create a label to display the selection
        Label applicationLabel = new Label("Thank you for your interest in the SBCG. Please complete the application below.");        
        
        //Create a label and textfield to display the user's first name
        Label firstNameLabel = new Label("First Name: ");
        TextField firstNameTF = new TextField();
        
        //Create a Label to display the winner
        Label lastNameLabel = new Label("Last Name: ");
        TextField lastNameTF = new TextField();
        
         //Create a Label to display the winner
        Label phoneNumberLabel = new Label("Phone Number: ");
        TextField phoneNumberTF = new TextField();
        
        //Create RadioButton controls
        Label paidFeeLabel = new Label("Have you paid the $40 fee?");
        RadioButton paidFeeYesRB = new RadioButton("Yes");
        RadioButton paidFeeNoRB = new RadioButton("No");
        ToggleGroup paidFeeTG = new ToggleGroup();
        
        //Add the RadioButtons to the Toggle Group
        paidFeeYesRB.setToggleGroup(paidFeeTG);
        paidFeeNoRB.setToggleGroup(paidFeeTG);
        
        //Create RadioButton controls
        Label contractLabel = new Label("Have you signed the contract?");
        RadioButton contractYesRB = new RadioButton("Yes");
        RadioButton contractNoRB = new RadioButton("No");
        ToggleGroup contractTG = new ToggleGroup();
        
        //Add the RadioButtons to the Toggle Group
        contractYesRB.setToggleGroup(contractTG);
        contractNoRB.setToggleGroup(contractTG);
        
        //Create RadioButton controls
        Label holdHarmlessLabel = new Label("Have you signed the Hold Harmless agreement?");
        RadioButton holdHarmlessYesRB = new RadioButton("Yes");
        RadioButton holdHarmlessNoRB = new RadioButton("No");
        ToggleGroup holdHarmlessTG = new ToggleGroup();
        
        //Add the RadioButtons to the Toggle Group
        holdHarmlessYesRB.setToggleGroup(holdHarmlessTG);
        holdHarmlessNoRB.setToggleGroup(holdHarmlessTG);        
        
        
        //Create a new Label
        Label instructionsLabel = new Label();
        Label instructionsLabel2 = new Label();
        Label instructionsLabel3 = new Label();
        Label instructionsLabel4 = new Label();
           
        //Create an event handler for the ListView control
        submitButton.setOnAction(event->
        {
              boolean answers1 = false;
              boolean documents1=false;
              boolean plotSelected1 = false;

               final int PLOT_SELECTION = listView.getSelectionModel().getSelectedItem();
                System.out.println("Plot selected: " + listView.getSelectionModel().getSelectedItem());

                if ((firstNameTF.getText().isEmpty()) || (lastNameTF.getText().isEmpty()) || (phoneNumberTF.getText().isEmpty()))
                    {
                        System.out.println("Answers false");
                        instructionsLabel.setText("Sorry, some information is missing or incorrect.");
                        instructionsLabel2.setText("Please try again!");
                        instructionsLabel3.setText(" ");
                        instructionsLabel4.setText(" ");
                        answers1= false;
                    }
                else
                    {
                        System.out.println("Answers true");
                        answers1= true;
                    }
                if ((paidFeeYesRB.isSelected()) && (contractYesRB.isSelected()) && 
                        (holdHarmlessYesRB.isSelected()))
                    {
                        System.out.println("Documents true");
                        documents1 = true;
                    }
                else
                    {
                        System.out.println("Documents false");
                        instructionsLabel.setText("Sorry, some information is missing or incorrect.");
                        instructionsLabel2.setText("Please try again!");
                        instructionsLabel3.setText(" ");
                        instructionsLabel4.setText(" ");
                        documents1 = false;
                    }

                  if (PLOT_SELECTION != 0) 
                  {
                      plotSelected1= true;
                      System.out.println("Plot selected");

                  }  
                          
                  else
                  {
                        plotSelected1= false;
                        System.out.println("Plot not selected 1");
                        instructionsLabel.setText("Sorry, some information is missing or incorrect.");
                        instructionsLabel2.setText("Please try again!");
                        instructionsLabel3.setText(" ");
                        instructionsLabel4.setText(" ");
                  }
                          
                  if ((plotSelected1 == true) && (answers1 == true) && (documents1 == true))
                    {
                        instructionsLabel.setText("Thank you! Documents and payment must be submitted to Borough Hall ");
                        instructionsLabel2.setText("c/o SBCG within one week or your garden plot reservation will expire. ");
                        instructionsLabel3.setText("Once documents and payment are received, you will receive the garden ");
                        instructionsLabel4.setText("gate lock combination via the phone number you provided. Happy gardening!");
                    }
                
                else
                    {
                        instructionsLabel.setText("Sorry, some information is missing or incorrect.");
                        instructionsLabel2.setText("Please try again!");
                        instructionsLabel3.setText(" ");
                        instructionsLabel4.setText(" ");
                    }
        }
        );

        GridPane gridPane = new GridPane();
        
        //Put the gridPane in a Vbox, Add the controls to a VBox       
        VBox vbox = new VBox(10, applicationLabel, gridPane,
                submitButton, instructionsLabel, instructionsLabel2, 
                instructionsLabel3, instructionsLabel4);        
        
        //Add the items to the GridPane
       gridPane.add(firstNameLabel, 0, 0);
       gridPane.add(firstNameTF, 1, 0);
       gridPane.add(lastNameLabel, 0, 1);
       gridPane.add(lastNameTF, 1, 1);
       gridPane.add(phoneNumberLabel, 0, 2);
       gridPane.add(phoneNumberTF, 1,2);
       gridPane.add(paidFeeLabel, 0,3);
       gridPane.add(paidFeeYesRB, 1,3);
       gridPane.add(paidFeeNoRB, 1,4);
       gridPane.add(contractLabel, 0,5);
       gridPane.add(contractYesRB, 1, 5);
       gridPane.add(contractNoRB, 1, 6);
       gridPane.add(holdHarmlessLabel, 0, 7);
       gridPane.add(holdHarmlessYesRB, 1, 7);
       gridPane.add(holdHarmlessNoRB, 1, 8);
       gridPane.add(plotChoice, 0, 9);
       gridPane.add(gardenMapIV, 1, 10);
       gridPane.add(listView, 0, 10);
       gridPane.setHgap(10);
       gridPane.setVgap(10);        
       
       //Put padding around the VBox        
       vbox.setPadding(new Insets(10));        
        
       Scene scene = new Scene(vbox);
       scene.getStylesheets().add("SBCGStyles1.css");

        //Add the Scene to the Stage
        primaryStage.setScene(scene);
        
        //Set the stage title
        primaryStage.setTitle("Sussex Borough Community Garden Application");
        
        //Show the window
        primaryStage.show();
        
    }
}