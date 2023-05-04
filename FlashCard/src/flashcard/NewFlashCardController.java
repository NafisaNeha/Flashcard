package flashcard;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class NewFlashCardController implements Initializable {

  
    private Parent root;
    private Stage stage;
    private Scene scene;
    
    @FXML
    private TextField quesText;

    @FXML 
    private TextField ansText;

    @FXML
    private MenuBar mainMenu;
    
    ArrayList<Card> cardList=new ArrayList<Card>();
    
    FileChooser fileChooser = new FileChooser();
    
    

    

   
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
    public void endProgram() {
  
        Platform.exit();
        System.exit(0);
        
    }
    
    public void nextCard(){
        //create a flashcard
        Card card = new Card(quesText.getText(),ansText.getText());
        cardList.add(card);
        quesText.clear();
        ansText.clear();
        
        System.out.println(cardList.size());
    }
    
    public void SaveFile() throws IOException{
        
       
        File file =fileChooser.showSaveDialog(new Stage());
        if(file!=null) SaveSystem(file);
    }
    
    public void SaveSystem(File file) throws FileNotFoundException, IOException{
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        Iterator<Card> cardIterator= cardList .iterator();
        while(cardIterator.hasNext()){
            Card c=(Card)cardIterator.next();
            writer.write(c.getQuestion()+"/");
            writer.write(c.getAnswer()+"\n");            
        }
        writer.close();
        
        
    }
    
   
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser.setInitialDirectory(new File("D:\\FlashCard"));
    }
   
    
}
