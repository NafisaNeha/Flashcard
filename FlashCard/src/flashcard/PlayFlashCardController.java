package flashcard;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class PlayFlashCardController implements Initializable {

    private Parent root;
    private Stage stage;
    private Scene scene;

    private MenuBar mainMenu;
   

    //Home
    public void goToMenu(ActionEvent event) {

        try {
            root = FXMLLoader.load(getClass().getResource("FlashCardMenu.fxml"));
            stage = (Stage) mainMenu.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            System.out.println("File Not Found");
        }
    }

    //Exit
    @FXML
    public void endProgram() {

        Platform.exit();
        System.exit(0);

    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
