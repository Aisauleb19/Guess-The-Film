package sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import sun.security.krb5.Asn1Exception;

import static sample.Main.score;
import static sample.Main.CHANGE;

import java.util.Date;

import java.util.TimerTask;
import java.util.Timer;

public class Controller {

    int index = 0;
    Boolean b[] = new Boolean[20];
    Boolean ans = false;
    Random rnd = new Random();

    TimerTask timerTask;
    // стартуем TimerTask в виде демона
    
    Timer timer1;
    // будем запускать каждых 10 секунд (10 * 1000 миллисекунд)
    
    String s[] = {"Three Idiots", "Forrest Gump", "Guardians of the Galaxy", "The Dark Knight", "Kung Fu Panda 3",
            "The Shawshank Redemption", "Up", "The Hobbit", "Terminator 2", "  Arrival",
            "The Godfather", "La La Land", "Gladiator", "Despicable Me 2", "Back to the Future",
            "Star Wars", "Homa Alone", "Alice in Wonderland", "Zootopia", "Titanic"};

    @FXML
    private ImageView background;

    @FXML
    private ImageView start_btn;

    @FXML
    private ImageView film_img0;

    @FXML
    private ImageView film_img1, film_img2, film_img3, film_img4, film_img5,
                      film_img6, film_img7, film_img8, film_img9, film_img10,
                      film_img11, film_img12, film_img13, film_img14, film_img15,
                      film_img16, film_img17, film_img18, film_img19;

    @FXML
    private Text film_name,scoretext,score,timetext,timer;

    @FXML
    private ImageView no_btn;

    @FXML
    private ImageView yes_btn;

    @FXML
    void start(MouseEvent event) {
    	
        
        
        
        start_btn.setVisible(false);
        film_img0.setVisible(true);
        film_name.setVisible(true);
        yes_btn.setVisible(true);
        no_btn.setVisible(true);
        score.setVisible(true);
        scoretext.setVisible(true);
        timetext.setVisible(true);
        timer.setVisible(true);
        showGame();
    }

       //BUTTON YES
    @FXML
    void yes (MouseEvent event) {
    	try {
    		timer1.cancel();
    	}
    	catch(Exception e){
    		
    	}
    	if (ans){
            Main.score++;
            score.setText("" + (Main.score + 1));
        }
        if (index == 20) {
            System.out.println ("SCORE = " + Main.score);
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("finished.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            return;
        }

        //CAHNGE VISIBLE VALUE OF IMAGE
        //INDEX -> CURRENT IMAGE ID
        for (int i = 0; i < 20; i++) {
            if (i == index) b[i] = true;
            else b[i] = false;
        }

        film_img0.setVisible(b[0]);
        film_img1.setVisible(b[1]);
        film_img2.setVisible(b[2]);
        film_img3.setVisible(b[3]);
        film_img4.setVisible(b[4]);
        film_img5.setVisible(b[5]);
        film_img6.setVisible(b[6]);
        film_img7.setVisible(b[7]);
        film_img8.setVisible(b[8]);
        film_img9.setVisible(b[9]);
        film_img10.setVisible(b[10]);
        film_img11.setVisible(b[11]);
        film_img12.setVisible(b[12]);
        film_img13.setVisible(b[13]);
        film_img14.setVisible(b[14]);
        film_img15.setVisible(b[15]);
        film_img16.setVisible(b[16]);
        film_img17.setVisible(b[17]);
        film_img18.setVisible(b[18]);
        film_img19.setVisible(b[19]);

        showGame();
        
    }

    //BUTTON NO
    @FXML
    void no (MouseEvent event) {
    	try {
    		timer1.cancel();
    	}
    	catch(Exception e){
    		
    	}
        if (!ans) {
            Main.score++;
            score.setText("" + (Main.score + 1));
        }
        if (index == 20) {
            System.out.println("SCORE = " + Main.score);
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("finished.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            return;
        }

        for (int i = 0; i < 20; i++) {
            if (i == index) b[i] = true;
            else b[i] = false;
        }

        film_img0.setVisible(b[0]);
        film_img1.setVisible(b[1]);
        film_img2.setVisible(b[2]);
        film_img3.setVisible(b[3]);
        film_img4.setVisible(b[4]);
        film_img5.setVisible(b[5]);
        film_img6.setVisible(b[6]);
        film_img7.setVisible(b[7]);
        film_img8.setVisible(b[8]);
        film_img9.setVisible(b[9]);
        film_img10.setVisible(b[10]);
        film_img11.setVisible(b[11]);
        film_img12.setVisible(b[12]);
        film_img13.setVisible(b[13]);
        film_img14.setVisible(b[14]);
        film_img15.setVisible(b[15]);
        film_img16.setVisible(b[16]);
        film_img17.setVisible(b[17]);
        film_img18.setVisible(b[18]);
        film_img19.setVisible(b[19]);

        showGame();
        
    }
    private void showGame() {
    	int k = 100;
    	timer.setText("" + k);
    	timer1 = new Timer();
    	TimerTask task1 = new TimerTask()
    	{
    	        public void run()
    	        {
    	        	if(Integer.parseInt(timer.getText()) != 0)
    	        		timer.setText("" + (Integer.parseInt(timer.getText()) - 1)); 
    	        	else if (Integer.parseInt(timer.getText()) == 0){
    	        		showGame();
    	        		timer1.cancel();
    	        	}
    	        }

    	};

    	if (!rnd.nextBoolean()) {
            for (int i = 0; i < 100; i++) {
                int x = rnd.nextInt(100);
                if (x != index) {
                    film_name.setText(s[x]);
                    film_name.setLayoutX(229 - ((s[x].length() - 12) * 9));
                    i = 100;
                }
            }
            ans = false;
        }
        else {
            film_name.setText(s[index]);
            film_name.setLayoutX(229 - ((s[index].length() - 12) * 9));
            ans = true;
        }
        index++;
       // while(Integer.parseInt(timer.getText()) != 0) {
        	timer1.schedule(task1,1000,1000);
        //}
        //timer1.schedule(task1, 1000);
    }
}
