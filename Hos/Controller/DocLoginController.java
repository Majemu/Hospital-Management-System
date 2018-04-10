/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hos.Controller;

import Model.Alerts;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author User
 */
public class DocLoginController {
    
    private Index index;

    @FXML
    private JFXTextField username;
    private JFXPasswordField password;
    @FXML
    private JFXButton loginbtn;
    @FXML
    private FontAwesomeIconView back;

    @FXML
    private void login(ActionEvent event) throws IOException {
        
//        if(username.getText().equals("doctor") && password.getText().equals("doctor") ){
           index.secondaryStage.close();
            index.docPort();
            
//        }
//        else{
//            Alerts.Alart("Invalid Login Details", "Please Enter correct Login details");
//        }
    }

    @FXML
    private void goBack(MouseEvent event) {
        index.secondaryStage.close();
        index.primaryStage.show();
        
    }
    
    public void setIndex(Index index){
        this.index = index;
    }
    
}
