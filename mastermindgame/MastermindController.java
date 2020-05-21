package mastermindgame;

import java.io.IOException;
import java.security.SecureRandom;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MastermindController {
    @FXML
    private final Pane rootPane = new Pane();
            
            
    @FXML
    void PlayButtonClicked(ActionEvent event) throws IOException, Exception {
        Pane gamePane = FXMLLoader.load(getClass().getResource("MastermindGame.fxml"));
        rootPane.getChildren().setAll(gamePane);
        Platform.exit();
        gameStart(new Stage());
    }

    @FXML
    void QuitButtonClicked(ActionEvent event) {
        Platform.exit();
    }
    
      public void gameStart(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MastermindGame.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Mastermind Game");
        stage.setScene(scene);
        stage.show();
      }
      
     public void initialize(){
         
     }

}
