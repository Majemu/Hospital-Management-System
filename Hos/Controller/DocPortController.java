/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hos.Controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author User
 */
public class DocPortController {
    
    private Index index;

    @FXML
    private JFXButton logoutbtn;
    @FXML
    private JFXButton profile;
    @FXML
    private JFXButton patients;
    @FXML
    private JFXButton appointments;
    @FXML
    private JFXButton changePass;

    @FXML
    private void logout(ActionEvent event) {
        index.docStage.close();
        index.primaryStage.show();
    }

    @FXML
    private void showProfile(ActionEvent event) {
    }

    @FXML
    private void showPatients(ActionEvent event) throws IOException {
        index.docStage.close();
        index.viewPatients();
    }

    @FXML
    private void showAppointments(ActionEvent event) {
    }

    @FXML
    private void changePass(ActionEvent event) {
    }
    
    public void setIndex(Index index){
        this.index = index;
    }
    
}
