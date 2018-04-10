/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hos.Controller;

import Database.DBHandler;
import Model.Alerts;
import Model.Patients;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author User
 */
public class UpdatePatientController {
    

    public Index index;
    @FXML
    private FontAwesomeIconView logoutBtn;
    @FXML
    private FontAwesomeIconView homeBtn;
    @FXML
    private TextField _patID;
    @FXML
    private TextField _fname;
    @FXML
    private TextField _age;
    @FXML
    private TextField _lname;
    @FXML
    private TextField _regDate;
    @FXML
    private TextField _address;
    @FXML
    private TextField _city;
    @FXML
    private TextField _bGroup;
    @FXML
    private TextField _phoneNum;
    @FXML
    private TextField _wardNum;
    @FXML
    private TextField _bedNum;
    @FXML
    private JFXButton searchBtn;
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
    @FXML
    private TextField _maritalStat;
    @FXML
    private TextField _gender;
    @FXML
    private TextField _pType;
    @FXML
    private JFXButton updateBtn;
    
    DBHandler emb = new DBHandler();

    @FXML
    private void logout(MouseEvent event) {
        index.upatStage.close();
        index.primaryStage.show();
    }

    @FXML
    private void goAdminPortak(MouseEvent event) throws IOException {
        index.upatStage.close();
        index.adminPort();
    }

    @FXML
    private void search(ActionEvent event) {
        try {
            Patients pat = new Patients();
            String query = "select * from PATIENTS_TABLE where PatientID = '"+_patID.getText()+"'";
//
//          System.out.println(emb.execUpdate(query));
            ResultSet res = emb.execAction(query);
            while (res.next()){
    
            int id = res.getInt(1);
            String patId = res.getString(2);
            String fname = res.getString(3);
            String lname = res.getString(4);
            int age = res.getInt(5);
            String matstat = res.getString(6);
            String gender = res.getString(7);
            String regdate = res.getString(8);
            String address = res.getString(9);
            String city = res.getString(10);
            String phone = res.getString(11);
            String bloodgroup = res.getString(12);
            String patienttype = res.getString(13);
            int wardnum = res.getInt(14);
            int bednum = res.getInt(15);
            
            
            
            _fname.setText(fname);
            _lname.setText(lname);
            _age.setText(Integer.toString(age));
            _maritalStat.setText(matstat);
            _gender.setText(gender);
            _regDate.setText(regdate);
            _address.setText(address);
            _city.setText(city);
            _phoneNum.setText(phone);
            _bGroup.setText(bloodgroup);
            _pType.setText(patienttype);
            _wardNum.setText(Integer.toString(wardnum));
            _bedNum.setText(Integer.toString(bednum));
            

            System.out.println(id + " " + patId + " " + fname);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewPatientsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addPatient(ActionEvent event) throws IOException {
        index.upatStage.close();
        index.addPatients();
    }

    @FXML
    private void deletePatient(ActionEvent event) throws IOException {
        index.upatStage.close();
        index.deletePatients();
    }

    @FXML
    private void updatePatient(ActionEvent event) {
    }

    @FXML
    private void searchPatient(ActionEvent event) throws IOException {
        index.upatStage.close();
        index.searchPatients();
    }

    @FXML
    private void viewPatient(ActionEvent event) throws IOException {
        index.upatStage.close();
        index.viewPatients();
    }

    @FXML
    private void update(ActionEvent event) {
        
        
        String patientid = _patID.getText();
        String fname = _fname.getText();
        String lname = _lname.getText();
        int Age = Integer.parseInt(_age.getText());
        String City = _city.getText();
        String phoneno = _phoneNum.getText();
        String Address = _address.getText();
        String maritalstatus = _maritalStat.getText();
        String Gender = _gender.getText();
        String patienttype = _pType.getText();
        String bloodgroup = _bGroup.getText();
        String regDate = _regDate.getText();
        int id;
        int wardno = Integer.parseInt(_wardNum.getText());
        int bedno = Integer.parseInt(_bedNum.getText());
        
        
        Patients pat = new Patients();
            String query = "UPDATE PATIENTS_TABLE "
                    + "SET PatientID = '"+patientid+"', firstName = '"+fname+"', lastName = '"+lname+"',"
                    + "Age = '"+Age+"', MaritalStatus = '"+maritalstatus+"', Gender = '"+Gender+"',"
                    + " RegDate = '"+regDate+"', Address = '"+Address+"', City = '"+City+"', PhoneNo = '"+phoneno+"',"
                    + " BloodGroup = '"+bloodgroup+"',PatientType = '"+patienttype+"', WardNo = '"+wardno+"', BedNo = '"+bedno+"'"
                    + "WHERE PatientID = '"+_patID.getText()+"'";
//
          System.out.println(emb.execUpdate(query));
            ResultSet res = emb.execAction(query);
            Alerts.Alrt("Successful", "You have successfully updated patient's info");
        
    }
    
    public void setIndex(Index index){
        this.index = index;
        
    }
    
}
