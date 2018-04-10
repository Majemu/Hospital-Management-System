/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class DatabaseHandler {
    
    //declare database constants
    private Connection con;   //for establishing connection to dnb
    private final String URL = "jdbc:mysql://localhost/register";
    private final String USER = "root";
    private final String PASS = "";
    private Statement stmt;
    private ResultSet res;
    
    public DatabaseHandler()
    {
        connection();  //establish connection 
    }
    
    /**
     * method to establish connection
     */
    public void connection()
    {
        try {
            //register driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //create connection
            con = DriverManager.getConnection(URL, USER, PASS);
            
            System.out.println("connection successful");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param query
     * @return 
     */
    public Boolean execUpdate(String query)
    {
        try {
            stmt = con.createStatement();
            stmt.execute(query);  //execute query with statement
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    /**
     * 
     * @param query
     * @return 
     */
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
    
//    public void retrieveTableInfo()
//    {
//        try {
//            DatabaseMetaData dbmd = con.getMetaData();
//          
//            ResultSet rsTables = dbmd.getTables(null, null, null, new String[]{"TABLE"});
//            
//            System.out.println("USER TABLES");
//            
//            while(rsTables.next()){
//                System.out.println(rsTables.getString("TABLE_NAME"));
////                        System.out.println("Table already exists");
////                        break;   
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    /**
     * method to return number of records in result set
     * @param res
     * @return 
     */
    public int countRows(ResultSet res)
    {
        //declare count variable
        int count = 0;
        
        try{
        //run result set throught loop
            while(res.next())
                    count++;
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getLocalizedMessage());
        }
        
        return count;
        
    }
    
    
    
//    public static void main(String [] args) throws SQLException
//    {
//        DatabaseHandler dbh = new DatabaseHandler();
//        //dbh.retrieveTableInfo();
//        
//         String fn = "Felony";  
//         String ln = "mask";
//         String mn = "m";
//         String dob = "2001-05-15";
//         String email = "felony@gmail.com";
//         
//         //query to  insert record
//         String query1 = "insert into students values (0 , '"+ fn +"' , '"+ ln +"' , '"+ mn +"' , '"+ dob +"' , '"+ email +"' , now()) ";
//        
//         String query = "select * from students where "
//                         + "first_name = '"+fn+"' "
//                         + "and last_name = '"+ln+"' "
//                         + "and middle_name = '"+mn+"' "
//                         + "and date_of_birth = '"+dob+"' "
//                         + "and email = '"+email+"'";
//         
//         System.out.println(query);
//        
//         ResultSet res = dbh.execAction(query);
//         int count = dbh.countRows(res);
//         
//         if(count == 0){
//             if(dbh.execUpdate(query1))
//                 System.out.println("New record added");
//         }     
//         else
//             System.out.println("record already exists");
//        
//    }
    
}
