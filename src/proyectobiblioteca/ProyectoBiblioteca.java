package proyectobiblioteca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author victormanuel
 */
public class ProyectoBiblioteca extends Application {
    
    @Override
    public void start(Stage stage) {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("controllersAndGui/InicioRegistroModificar.fxml"));       
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {      
        launch(args);
    }
    
    
}
