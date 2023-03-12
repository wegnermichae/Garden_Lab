package paganinik;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;


public class GardenController {

    private Pane beeImageBox;               // box containing bee and it's label; NOT a good domain name!
    private Pane flowerImageBox;
    private double XLocation, YLocation;  // drawn location of bee; this should be in a domain class
    private Garden garden_bee_flower_controller = Garden.getInstance();
    @FXML
    private Pane theGarden;                 // capture the pane we are drawing on from JavaFX

    @FXML
    private TextField flowerBeesTextField;

    @FXML
    private TextField destroyerBeesTextField;

    @FXML
    private TextField medicFlowerTextField;


    @FXML
    private TextField thiefFlowerTextField;



    @FXML
    public void initialize() {              // executed after scene is loaded but before any methods
        // for fun, set up a gradient background; could probably do in SceneBuilder as well
        // note the label has a Z index of 2 so it is drawn above the panel, otherwise it may be displayed "under" the panel and not be visible
        theGarden.setStyle("-fx-background-color: linear-gradient(to bottom right, derive(forestgreen, 20%), derive(forestgreen, -40%));");
        // load image from a file; the file needs to be in the top folder of the project

        theGarden.setFocusTraversable(true); // ensure garden pane will receive keypresses
        medicFlowerTextField.setFocusTraversable(false);
        destroyerBeesTextField.setFocusTraversable(false);
        thiefFlowerTextField.setFocusTraversable(false);
        flowerBeesTextField.setFocusTraversable(false);
    }

    // display the bee at the (beeXLocation, YLocation), ensuring the bee does not leave the garden
    private void displayBee(double XLocation, double YLocation) {
        if (XLocation < 0 )
            XLocation = 0;
        else if (theGarden.getWidth() > 0 && XLocation > theGarden.getWidth() - 10)
            // note: getWidth() is 0 when first load the scene, so don't relocate the bee in that case
            XLocation = theGarden.getWidth() - 10;
        if (YLocation < 0)
            YLocation = 0;
        else if (theGarden.getHeight() > 0 && YLocation > theGarden.getHeight() - 10)
            YLocation = theGarden.getHeight() - 10;
        beeImageBox.setLayoutX(XLocation);
        beeImageBox.setLayoutY(YLocation);
    }

//    @FXML
//    public void onKeyPressed(KeyEvent keyEvent) {
//        if (keyEvent.getCode() == KeyCode.RIGHT) {
//            XLocation += 10.0;
//        } else if (keyEvent.getCode() == KeyCode.LEFT) {
//            XLocation -= 10.0;
//        } else if (keyEvent.getCode() == KeyCode.DOWN) {
//            YLocation += 10.0;
//        } else if (keyEvent.getCode() == KeyCode.UP) {
//            YLocation -= 10.0;
//        }
//        displayBee(XLocation, YLocation);
//    }





