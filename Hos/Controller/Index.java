package Hos.Controller;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Index extends Application{

    public Stage primaryStage;
    public Stage secondaryStage;
    public Stage adminStage;
    public Stage recepStage;
    public Stage docStage;
    public Stage vpatStage;
    public Stage apatStage;
    public Stage dpatStage;
    public Stage upatStage;
    public Stage spatStage;
    
    
    @Override    
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        // add fxml loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Index.fxml"));
        AnchorPane pane = loader.load();
        
        //create scene
        Scene scene = new Scene(pane);
        
        // create controller
        IndexController indCtrl = loader.getController();
        indCtrl.setIndex(this);
        
        
        //setup stage
        primaryStage.setTitle("Hospital Management System");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void Admin()throws IOException{
         //add FXML Loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/AdminLogin.fxml"));
        AnchorPane pane = loader.load();
        
        // create controller
        AdiminLoginController sign = loader.getController();
        sign.setIndex(this);
        
        
        Scene scene = new Scene(pane);
        
        //setup stage
        secondaryStage = new Stage();
        secondaryStage.initOwner(primaryStage);
        secondaryStage.initModality(Modality.WINDOW_MODAL);
        secondaryStage.setTitle("Admin Login Portal");
        secondaryStage.setResizable(false);
        secondaryStage.setScene(scene);
        secondaryStage.show();
    }
    
    public void Recep() throws IOException{
        //add FXML Loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/RecepLogin.fxml"));
        AnchorPane pane = loader.load();
        
        // create controller
        RecepLoginController sign = loader.getController();
        sign.setIndex(this);
        
        
        Scene scene = new Scene(pane);
        
        //setup stage
        secondaryStage = new Stage();
        secondaryStage.initOwner(primaryStage);
        secondaryStage.initModality(Modality.WINDOW_MODAL);
        secondaryStage.setTitle("Receptionist Login Portal");
        secondaryStage.setResizable(false);
        secondaryStage.setScene(scene);
        secondaryStage.show();
    
    }
    
    public void Doctor() throws IOException{
        //add FXML Loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/DocLogin.fxml"));
    AnchorPane pane = loader.load();
        
        // create controller
        DocLoginController sign = loader.getController();
        sign.setIndex(this);
        
        
        Scene scene = new Scene(pane);
        
        //setup stage
        secondaryStage = new Stage();
        secondaryStage.initOwner(primaryStage);
        secondaryStage.initModality(Modality.WINDOW_MODAL);
        secondaryStage.setTitle("Doctor Login Portal");
        secondaryStage.setResizable(false);
        secondaryStage.setScene(scene);
        secondaryStage.show();
    
    }
    
    public void adminPort()throws IOException{
        
        //add FXML Loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/AdminPort.fxml"));
    AnchorPane pane = loader.load();
        
        // create controller
        AdminPortController sign = loader.getController();
        sign.setIndex(this);
        
        
        Scene scene = new Scene(pane);
        
        //setup stage
        adminStage = new Stage();
        adminStage.initOwner(primaryStage);
        adminStage.initModality(Modality.WINDOW_MODAL);
        adminStage.setTitle("Admin Portal");
        adminStage.setResizable(false);
        adminStage.setScene(scene);
        adminStage.show();
    }
    
    public void docPort()throws IOException{
        
        //add FXML Loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/DocPort.fxml"));
    AnchorPane pane = loader.load();
        
        // create controller
        DocPortController sign = loader.getController();
        sign.setIndex(this);
        
        
        Scene scene = new Scene(pane);
        
        //setup stage
        docStage = new Stage();
        docStage.initOwner(primaryStage);
        docStage.initModality(Modality.WINDOW_MODAL);
        docStage.setTitle("Doctor Portal");
        docStage.setResizable(false);
        docStage.setScene(scene);
        docStage.show();
    }
    
    public void recepPort()throws IOException{
        
        //add FXML Loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/RecepPort.fxml"));
    AnchorPane pane = loader.load();
        
        // create controller
        recepPortController sign = loader.getController();
        sign.setIndex(this);
        
        
        Scene scene = new Scene(pane);
        
        //setup stage
        recepStage = new Stage();
        recepStage.initOwner(primaryStage);
        recepStage.initModality(Modality.WINDOW_MODAL);
        recepStage.setTitle("Doctor Portal");
        recepStage.setResizable(false);
        recepStage.setScene(scene);
        recepStage.show();
    }
    
    public void viewPatients()throws IOException{
        
        //add FXML Loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ViewPatients.fxml"));
    AnchorPane pane = loader.load();
        
        // create controller
        ViewPatientsController sign = loader.getController();
        sign.setIndex(this);
        
        
        Scene scene = new Scene(pane);
        
        //setup stage
        vpatStage = new Stage();
        vpatStage.initOwner(primaryStage);
        vpatStage.initModality(Modality.WINDOW_MODAL);
        vpatStage.setTitle("View Patients");
        vpatStage.setResizable(false);
        vpatStage.setScene(scene);
        vpatStage.show();
    }
    
    public void addPatients()throws IOException{
        
        //add FXML Loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/AddPatient.fxml"));
    AnchorPane pane = loader.load();
        
        // create controller
        AddPatientsController sign = loader.getController();
        sign.setIndex(this);
        
        
        Scene scene = new Scene(pane);
        
        //setup stage
        apatStage = new Stage();
        apatStage.initOwner(primaryStage);
        apatStage.initModality(Modality.WINDOW_MODAL);
        apatStage.setTitle("Admin Portal");
        apatStage.setResizable(false);
        apatStage.setScene(scene);
        apatStage.show();
    }
    
    public void searchPatients()throws IOException{
        
        //add FXML Loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/SearchPatient.fxml"));
    AnchorPane pane = loader.load();
        
        // create controller
        SearchPatientController sign = loader.getController();
        sign.setIndex(this);
        
        
        Scene scene = new Scene(pane);
        
        //setup stage
        spatStage = new Stage();
        spatStage.initOwner(primaryStage);
        spatStage.initModality(Modality.WINDOW_MODAL);
        spatStage.setTitle("Search Patient");
        spatStage.setResizable(false);
        spatStage.setScene(scene);
        spatStage.show();
    }
    
    public void deletePatients()throws IOException{
        
        //add FXML Loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/DeletePatient.fxml"));
        AnchorPane pane = loader.load();
        
        // create controller
        DeletePatientController sign = loader.getController();
        sign.setIndex(this);
        
        
        Scene scene = new Scene(pane);
        
        //setup stage
        dpatStage = new Stage();
        dpatStage.initOwner(primaryStage);
        dpatStage.initModality(Modality.WINDOW_MODAL);
        dpatStage.setTitle("Delete Patient");
        dpatStage.setResizable(false);
        dpatStage.setScene(scene);
        dpatStage.show();
    }
    
    public void updatePatients()throws IOException{
        
        //add FXML Loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/UpdatePatient.fxml"));
        AnchorPane pane = loader.load();
        
        // create controller
        UpdatePatientController sign = loader.getController();
        sign.setIndex(this);
        
        
        Scene scene = new Scene(pane);
        
        //setup stage
        upatStage = new Stage();
        upatStage.initOwner(primaryStage);
        upatStage.initModality(Modality.WINDOW_MODAL);
        upatStage.setTitle("Update Patient");
        upatStage.setResizable(false);
        upatStage.setScene(scene);
        upatStage.show();
    }
    
    public void addDoctor()throws IOException{
        
        //add FXML Loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/AddDoctor.fxml"));
    AnchorPane pane = loader.load();
        
        // create controller
        AddDoctorController sign = loader.getController();
        sign.setIndex(this);
        
        
        Scene scene = new Scene(pane);
        
        //setup stage
        apatStage = new Stage();
        apatStage.initOwner(primaryStage);
        apatStage.initModality(Modality.WINDOW_MODAL);
        apatStage.setTitle("Add Doctor");
        apatStage.setResizable(false);
        apatStage.setScene(scene);
        apatStage.show();
    }
    
    public void viewDoctors()throws IOException{
        
        //add FXML Loader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ViewDoctors.fxml"));
    AnchorPane pane = loader.load();
        
        // create controller
        ViewDoctorsController sign = loader.getController();
        sign.setIndex(this);
        
        
        Scene scene = new Scene(pane);
        
        //setup stage
        vpatStage = new Stage();
        vpatStage.initOwner(primaryStage);
        vpatStage.initModality(Modality.WINDOW_MODAL);
        vpatStage.setTitle("View Doctors");
        vpatStage.setResizable(false);
        vpatStage.setScene(scene);
        vpatStage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
