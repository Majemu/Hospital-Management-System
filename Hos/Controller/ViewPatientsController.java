/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hos.Controller;

import Database.DBHandler;
import Model.Patients;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author User
 */
public class ViewPatientsController implements Initializable{
    
    public Index index;
    @FXML
    private FontAwesomeIconView homeBtn;
    @FXML
    private FontAwesomeIconView logoutBtn;
    @FXML
    private TableColumn<?, ?> _patID;
    @FXML
    private TableColumn<?, ?> _fname;
    @FXML
    private TableColumn<?, ?> _lname;
    @FXML
    private TableColumn<?, ?> _address;
    @FXML
    private Label lblname;
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
    private Label lblbgroup;
    @FXML
    private TableView<Patients> patientsList;
    
    public ObservableList<Patients> data;
    DBHandler emb = new DBHandler();
    @FXML
    private JFXButton addPatientBtn;
    @FXML
    private JFXButton deletePatientBtn;
    @FXML
    private JFXButton updatePatientBtn;
    @FXML
    private JFXButton searchPatientBtn;
    @FXML
    private Label lblpatid;
    @FXML
    private Label lblptype;
    @FXML
    private Label lblwnum;
    @FXML
    private Label lblbnum;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
          data = FXCollections.observableArrayList();
          setTableData();
          initCol();
          patientsList.getItems().setAll(data);
//          selectedRow();
    }
    
    public void setIndex(Index index){
        this.index = index;
        
    }

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
    private void addPatient(ActionEvent event) throws IOException {
        index.vpatStage.close();
        index.addPatients();
    }

    @FXML
    private void deletePatient(ActionEvent event) throws IOException {
        index.vpatStage.close();
        index.deletePatients();
    }

    @FXML
    private void updatePatient(ActionEvent event) throws IOException {
        index.vpatStage.close();
        index.updatePatients();
    }

    @FXML
    private void searchPatient(ActionEvent event) throws IOException {
        index.vpatStage.close();
        index.searchPatients();
    }

    public void setTableData(){
        try {
            Patients pat = new Patients();
            String query = "select * from PATIENTS_TABLE ";
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
            
            
            data.add(new Patients(patId, fname, lname,
                    age, matstat, gender, regdate,
                    address, city, phone, bloodgroup,
                    patienttype, wardnum, bednum));

            System.out.println(id + " " + patId + " " + fname);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewPatientsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void initCol(){
        
        _patID.setCellValueFactory(new PropertyValueFactory<>("patientid"));
        _fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
        _lname.setCellValueFactory(new PropertyValueFactory<>("lname"));
        _address.setCellValueFactory(new PropertyValueFactory<>("address"));
        
    }
    
    public void selectedRow(){
        
        try {
            
            String query = "select * from PATIENTS_TABLE ";
//
//          System.out.println(emb.execUpdate(query));
            ResultSet res = emb.execAction(query);
            while (res.next()){
    
            int id = res.getInt(1);
                System.out.println(id);
            }
        patientsList.getSelectionModel().selectedItemProperty().addListener(
                    (ObservableValue<? extends Patients> observable,
                            Patients oldValue,
                            Patients newValue) -> {
                        if (newValue == null){
                            return;
                        }
                        int id = newValue.getID();
                        System.out.println(id);
                        Patients pat = new Patients();
                        pat = data.get(id);
                        System.out.println(pat);
                        
//                        lblpatid.setText(pat.getPatientid());
//                        lblname.setText(pat.getFname() + " "+ pat.getLname());
//                        lbladdress.setText(pat.getAddress());
//                        lblcity.setText(pat.getCity());
//                        lblage.setText(pat.getAge().toString());
//                        lblgender.setText(pat.getGender());
//                        lblpnum.setText(pat.getPhonenum());
//                        lblmstat.setText(pat.getMaritalstatus());
//                        lblptype.setText(pat.getPatienttype());
//                        lblbgroup.setText(pat.getBloodgroup());
//                        lblwnum.setText(pat.getWardnum().toString());
//                        lblbnum.setText(pat.getBednum().toString());


                    
                    });
        } catch (SQLException ex) {
            Logger.getLogger(ViewPatientsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws SQLException {
        ViewPatientsController view = new ViewPatientsController();
        view.selectedRow();
    }

}