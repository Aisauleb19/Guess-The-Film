package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.score;

public class FinishedController implements Initializable {

    @FXML
    private Button restrat_btn;

    @FXML
    private Button exit_btn;

    @FXML
    private Text score_number;

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void restart (ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        // SCORE RESET
        score = 0;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        score_number.setText(score+"");
    }

}