    public void setNumEntities(ActionEvent actionEvent) {
        try {
            int numTF = Integer.parseInt(thiefFlowerTextField.getText());
            int numMF = Integer.parseInt(medicFlowerTextField.getText());
            int numDB = Integer.parseInt(destroyerBeesTextField.getText());
            int numFB = Integer.parseInt(flowerBeesTextField.getText());
            garden_bee_flower_controller.setNumThiefFlowers(numTF);
            garden_bee_flower_controller.setNumMedicFlowers(numMF);
            garden_bee_flower_controller.setNumFlowerBees(numFB);
            garden_bee_flower_controller.setNumDestroyerBees(numDB);
            displayAll();


        } catch (NumberFormatException nfe){
            System.out.println("Give a number dude");
        }
    }
    public void displayAll(){
        ArrayList flowerBees = garden_bee_flower_controller.getFlowerBees();
        theGarden.getChildren().clear();
        for (int i = 0; i < flowerBees.size(); i++){
            ImageView beeImage = new ImageView(new Image("garden_jpgs/bee-1.jpg")); // draws bee
            beeImage.setPreserveRatio(true);    // ensure ratio preserved when scaling the bee
            beeImage.setFitWidth(50.0);         // scale bee to be a reasonable size
            Label beeLabel = new Label();       // you might make this an attribute of another class so you can update it
            beeLabel.setText("Flower Bee");
            beeLabel.setStyle("-fx-text-fill: blue;");
            beeImageBox = new VBox();
            beeImageBox.getChildren().add(beeImage);
            beeImageBox.getChildren().add(beeLabel);
            FlowerBee flowerBee = (FlowerBee) flowerBees.get(i);
            XLocation = flowerBee.getX();               // initial location of bee; for your solution,
            YLocation = flowerBee.getY();                 //     capture this in an object
            theGarden.getChildren().add(beeImageBox); // place bee on the panel
            displayBee(XLocation, YLocation);


        }
        ArrayList destroyerBees = garden_bee_flower_controller.getDestroyerBees();

        for (int i = 0; i < destroyerBees.size(); i++){
            ImageView beeImage = new ImageView(new Image("garden_jpgs/bee-2.jpg")); // draws bee
            beeImage.setPreserveRatio(true);    // ensure ratio preserved when scaling the bee
            beeImage.setFitWidth(50.0);         // scale bee to be a reasonable size
            Label beeLabel = new Label();       // you might make this an attribute of another class so you can update it
            beeLabel.setText("Destroyer Bee");
            beeLabel.setStyle("-fx-text-fill: blue;");
            beeImageBox = new VBox();
            beeImageBox.getChildren().add(beeImage);
            beeImageBox.getChildren().add(beeLabel);
            DestroyerBee destroyerBee = (DestroyerBee) destroyerBees.get(i);
            XLocation = destroyerBee.getX();               // initial location of bee; for your solution,
            YLocation = destroyerBee.getY();                 //     capture this in an object
            theGarden.getChildren().add(beeImageBox); // place bee on the panel
            displayBee(XLocation,YLocation);
        }
        ArrayList thiefFlowers = garden_bee_flower_controller.getThiefFlowers();
        for (int i = 0; i < thiefFlowers.size(); i++){
            ImageView flowerImage = new ImageView(new Image("garden_jpgs/coneflower.jpg")); // draws bee
            flowerImage.setPreserveRatio(true);    // ensure ratio preserved when scaling the bee
            flowerImage.setFitWidth(50.0);         // scale bee to be a reasonable size
            Label flowerLabel = new Label();       // you might make this an attribute of another class so you can update it
            flowerLabel.setText("Thief Flower");
            flowerLabel.setStyle("-fx-text-fill: blue;");
            flowerImageBox = new VBox();
            flowerImageBox.getChildren().add(flowerImage);
            flowerImageBox.getChildren().add(flowerLabel);
            ThiefFlower thiefFlower = (ThiefFlower) thiefFlowers.get(i);
            XLocation = thiefFlower.getX();               // initial location of bee; for your solution,
            YLocation = thiefFlower.getY();                 //     capture this in an object
            theGarden.getChildren().add(flowerImageBox); // place bee on the panel
            flowerImageBox.setLayoutX(XLocation);
            flowerImageBox.setLayoutY(YLocation);
        }

        ArrayList medicFlowers = garden_bee_flower_controller.getMedicFlowers();
        for (int i = 0; i < medicFlowers.size(); i++){
            ImageView flowerImage = new ImageView(new Image("garden_jpgs/rose.jpg")); // draws bee
            flowerImage.setPreserveRatio(true);    // ensure ratio preserved when scaling the bee
            flowerImage.setFitWidth(50.0);         // scale bee to be a reasonable size
            Label flowerLabel = new Label();       // you might make this an attribute of another class so you can update it
            flowerLabel.setText("Medic Flower");
            flowerLabel.setStyle("-fx-text-fill: blue;");
            flowerImageBox = new VBox();
            flowerImageBox.getChildren().add(flowerImage);
            flowerImageBox.getChildren().add(flowerLabel);
            MedicFlower medicFlower = (MedicFlower) medicFlowers.get(i);
            XLocation = medicFlower.getX();               // initial location of bee; for your solution,
            YLocation = medicFlower.getY();                 //     capture this in an object
            theGarden.getChildren().add(flowerImageBox); // place bee on the panel
            flowerImageBox.setLayoutX(XLocation);
            flowerImageBox.setLayoutY(YLocation);
        }
    }

    @FXML
    public void moveBees(KeyEvent keyEvent){
        ArrayList<DestroyerBee> destroyerBees = garden_bee_flower_controller.getDestroyerBees();
        ArrayList<FlowerBee> flowerBees = garden_bee_flower_controller.getFlowerBees();
        if (keyEvent.getCode() == KeyCode.RIGHT){
            System.out.println("we in here");
            for(int i = 0; i < destroyerBees.size(); i++){
                destroyerBees.get(i).moveBee();
            }
            for(int i = 0; i < flowerBees.size(); i++){
                flowerBees.get(i).moveBee();
            }
            displayAll();
        }

    }

}
