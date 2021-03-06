/*
* Software Engineering 3733, Worcester Polytechnic Institute
* Team H
* Code produced for Iteration1
* Original author(s): Travis Norris, Andrey Yuzvik
* The following code
*/

package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import map.Node;

public class MainController implements ControllableScreen{
    private ScreenController parent;

    public void setParentController(ScreenController parent){
        this.parent = parent;
    }
    @FXML
    private Button btnlogin;

    @FXML
    private Button btnzout;

    @FXML
    private Slider slideBarZoom;

    @FXML
    private Button btnzin;

    @FXML
    private Button btndirection;

    @FXML
    private Button btnsearch;

    @FXML
    private Button btnfilter;

    @FXML
    private Pane mapPane;

    @FXML
    private Circle kioskMarker;

    public void init(){
    }

    public void onShow(){

    }

    //when login button is pressed go to login screen
    public void loginPressed(ActionEvent e){
        System.out.println("Login Pressed");
        parent.setScreen(ScreenController.LoginID);
    }
    //when direction button is pressed go to directions screen
    public void directionPressed(ActionEvent e){
        System.out.println("Direction Pressed");
        parent.setScreen(ScreenController.PathID);
    }
    //when search button is pressed go to search screen
    public void searchPressed(ActionEvent e){
        System.out.println("Search Pressed");

    }
    //when filter button is pressed go to filter screen
    public void filterPressed(ActionEvent e){
        System.out.println("Filter Pressed");
        parent.setScreen(ScreenController.FilterID);
    }
    //when + button is pressed zoom in map
    public void zinPressed(ActionEvent e){
        System.out.println("Zoom In Pressed");
        slideBarZoom.adjustValue(slideBarZoom.getValue()+0.1);
        setMapScale(slideBarZoom.getValue());
 
    }

    //when - button pressed zoom out map
    public void zoutPressed(ActionEvent e){

        slideBarZoom.adjustValue(slideBarZoom.getValue()-0.1);
        setMapScale(slideBarZoom.getValue());

    }

    //adjusts map zoom through slider
    public void sliderChanged(MouseEvent e){
        //System.out.println("Slider Moved");
        setMapScale(slideBarZoom.getValue());
    }

    //map scale set up
    public void setMapScale(double scale){
        mapPane.setScaleX(scale);
        mapPane.setScaleY(scale);
    }



}
