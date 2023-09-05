package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller {

   private Stage stage;
   private Scene scene;
   private Parent root;
   private boolean isKeyPressed = false;
   private KeyCode currentKeyCode = null;
   private Timeline timeline;
   ImageView snake2;
   private Timeline timline;
   int x = 0;
   double getSpeedX1 = 0;
   static int speed = 0;
   static int randomness = 0;
   static int Points = 0;
   String CarChoice;

   boolean hit = true;
   double SpeedLineX = 0;
   double SpeedLineY = 1;
   double angle = 0;
   private static final double LINE_SPEED = 0.05;
   int GuageSpeed = 0;
   int SpaceCycle = 0;
   int CircleSpeed = 0;
   int i = 0;
   int Left = 7;
   int Right = 314;
   int Down = 681;
   ImageView snake;

   public void carpostion(ImageView k) {

      k.setLayoutX(206);
      k.setLayoutY(627);
      if (k.getId().equals("f1")) {
         Left = -20;
         Right = 285;
         Down = 715;

      }

   }

   public void switchToScene2(Stage stage) throws IOException {

      if (CarChoice.equals("#racecar")) CarChoice = "#snake";

      root = FXMLLoader.load(getClass().getResource("Main2.fxml"));
      snake = (ImageView) root.lookup(CarChoice);

      if (snake == null) {
         JOptionPane.showMessageDialog(null, "Input is Wrong, Default car will be selected");
         snake = (ImageView) root.lookup("#snake");
      }

      JOptionPane.showMessageDialog(null, "Hold SpaceBar to Accelerate");
      carpostion(snake);
      AnchorPane Map = (AnchorPane) root.lookup("#myMap");

      Line line = (Line) root.lookup("#speedline");
      Circle circle = (Circle) root.lookup("#Circle");
      Label Score = (Label) root.lookup("#Score");
      Label Gspeed = (Label) root.lookup("#GuageSpeed");
      ColorPicker theme = (ColorPicker) root.lookup("#Theme");

      ImageView Car1 = (ImageView) root.lookup("#Car1");
      ImageView Car2 = (ImageView) root.lookup("#Car2");
      ImageView Car3 = (ImageView) root.lookup("#Car3");
      ImageView Car4 = (ImageView) root.lookup("#Car4");

      ImageView road1 = (ImageView) root.lookup("#road11");
      ImageView road2 = (ImageView) root.lookup("#road12");
      ImageView road3 = (ImageView) root.lookup("#road13");
      ImageView road4 = (ImageView) root.lookup("#road14");
      ImageView road5 = (ImageView) root.lookup("#road15");
      ImageView road6 = (ImageView) root.lookup("#road16");

      ImageView road7 = (ImageView) root.lookup("#road21");
      ImageView road8 = (ImageView) root.lookup("#road22");
      ImageView road9 = (ImageView) root.lookup("#road23");
      ImageView road10 = (ImageView) root.lookup("#road24");
      ImageView road11 = (ImageView) root.lookup("#road25");
      ImageView road12 = (ImageView) root.lookup("#road26");

      ImageView road13 = (ImageView) root.lookup("#road31");
      ImageView road14 = (ImageView) root.lookup("#road32");
      ImageView road15 = (ImageView) root.lookup("#road33");
      ImageView road16 = (ImageView) root.lookup("#road34");
      ImageView road17 = (ImageView) root.lookup("#road35");
      ImageView road18 = (ImageView) root.lookup("#road36");

      ImageView road19 = (ImageView) root.lookup("#road41");
      ImageView road20 = (ImageView) root.lookup("#road42");
      ImageView road21 = (ImageView) root.lookup("#road43");
      ImageView road22 = (ImageView) root.lookup("#road44");
      ImageView road23 = (ImageView) root.lookup("#road45");
      ImageView road24 = (ImageView) root.lookup("#road46");

      Roads r1 = new Roads(road1);
      Roads r2 = new Roads(road2);
      Roads r3 = new Roads(road3);
      Roads r4 = new Roads(road4);
      Roads r5 = new Roads(road5);
      Roads r6 = new Roads(road6);

      Roads r7 = new Roads(road7);
      Roads r8 = new Roads(road8);
      Roads r9 = new Roads(road9);
      Roads r10 = new Roads(road10);
      Roads r11 = new Roads(road11);
      Roads r12 = new Roads(road12);

      Roads r13 = new Roads(road13);
      Roads r14 = new Roads(road14);
      Roads r15 = new Roads(road15);
      Roads r16 = new Roads(road16);
      Roads r17 = new Roads(road17);
      Roads r18 = new Roads(road18);

      Roads r19 = new Roads(road19);
      Roads r20 = new Roads(road20);
      Roads r21 = new Roads(road21);
      Roads r22 = new Roads(road22);
      Roads r23 = new Roads(road23);
      Roads r24 = new Roads(road24);

      CarObject car1 = new CarObject(Car1);
      CarObject car2 = new CarObject(Car2);
      CarObject car3 = new CarObject(Car3);
      CarObject car4 = new CarObject(Car4);

      root.setOnMouseClicked(event -> {
         System.out.println("Mouse clicked on Map");
      });

      snake2 = snake;

      MotionBlur motion = new MotionBlur();
      motion.setRadius(9);

      Map.setOnKeyPressed(e -> {

         KeyCode keyCode = e.getCode();
         System.out.println(e.getCode().toString());

         if (keyCode != currentKeyCode) {
            motion.setAngle(0);
            motion.setRadius(0);
            snake.setEffect(motion);
            if (timeline != null) {
               timeline.stop();
            }
            timeline = new Timeline(new KeyFrame(Duration.millis(25), event -> {

               switch (keyCode) {

               case LEFT:
                  if (snake.getLayoutX() > Left) {
                     motion.setAngle(67);
                     motion.setRadius(1.5);
                     snake.setLayoutX(snake.getLayoutX() - 10);
                     sendpos(car1, car2, car3, car4, snake);

                  }
                  break;
               case RIGHT:
                  if (snake.getLayoutX() < Right) {
                     motion.setAngle(67);
                     motion.setRadius(1.5);
                     snake.setEffect(motion);
                     snake.setLayoutX(snake.getLayoutX() + 10);
                     sendpos(car1, car2, car3, car4, snake);
                  }

                  break;
               case UP:
                  if (snake.getLayoutY() > 45) {
                     motion.setRadius(motion.getRadius() + 0.2);
                     snake.setEffect(motion);
                     snake.setLayoutY(snake.getLayoutY() - 10);
                     sendpos(car1, car2, car3, car4, snake);

                  }

                  break;
               case DOWN:
                  if (snake.getLayoutY() < Down)
                     snake.setLayoutY(snake.getLayoutY() + 10);
                  sendpos(car1, car2, car3, car4, snake);
                  break;

               case SPACE:

                  SpaceCycle++;
                  if (SpaceCycle == 1) {
                     if (GuageSpeed < 10) Gspeed.setText(" 00" + (GuageSpeed++));
                     else if (GuageSpeed < 100 && GuageSpeed >= 10) Gspeed.setText(" 0" + GuageSpeed++);
                     else Gspeed.setText(" " + GuageSpeed++);

                     GuageSpeed += 3;

                     if (GuageSpeed % 20 == 0 && CircleSpeed <= 220) {
                        try {

                           Circle circle1 = (Circle) root.lookup("#circle" + CircleSpeed);
                           circle1.setOpacity(1);
                           if (CircleSpeed <= 180) CircleSpeed += 20;

                        } catch (Exception e2) {
                           System.out.println(CircleSpeed);
                        }

                     }

                     //GuageSpeed+=0.5;

                     SpeedLineX += 0.3;
                     SpaceCycle = 0;
                  }
                 
                  if (getSpeedX1 == 0) getSpeedX1 = CarObject.x1;
                  CarObject.x1 += 0.2;
                  break;
               default:
                  break;

               }

            }));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
            currentKeyCode = keyCode;

         }
      });

      Map.setOnKeyReleased(e -> {
         if (timeline != null) {
            timeline.stop();
            timeline = null;
            if (e.getCode().toString().equals("SPACE")) {

               SpaceCycle = 0;

               CarObject.x1 = getSpeedX1 + 0.5;
               getSpeedX1 = 0;
               Timeline timelineForline = new Timeline();
               timelineForline.getKeyFrames().add(new KeyFrame(Duration.millis(20), event2 -> {          	  

                  SpaceCycle += 1;
                  if (SpaceCycle == 1) {

                     if (GuageSpeed < 10) Gspeed.setText(" 00" + (--GuageSpeed));
                     else if (GuageSpeed < 100 && GuageSpeed >= 10) Gspeed.setText(" 0" + (--GuageSpeed));
                     else Gspeed.setText(" " + --GuageSpeed);
                     GuageSpeed -= 3;
                     SpaceCycle = 0;

                     if (GuageSpeed % 20 == 0 && CircleSpeed >= 20 && GuageSpeed <= 220) {
                        try {

                           Circle circle2 = (Circle) root.lookup("#circle" + CircleSpeed);
                           circle2.setOpacity(0);
                           CircleSpeed -= 20;

                        } catch (Exception e2) {
                           System.out.println(CircleSpeed);
                        }

                     }

                     if (GuageSpeed <= 0) {
                        timelineForline.stop();
                        CircleSpeed = 0;

                     }
                  }

                  //                  
                  //                  if(line.getStartX()==65)SpeedLineX=0.5; 
                  //                  line.setStartX(line.getStartX() + SpeedLineX);
                  //                  line.setStartY(line.getStartY() + 1);

               }));
               timelineForline.setCycleCount(Animation.INDEFINITE);
               timelineForline.play();
            }

         }
         currentKeyCode = null;
      });

      Timeline ScoreTime = new Timeline();
      ScoreTime.getKeyFrames().add(new KeyFrame(Duration.millis(10), event3 -> {
         if (Points < 10) Score.setText(String.valueOf("    " + Points));
         else if (Points < 100) Score.setText(String.valueOf("   " + Points));
         else if (Points < 1000) Score.setText(String.valueOf("  " + Points));

      }));
      ScoreTime.setCycleCount(Animation.INDEFINITE);
      ScoreTime.play();

      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
      root.requestFocus();
   }

   public void sendpos(CarObject car1, CarObject car2, CarObject car3, CarObject car4, ImageView snake) {

      car1.setPositonXY(snake);
      car2.setPositonXY(snake);
      car3.setPositonXY(snake);
      car4.setPositonXY(snake);

   }

   public void CarPolice() {
      CarChoice = "Police";
      System.out.print(CarChoice);

   }

   public void F1() {
      CarChoice = "F1";
   }

   public void GreenCar() {
      CarChoice = "#snake";
   }

}