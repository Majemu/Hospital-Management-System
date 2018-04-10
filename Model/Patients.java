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
public class Patients {
    
    private SimpleStringProperty fname;
    private SimpleStringProperty lname;
    private SimpleStringProperty phonenum;
    private SimpleStringProperty patientid;
    private SimpleStringProperty address;
    private SimpleStringProperty gender;
    private SimpleStringProperty city;
    private SimpleStringProperty maritalstatus;
    private SimpleStringProperty bloodgroup;
    private SimpleStringProperty patienttype;
    private SimpleStringProperty regDate;
    private SimpleIntegerProperty age;
    private SimpleIntegerProperty wardnum;
    private SimpleIntegerProperty bednum;
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

    public String getPatientid() {
        return patientid.get();
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

    public String getPatienttype() {
        return patienttype.get();
    }

    public String getRegDate() {
        return regDate.get();
    }

    public Integer getAge() {
        return age.get();
    }

    public Integer getWardnum() {
        return wardnum.get();
    }

    public Integer getBednum() {
        return bednum.get();
    }

    public Integer getID() {
        return ID.get();
    }

    public DBHandler getDbh() {
        return dbh;
    }

    

    
    
    public Patients(Integer ID, String patientid, String fname, String lname, Integer age, String maritalstatus, String gender, String regDate, String address, String city, String phonenum, String bloodgroup, String patienttype, Integer wardnum, Integer bednum) {
        this.fname = new SimpleStringProperty(fname);
        this.lname = new SimpleStringProperty(lname);
        this.phonenum = new SimpleStringProperty(phonenum);
        this.patientid = new SimpleStringProperty(patientid);
        this.address = new SimpleStringProperty(address);
        this.gender = new SimpleStringProperty(gender);
        this.city = new SimpleStringProperty(city);
        this.maritalstatus = new SimpleStringProperty(maritalstatus);
        this.bloodgroup = new SimpleStringProperty(bloodgroup);
        this.patienttype = new SimpleStringProperty(patienttype);
        this.regDate = new SimpleStringProperty(regDate);
        this.age = new SimpleIntegerProperty(age);
        this.wardnum = new SimpleIntegerProperty(wardnum);
        this.bednum = new SimpleIntegerProperty(bednum);
        this.ID = new SimpleIntegerProperty(ID);
        dbh = new DBHandler();
    }

    public Patients(String patientid, String fname, String lname, Integer age, String maritalstatus, String gender, String regDate, String address, String city, String phonenum, String bloodgroup, String patienttype, Integer wardnum, Integer bednum) {
        this.fname = new SimpleStringProperty(fname);
        this.lname = new SimpleStringProperty(lname);
        this.phonenum = new SimpleStringProperty(phonenum);
        this.patientid = new SimpleStringProperty(patientid);
        this.address = new SimpleStringProperty(address);
        this.gender = new SimpleStringProperty(gender);
        this.city = new SimpleStringProperty(city);
        this.maritalstatus = new SimpleStringProperty(maritalstatus);
        this.bloodgroup = new SimpleStringProperty(bloodgroup);
        this.patienttype = new SimpleStringProperty(patienttype);
        this.regDate = new SimpleStringProperty(regDate);
        this.age = new SimpleIntegerProperty(age);
        this.wardnum = new SimpleIntegerProperty(wardnum);
        this.bednum = new SimpleIntegerProperty(bednum);
        
    }
    
    public Patients(String patientid, String fname, String lname, Integer age, String maritalstatus, String gender, String regDate, String address, String city, String phonenum, String bloodgroup, String patienttype) {
        this.fname = new SimpleStringProperty(fname);
        this.lname = new SimpleStringProperty(lname);
        this.phonenum = new SimpleStringProperty(phonenum);
        this.patientid = new SimpleStringProperty(patientid);
        this.address = new SimpleStringProperty(address);
        this.gender = new SimpleStringProperty(gender);
        this.city = new SimpleStringProperty(city);
        this.maritalstatus = new SimpleStringProperty(maritalstatus);
        this.bloodgroup = new SimpleStringProperty(bloodgroup);
        this.patienttype = new SimpleStringProperty(patienttype);
        this.regDate = new SimpleStringProperty(regDate);
        this.age = new SimpleIntegerProperty(age);
        
        
    }
    
    
    
    public Patients(){
        
    }
    
    public static boolean validateFirstname(String firstname){
         
       String regExpfname = "[a-zA-Z]+"; 
       return firstname.matches(regExpfname); 
    }
    
    public static boolean validateLastname(String lastname){
         
       String regExplname = "[a-zA-Z]+"; 
       return lastname.matches(regExplname); 
    }
    
    public boolean addPat(Patients pat)
    {
        dbh = new DBHandler();
        String query = "INSERT into PATIENTS_TABLE(PatientID, firstName, lastName,"
                + " Age, MaritalStatus, Gender, RegDate, Address, City, PhoneNo, BloodGroup,"
                + "PatientType, WardNo, BedNo) VALUES('"+pat.getPatientid()+"','"+pat.getFname()+"',"
                + "'"+pat.getLname()+"',"+pat.getAge()+",'"+pat.getMaritalstatus()+"', '"+pat.getGender()+"',"
                + "'"+pat.getRegDate()+"', '"+pat.getAddress()+"', '"+pat.getCity()+"', '"+pat.getPhonenum()+"',"
                + "'"+pat.getBloodgroup()+"', '"+pat.getPatienttype()+"', "+pat.getWardnum()+", "+pat.getBednum()+")";
         
        System.out.println(query);
        
        return dbh.execUpdate(query);
        
        
    
    
    }
}

                