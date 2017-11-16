/*
* Software Engineering 3733, Worcester Polytechnic Institute
* Team H
* Code produced for Iteration1
* Original author(s): Erica Snow, Vojta Mosby, Tyrone Patterson
* The following code
*/

package kioskEngine;

import database.mainDatabase;
import map.Node;
import controllers.ScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import service.FoodService;
import service.ServiceRequest;
import service.Staff;

import java.util.ArrayList;

public class Main extends Application {
    private static KioskEngine engine = new KioskEngine();
    @Override
    public void start(Stage primaryStage) throws Exception{
        ScreenController myScreenController = new ScreenController(engine);
        myScreenController.loadScreen(ScreenController.AddNodeID, ScreenController.AddNodeFile);
        myScreenController.loadScreen(ScreenController.AdminMenuID, ScreenController.AdminMenuFile);
        myScreenController.loadScreen(ScreenController.FilterID, ScreenController.FilterFile);
        myScreenController.loadScreen(ScreenController.LoginID, ScreenController.LoginFile);
        myScreenController.loadScreen(ScreenController.LogoutID, ScreenController.LogoutFile);
        myScreenController.loadScreen(ScreenController.MainID, ScreenController.MainFile);
        //myScreenController.loadScreen(ScreenController.NodeConfirmID, ScreenController.NodeConfirmFile);
        myScreenController.loadScreen(ScreenController.PathID, ScreenController.PathFile);
        myScreenController.loadScreen(ScreenController.RequestID, ScreenController.RequestFile);
        //myScreenController.loadScreen(ScreenController.ThankYouID, ScreenController.ThankYouFile);

        myScreenController.setScreen(ScreenController.MainID);

        Group root = new Group();
        root.getChildren().addAll(myScreenController);
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }

    public static void main(String[] args) {
        mainDatabase.readNodeCSV("MapHnodes.csv");
        mainDatabase.readNodeCSV("MapWnodes.csv");

        mainDatabase.readEdgesCSV("MapHedges.csv");
        mainDatabase.readEdgesCSV("MapWedges.csv");

        Staff Bob =  new Staff("BRoss","pass","Admin","Bob Ross",1234, engine.getService("Food"));
        Staff Nick =  new Staff("NCage","pass","Cook","Nick Cage",66478, engine.getService("Food"));
        Staff Gordan =  new Staff("GRamsay","pass","BusBoy","Gordan Ramsay",5445, engine.getService("Food"));

        engine.addStaffLogin(Bob, "Food");
        engine.addStaffLogin(Nick, "Food");
        engine.addStaffLogin(Gordan, "Food");


        for(Node node : mainDatabase.getNodes()){
            engine.getMap().addNode(node.getID(),node);
        }

        launch(args);


        mainDatabase.outputNodesCSV();
        mainDatabase.outputEdgesCSV();
    }
}
