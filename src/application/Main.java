package application;

import java.io.File;
import java.io.IOException;
import java.util.Timer;

import javax.swing.JOptionPane;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Main extends Application {
   public static String[] args2;

   public static void main(String[] args) {
      args2 = args;
      launch(args);

   }

   public static void restart() {
      main(args2);
   }

   @Override
   public void start(Stage Stage) throws Exception {

      try {

         Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
         TextField myEmail = (TextField) root.lookup("#myEmail");
         ImageView myWorld = (ImageView) root.lookup("#myWorld");

         TextField pw = (TextField) root.lookup("#myPw");
         Button login = (Button) root.lookup("#myLogin");
         System.out.print(pw.getText());
         MediaView media = (MediaView) root.lookup("#myVideo");

         Media mediaVideo = new Media(new File("C:\\Users\\PC-9000\\Documents\\ASTRONOMY LABS\\k.mp4").toURI().toString());
         MediaPlayer mpVideo = new MediaPlayer(mediaVideo);
         media.setMediaPlayer(mpVideo);
         mpVideo.play();
         mpVideo.setVolume(0.1);
         mpVideo.setAutoPlay(true);

         root.setOnKeyPressed(e -> {

            System.out.print(e.getCode());

         });

         login.setOnAction(new EventHandler < ActionEvent > () {
            @Override
            public void handle(ActionEvent event) {
               String password = pw.getText();

               // if (password.equals("admin")) {

               Controller x = new Controller();

               String Car = JOptionPane.showInputDialog("Pick Car: F1, Police, RaceCar");
               x.CarChoice = "#" + Car.toLowerCase();
               CarObject.stage2 = Stage;
               try {
                  x.switchToScene2(Stage);
               } catch (IOException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
                  //}
               }

               System.out.println(password);
            }
         });
         Stage.setTitle("2D Racing");
         Stage.setResizable(false);

         Scene scene = new Scene(root);
         Stage.setScene(scene);
         Stage.show();

      } catch (Exception e) {
         e.printStackTrace();
      }

   }

   public void onclick(MouseEvent k) {
      System.out.println("click");

   }
}
