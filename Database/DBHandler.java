/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Patients;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author User
 */
public class DBHandler {
    private Connection con;
    private final String URL = "jdbc:derby:SMS;create=true";
    private Statement stmt;
    private ResultSet res;
    public ObservableList<Patients>data;
    
    public DBHandler(){
        connection();  //establish connection 
//        countRows();
        createPatientsTable();
        dropTable();
        
        
    }
    
    public void connection()
    {
        try {
            //register driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            
            //create connection
            con = DriverManager.getConnection(URL);
            
            System.out.println("connection successful");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Boolean execUpdate(String query){
        try {
            stmt = con.createStatement();
            stmt.execute(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public ResultSet execAction(String query)
    {
        try {
            stmt = con.createStatement();
            return stmt.executeQuery(query); 
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public int countRows(){
        int count = 0;
        try {
            while(res.next())
                count++;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());        }
        return count;
    }
    
    public void dropTable(){
          String TABLE_NAME = "DOCTORS_TABLE";
          
          try{
              // create statement for query execution
              stmt = con.createStatement();
              //get database metadata
              DatabaseMetaData dbm = con.getMetaData();
              //check if table book exists
              ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
              //check if table name exists
              if(tables.next()){
                  String query = "DROP TABLE DOCTORS_TABLE";
                  if (stmt.execute(query))
                      System.out.println("Table "+ TABLE_NAME + "deleted");
              }else{
                  System.out.println("hello");
              }
                  
              
          }catch(SQLException sql){
              System.out.println("error " + sql.toString());
              
          }
      
      }
    
    public void createPatientsTable()
    {
        //declare local variable 
        String TABLE_NAME = "PATIENTS_TABLE";
        
        //create try-catch block
        try{
            //create statement for query execution
            stmt = con.createStatement();
            
            //get database metadata
            DatabaseMetaData dbm = con.getMetaData();
            
            //check if table book exists
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            
            //check if table name exists
            if(tables.next())
                System.out.println("Table " + TABLE_NAME + " already exists. Ready for go!");
             else{
                stmt.execute("CREATE TABLE " + TABLE_NAME + " ("
                            + " id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1 , INCREMENT BY 1), \n "
                            + " PatientID varchar(50), \n "
                            + " firstName varchar(50), \n "
                            + " lastName varchar(50), \n "
                            + " Age int, \n "
                            + " MaritalStatus varchar(50), \n "
                            + " Gender varchar(50), \n "
                            + " RegDate Date, \n "
                            + " Address varchar(150), \n "
                            + " City varchar(50), \n "
                            + " PhoneNo varchar(20), \n "
                            + " BloodGroup varchar(50), \n "
                            + " PatientType varchar(50), \n "
                            + " WardNo int, \n "
                            + " BedNo int \n "
                            + " )" ); 
                
            }
            
        }
        catch(SQLException sql){
            System.err.println(sql.getMessage() + "------setupDatabase");
        }
    }
    
    public void createDoctorsTable()
    {
        //declare local variable 
        String TABLE_NAME = "DOCTORS_TABLE";
        
        //create try-catch block
        try{
            //create statement for query execution
            stmt = con.createStatement();
            
            //get database metadata
            DatabaseMetaData dbm = con.getMetaData();
            
            //check if table book exists
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            
            //check if table name exists
            if(tables.next())
                System.out.println("Table " + TABLE_NAME + " already exists. Ready for go!");
             else{
                stmt.execute("CREATE TABLE " + TABLE_NAME + " ("
                            + " id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1 , INCREMENT BY 1), \n "
                            + " DoctorID varchar(50), \n "
                            + " firstName varchar(50), \n "
                            + " lastName varchar(50), \n "
                            + " Age int, \n "
                            + " MaritalStatus varchar(50), \n "
                            + " Gender varchar(50), \n "
                            + " Specialization Date, \n "
                            + " Address varchar(150), \n "
                            + " City varchar(50), \n "
                            + " PhoneNo varchar(20), \n "
                            + " BloodGroup varchar(50), \n "
                            + " Level varchar(50), \n "
                            + " JoiningDate Date, \n "
                            + " LeavingDate Date, \n"
                            + " Username varchar(25), \n"
                            + " Password varchar (25) \n "
                            + " )" ); 
                
            }
            
        }
        catch(SQLException sql){
            System.err.println(sql.getMessage() + "------setupDatabase");
        }
    }
    
    public void createRecepsTable()
    {
        //declare local variable 
        String TABLE_NAME = "RECEPTIONISTS_TABLE";
        
        //create try-catch block
        try{
            //create statement for query execution
            stmt = con.createStatement();
            
            //get database metadata
            DatabaseMetaData dbm = con.getMetaData();
            
            //check if table book exists
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            
            //check if table name exists
            if(tables.next())
                System.out.println("Table " + TABLE_NAME + " already exists. Ready for go!");
             else{
                stmt.execute("CREATE TABLE " + TABLE_NAME + " ("
                            + " id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1 , INCREMENT BY 1), \n "
                            + " recep_username varchar(50), \n "
                            + " recep_password varchar(50), \n "
                            + " recep_email varchar(200) \n "
                            + " )" ); 
                
            }
            
        }
        catch(SQLException sql){
            System.err.println(sql.getMessage() + "------setupDatabase");
        }
    }
    
//    public void buidData() throws SQLException{
//        data = FXCollections.observableArrayList();
//         String query = "select * from PATIENTS_TABLE ";
////          
////          System.out.println(emb.execUpdate(query));
//         ResultSet res = emb.execAction(query);
//        while (res.next()){
//            Patients pati = new Patients();
//            data.add(pati.)
//        }
//            
//    }
    
    /**
     * 
     */
    
    
     public static void main(String[] args) throws SQLException {
         DBHandler emb = new DBHandler();
         
        
         
//String query = "INSERT into DOCTORS_TABLE(DoctorID, firstName, lastName, Age, MaritalStatus, Gender, Address, City, "
//                + "JoiningDate, LeavingDate) VALUES('DOC/001','Segun','Hassan', 45, 'Married', 'Male', 'Ikotun','Lagos',"
//                + "'2017-12-01',"
//                + "'2020-11-29')";
//emb.execUpdate(query);
////emb.execAction(query);
         

//        String query = "SELECT * from DOCTORS_TABLE";
//        
//         ResultSet res = emb.execAction(query);
//        while (res.next())
//            System.out.println("Details are" + res.getString(1) + res.getString(2) + res.getString(3) + res.getString(4) + res.getString(8) + res.getString(9) + res.getString(14) + res.getString(15));
     }      
}
