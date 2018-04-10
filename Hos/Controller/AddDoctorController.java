/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hos.Controller;

import Model.Alerts;
import Model.Doctors;
import Model.Patients;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
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
public class AddDoctorController implements Initializable{

    @FXML
    private FontAwesomeIconView homeBtn;
    @FXML
    private FontAwesomeIconView logoutBtn;
    @FXML
    private TextField doctorId;
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
    private TextField address;
    @FXML
    private TextField city;
    @FXML
    private TextField bloodGroup;
    @FXML
    private TextField phoneNo;
    @FXML
    private JFXDatePicker joiningDate;
    @FXML
    private JFXDatePicker leavingDate;
    @FXML
    private JFXButton addDoctorBtn;
    @FXML
    private JFXButton deleteDoctorBtn;
    @FXML
    private JFXButton updateDoctorBtn;
    @FXML
    private JFXButton searchDoctorBtn;
    @FXML
    private JFXButton viewDoctorBtn;
    @FXML
    private TextField docUsername;
    @FXML
    private TextField docPassword;
    @FXML
    private ComboBox<?> specialization;
    @FXML
    private ComboBox<?> level;

    public Index index;
    
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
        
        ObservableList list4 = FXCollections.observableArrayList();
        list4.add("Junior");
        list4.add("Senior");
        
        level.setItems(list4);
        
        ObservableList list5 = FXCollections.observableArrayList();
        list5.add("Allergy & Immunology");
        list5.add("Anesthesiology");
        list5.add("Cardiology");
        list5.add("Dermatology");
        list5.add("Gastroenterology");
        list5.add("Hematology");
        list5.add("Internal Medicine");
        list5.add("Nephrology");
        list5.add("Neurology");
        list5.add("Gynecology");
        list5.add("Opthamology");
        list5.add("Orthopaedics");
        list5.add("Pathology");
        list5.add("Pediatrics");
        list5.add("Plastic Surgery");
        list5.add("Rheumatology");
        
        specialization.setItems(list5);
        
        
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
    }

    @FXML
    private void add(ActionEvent event) {
        
        // collect user details
        String doctorid = doctorId.getText();
        String fname = firstName.getText();
        String lname = lastName.getText();
        int Age = Integer.parseInt(age.getText());
        String City = city.getText();
        String phoneno = phoneNo.getText();
        String Address = address.getText();
        String bloodgroup = bloodGroup.getText();
        String maritalstatus = maritalStatus.getSelectionModel().getSelectedItem().toString();
        String Gender = gender.getSelectionModel().getSelectedItem().toString();
        String Level = level.getSelectionModel().getSelectedItem().toString();
        String Specialization = specialization.getSelectionModel().getSelectedItem().toString();
        String joining = joiningDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String leaving = leavingDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String user = docUsername.getText();
        String pass = docPassword.getText();
        

        // execute query
        Doctors doc = new Doctors();
            
        doc = new Doctors (doctorid, fname, lname, Age, maritalstatus, Gender, Specialization, Address, City, phoneno, bloodgroup, Level, joining, leaving, user, pass);
        
        if(doc.addDoc(doc)){
                    System.out.println("successful");
                    Alerts.Alrt("Successful", "You have succesfully added a new patient");
                    
                }
                else
                    System.out.println("failed");
    }

    @FXML
    private void addDoctor(ActionEvent event) {
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

    @FXML
    private void viewDoctor(ActionEvent event) {
    }

    
    
}
