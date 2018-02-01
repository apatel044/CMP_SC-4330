/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import checkerboard.Checkerboard;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 *
 * @author Anjay
 */
public class FXMLDocumentController implements Initializable,Startable {
    
    Stage stage = new Stage();
    
    @FXML
    private VBox vb;
    
    @FXML
    private MenuBar mb;
    
    private int rows = 8;
    private int columns = 8;
    private Color lcolor = Color.RED;
    private Color dcolor = Color.BLACK;

    Checkerboard checkerboarda = new Checkerboard(rows, columns, 600, 400, lcolor, dcolor);

    @FXML
    private AnchorPane anchorpane = checkerboarda.getBoard() ;
    

    
    public void start(Stage stage) {
        this.stage = stage;    
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
        updateGrid();
        };
        populateGrid();

        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        populateGrid();
    }    
    
    @FXML
    private void handle16(ActionEvent event) {
        rows = 16;
        columns = 16;
        updateGrid();
    }
    @FXML
    private void handle10(ActionEvent event) {
        rows=10;
        columns = 10;
        updateGrid();

    }
    @FXML
    private void handle8(ActionEvent event) {
        rows=8;
        columns = 8;
        updateGrid();

    }
    @FXML
    private void handle3(ActionEvent event) {
        rows=3;
        columns = 3;
        updateGrid();

    }
    @FXML
    private void handleDef(ActionEvent event) {
        lcolor = Color.RED;
        dcolor = Color.BLACK;
        updateGrid();    
    }   
    @FXML
    private void handleBlue(ActionEvent event) {
        lcolor = Color.SKYBLUE;
        dcolor = Color.DARKBLUE;
        updateGrid();
    }
    
    private void updateGrid()
    {
        vb.getChildren().remove(2);
        double width = vb.getWidth();
        double height = vb.getHeight()- mb.getHeight();
        System.out.println(rows + " " + columns + " " + width + " " + height + " " +lcolor + " " +dcolor);
        checkerboarda = new Checkerboard(rows, columns, width, height, lcolor, dcolor);
        vb.getChildren().add(checkerboarda.build());
        
    }
    private void populateGrid()
    {
        anchorpane = checkerboarda.build();
        vb.getChildren().add(anchorpane);

    }
}
