/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hos.Controller;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author User
 */
public class ViewDoctorsController {

    @FXML
    private FontAwesomeIconView homeBtn;
    @FXML
    private FontAwesomeIconView logoutBtn;
    @FXML
    private JFXButton addDoctorBtn;
    @FXML
    private JFXButton deleteDoctorBtn;
    @FXML
    private JFXButton updateDoctorBtn;
    @FXML
    private JFXButton searchDoctorBtn;
    @FXML
    private TableView<?> doctorsList;
    @FXML
    private TableColumn<?, ?> _docD;
    @FXML
    private TableColumn<?, ?> _fname;
    @FXML
    private TableColumn<?, ?> _lname;
    @FXML
    private TableColumn<?, ?> _address;
    @FXML
    private Label lblname;
    @FXML
    private Label lbldocid;
    @FXML
    private Label lbladdress;
    @FXML
    private Label lblcity;
    @FXML
    private Label lblage;
    @FXML
    private Label lblgender;
    @FXML
    private Label lblpnum;
    @FXML
    private Label lblmstat;
    @FXML
    private Label lblLevel;
    @FXML
    private Label lblbgroup;
    @FXML
    private Label lblSpecialization;
    
    public Index index;

    @FXML
    private void goAdminPort(MouseEvent event) throws IOException {
        index.vpatStage.close();
        index.adminPort();
    }

    @FXML
    private void logout(MouseEvent event) {
        index.vpatStage.close();
        index.primaryStage.show();
    }

    @FXML
    private void addDoctor(ActionEvent event) throws IOException {
        index.vpatStage.close();
        index.addDoctor();
    }

    @FXML
    private void deleteDoctor(ActionEvent event) {
    }

    @FXML
    private void updateDoctor(ActionEvent event) {
    }

    @FXML
    private void searchDoctor(ActionEvent event) {
    }
    
    public void setIndex(Index index){
        this.index = index;
        
    }

    
}
