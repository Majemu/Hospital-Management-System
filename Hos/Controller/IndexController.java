/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hos.Controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author User
 */
public class IndexController implements Initializable {
    
    private Index index;
    @FXML
    private JFXButton adminBtn;
    @FXML
    private JFXButton recepBtn;
    @FXML
    private JFXButton doctorbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void adminLogin(ActionEvent event) throws IOException {
        index.primaryStage.close();
        index.Admin();
        
    }

    
    public void setIndex(Index index){
        this.index = index;
        
    }

    @FXML
    private void recepLogin(ActionEvent event) throws IOException {
        index.primaryStage.close();
        index.Recep();
    }

    @FXML
    private void docLogin(ActionEvent event) throws IOException {
        index.primaryStage.close();
        index.Doctor();
    }

    
}
