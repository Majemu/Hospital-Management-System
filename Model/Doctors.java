/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.DBHandler;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author User
 */
public class Doctors {
    
    private SimpleStringProperty doctorID;
    private SimpleStringProperty fname;
    private SimpleStringProperty lname;
    private SimpleIntegerProperty age;
    private SimpleStringProperty phonenum;
    private SimpleStringProperty specialization;
    private SimpleStringProperty address;
    private SimpleStringProperty gender;
    private SimpleStringProperty city;
    private SimpleStringProperty maritalstatus;
    private SimpleStringProperty bloodgroup;
    private SimpleStringProperty level;
    private SimpleStringProperty joiningDate;
    private SimpleStringProperty leavingDate;
    private SimpleStringProperty username;
    private SimpleStringProperty password;
    private SimpleIntegerProperty ID;
    private DBHandler dbh;

    
    public String getFname() {
        return fname.get();
    }

    public String getLname() {
        return lname.get();
    }

    public String getPhonenum() {
        return phonenum.get();
    }

    public String getDoctorid() {
        return doctorID.get();
    }

    public String getAddress() {
        return address.get();
    }

    public String getGender() {
        return gender.get();
    }

    public String getCity() {
        return city.get();
    }

    public String getMaritalstatus() {
        return maritalstatus.get();
    }

    public String getBloodgroup() {
        return bloodgroup.get();
    }

    public String getSpecialization() {
        return specialization.get();
    }

    public String getBloodGroup() {
        return bloodgroup.get();
    }
    
    public String getLevel() {
        return level.get();
    }

    public Integer getAge() {
        return age.get();
    }

    public String getJoiningDate() {
        return joiningDate.get();
    }

    public String getLeavingDate() {
        return leavingDate.get();
    }
    
    public String getUsername() {
        return username.get();
    }

    public String getPassword() {
        return password.get();
    }

    public Integer getID() {
        return ID.get();
    }

    public DBHandler getDbh() {
        return dbh;
    }

    

    
    
    public Doctors(Integer ID, String doctorID, String fname, String lname, Integer age, String maritalstatus, String gender, String specialization, String address, String city, String phonenum, String bloodgroup, String level, String joiningDate, String leavingDate, String username, String password) {
        this.fname = new SimpleStringProperty(fname);
        this.lname = new SimpleStringProperty(lname);
        this.phonenum = new SimpleStringProperty(phonenum);
        this.doctorID = new SimpleStringProperty(doctorID);
        this.address = new SimpleStringProperty(address);
        this.gender = new SimpleStringProperty(gender);
        this.city = new SimpleStringProperty(city);
        this.maritalstatus = new SimpleStringProperty(maritalstatus);
        this.bloodgroup = new SimpleStringProperty(bloodgroup);
        this.specialization = new SimpleStringProperty(specialization);
        this.level = new SimpleStringProperty(level);
        this.age = new SimpleIntegerProperty(age);
        this.joiningDate = new SimpleStringProperty(joiningDate);
        this.leavingDate = new SimpleStringProperty(leavingDate);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.ID = new SimpleIntegerProperty(ID);
        dbh = new DBHandler();
    }

    public Doctors(String doctorID, String fname, String lname, Integer age, String maritalstatus, String gender, String specialization, String address, String city, String phonenum, String bloodgroup, String level, String joiningDate, String leavingDate, String username, String password) {
        this.fname = new SimpleStringProperty(fname);
        this.lname = new SimpleStringProperty(lname);
        this.phonenum = new SimpleStringProperty(phonenum);
        this.doctorID = new SimpleStringProperty(doctorID);
        this.address = new SimpleStringProperty(address);
        this.gender = new SimpleStringProperty(gender);
        this.city = new SimpleStringProperty(city);
        this.maritalstatus = new SimpleStringProperty(maritalstatus);
        this.bloodgroup = new SimpleStringProperty(bloodgroup);
        this.specialization = new SimpleStringProperty(specialization);
        this.level = new SimpleStringProperty(level);
        this.age = new SimpleIntegerProperty(age);
        this.joiningDate = new SimpleStringProperty(joiningDate);
        this.leavingDate = new SimpleStringProperty(leavingDate);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
    }
    
    
    
    public Doctors(){
        
    }
    
    public static boolean validateFirstname(String firstname){
         
       String regExpfname = "[a-zA-Z]+"; 
       return firstname.matches(regExpfname); 
    }
    
    public static boolean validateLastname(String lastname){
         
       String regExplname = "[a-zA-Z]+"; 
       return lastname.matches(regExplname); 
    }
    
    public boolean addDoc(Doctors doc)
    {
        dbh = new DBHandler();
        String query = "INSERT into DOCTORS_TABLE(DoctorID, firstName, lastName,"
                + " Age, MaritalStatus, Gender, Specialization, Address, City, PhoneNo, BloodGroup,"
                + "Level, JoiningDate, LeavingDate, Username, Password) VALUES('"+doc.getDoctorid()+"','"+doc.getFname()+"',"
                + "'"+doc.getLname()+"',"+doc.getAge()+",'"+doc.getMaritalstatus()+"', '"+doc.getGender()+"',"
                + "'"+doc.getSpecialization()+"', '"+doc.getAddress()+"', '"+doc.getCity()+"', '"+doc.getPhonenum()+"',"
                + "'"+doc.getBloodgroup()+"', '"+doc.getLevel()+"', '"+doc.getJoiningDate()+"',"
                + "'"+doc.getLeavingDate()+"', '"+doc.getUsername()+"', '"+doc.getPassword()+"')";
         
        System.out.println(query);
        
        return dbh.execUpdate(query);
        
        
    
    
    }
    public static void main(String[] args) {
        
    }
}

                