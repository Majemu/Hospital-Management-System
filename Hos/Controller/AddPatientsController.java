/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hos.Controller;

import Model.Alerts;
import Model.Patients;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author User
 */
public class AddPatientsController implements Initializable{
    
    public Index index;
    @FXML
    private FontAwesomeIconView homeBtn;
    @FXML
    private FontAwesomeIconView logoutBtn;
    @FXML
    private TextField patientId;
    @FXML
    private TextField firstName;
    @FXML
    private TextField age;
    @FXML
    private ComboBox<?> maritalStatus;
    @FXML
    private JFXButton addBtn;
    @FXML
    private TextField lastName;
    @FXML
    private ComboBox<?> gender;
    @FXML
    private TextField regDate;
    @FXML
    private TextField address;
    @FXML
    private TextField city;
    @FXML
    private TextField bloodGroup;
    @FXML
    private TextField phoneNo;
    @FXML
    private ComboBox<?> patientType;
    @FXML
    private TextField wardNo;
    @FXML
    private TextField bedNo;
    public String date1;
    @FXML
    private JFXButton addPatientBtn;
    @FXML
    private JFXButton deletePatientBtn;
    @FXML
    private JFXButton updatePatientBtn;
    @FXML
    private JFXButton searchPatientBtn;
    
    
    @FXML
    private JFXButton viewPatientBtn;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList list1 = FXCollections.observableArrayList();
        list1.add("Single");
        list1.add("Married");
        list1.add("Divorced");
        list1.add("Widowed");
        
        maritalStatus.setItems(list1);
        
        ObservableList list3 = FXCollections.observableArrayList();
        list3.add("Male");
        list3.add("Female");
        
        gender.setItems(list3);
        
        ObservableList list2 = FXCollections.observableArrayList();
        list2.add("Indoor");
        list2.add("Outdoor");
        
        patientType.setItems(list2);
    }
    
    public void setIndex(Index index){
        this.index = index;
        
    }

    @FXML
    private void goAdminPortak(MouseEvent event) throws IOException {
        index.apatStage.close();
        index.adminPort();
    }

    @FXML
    private void logout(MouseEvent event) {
        index.apatStage.close();
        index.primaryStage.show();
    }

    @FXML
    private void addPatient(ActionEvent event) throws IOException {
        index.apatStage.close();
        index.addPatients();
    }


    @FXML
    private void searchPatient(ActionEvent event) throws IOException {
        index.apatStage.close();
        index.searchPatients();
    }

    @FXML
    private void viewPatient(ActionEvent event) throws IOException {
        index.apatStage.close();
        index.viewPatients();
    }

    @FXML
    private void add(ActionEvent event) throws IOException {
        
        
        
        //get register date
             Date utilDate = new Date();
        System.out.println(utilDate);
        
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            date1 = sqlDate.toString();
            
            
            System.out.println("saved");
        // collect user details
        String patientid = patientId.getText();
        String fname = firstName.getText();
        String lname = lastName.getText();
        int Age = Integer.parseInt(age.getText());
        String City = city.getText();
        String phoneno = phoneNo.getText();
        String Address = address.getText();
        String maritalstatus = maritalStatus.getSelectionModel().getSelectedItem().toString();
        String Gender = gender.getSelectionModel().getSelectedItem().toString();
        String patienttype = patientType.getSelectionModel().getSelectedItem().toString();
        String bloodgroup = bloodGroup.getText();
        String regDate = date1;
        int id;
        int wardno = Integer.parseInt(wardNo.getText());
        int bedno = Integer.parseInt(bedNo.getText());
            
        // execute query
            Patients pat = new Patients();
    
        
        if(!patientid.isEmpty()&&!fname.isEmpty()&&!lname.isEmpty()&&!age.getText().isEmpty()
                &&!City.isEmpty()&&!phoneno.isEmpty()&&!Address.isEmpty()&&!maritalstatus.isEmpty()
                &&!Gender.isEmpty()&&!patienttype.isEmpty()&&!bloodgroup.isEmpty()&&!regDate.isEmpty()
                &&!wardNo.getText().isEmpty()&&!bedNo.getText().isEmpty()){
            
            
        
        
        // check if details are empty
        
        
        pat = new Patients(patientid, fname,  lname,  Age,  maritalstatus,  Gender, date1, Address,  City,  phoneno, bloodgroup, patienttype, wardno, bedno);
                
                System.out.println(pat.getRegDate());
                if(pat.addPat(pat)){
                    System.out.println("successful");
                    Alerts.Alrt("Successful", "You have succesfully added a new patient");
                    
                }
                else
                    System.out.println("failed");
        
                index.apatStage.close();
                index.viewPatients();
        
           }
        else{
            Alerts.Alart("Error", "Empty fields detected");
        }
        
        }

    @FXML
    private void deletePatient(ActionEvent event) throws IOException {
        index.apatStage.close();
        index.deletePatients();
    }

    @FXML
    private void updatePatient(ActionEvent event) throws IOException {
        index.apatStage.close();
        index.updatePatients();
    }

        
    

}
