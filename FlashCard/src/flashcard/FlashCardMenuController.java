package flashcard;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class FlashCardMenuController{

    
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private AnchorPane scenePane;
    
    
    
    public void newFlashCard(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("NewFlashCard.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            System.out.println("NewFlashCard Not Found");
        }
    }

    public void playFlashCard(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("PlayFlashCard.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            System.out.println("PlayflashCard Not Found");
        }
    }

    
    public void endProgram() {
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }
    



}
