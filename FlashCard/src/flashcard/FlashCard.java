package flashcard;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FlashCard extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root;

        root = FXMLLoader.load(getClass().getResource("FlashCardMenu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
