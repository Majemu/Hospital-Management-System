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
public class AdminPortController {
    
    private Index index;
    @FXML
    private JFXButton logoutbtn;
    @FXML
    private JFXButton receptionist;
    @FXML
    private JFXButton patients;
    @FXML
    private JFXButton appointments;
    @FXML
    private JFXButton doctors;
    @FXML
    private JFXButton inPatients;
    @FXML
    private JFXButton outPatients;


    @FXML
    private void logout(ActionEvent event) {
        index.adminStage.close();
        index.primaryStage.show();
    }

    
    public void setIndex(Index index){
        this.index = index;
    }


    @FXML
    private void showPatients(ActionEvent event) throws IOException {
        index.adminStage.close();
        index.viewPatients();
    }

    @FXML
    private void showReceptionists(ActionEvent event) {
    }

    @FXML
    private void showAppointments(ActionEvent event) {
    }

    @FXML
    private void showDoctors(ActionEvent event) throws IOException {
        index.adminStage.close();
        index.viewDoctors();
    }

    @FXML
    private void showInPatients(ActionEvent event) {
    }

    @FXML
    private void showOutPatients(ActionEvent event) {
    }

    
}
