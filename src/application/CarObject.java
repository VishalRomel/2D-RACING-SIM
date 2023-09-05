/**
 * 
 */
package application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author PC-9000
 *
 */
public class CarObject extends Controller {

   public static Stage stage2;
   public double positionX;
   public double positionY;
   ImageView pos;
   static double x1 = 1;
   int CarsPast = 0;

   boolean x = true;

   public CarObject(ImageView car1) {

      if (car1.getLayoutY() == positionY) System.exit(0);

      Random random = new Random();
      int delay = random.nextInt(5000);
      Timeline timeline = new Timeline();

      timeline.getKeyFrames().add(new KeyFrame(Duration.millis(10), event -> {
         //	System.out.print(Controller.speed);
         if (pos != null) {
            Bounds boundsCar = pos.getBoundsInParent();
            Bounds boundsCar1 = car1.getBoundsInParent();

            if (boundsCar.intersects(boundsCar1)) {

               timeline.stop();
               try {
                  Thread.sleep(1000);
               } catch (InterruptedException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               }
               JOptionPane.showMessageDialog(null, "Your Score is: " + Controller.Points + ":  GOOD-BYE");
               System.exit(0);
               System.out.println("User clicked 'No' or closed the dialog");
            }
         }

         if (Controller.speed == 4) {
            x1 += 0.5;
            Controller.speed = 0;
         }
         car1.setLayoutY(car1.getLayoutY() + x1);
         //  System.out.println(x1);

         if (car1.getLayoutY() > 840) {

            car1.setLayoutY(-1 * (1000 + random.nextInt(800)));
            Controller.Points++;
            ColorAdjust color = new ColorAdjust();
            if (random.nextInt(2) == 1) color.setHue(-1 * (random.nextDouble(1)));
            else color.setHue((random.nextDouble(1)));

            car1.setEffect(color);

            Controller.speed++;

         }

      }));

      timeline.setCycleCount(Animation.INDEFINITE);
      timeline.setDelay(Duration.millis(random.nextInt(10000)));
      timeline.play();

   }

   public void setPositonXY(ImageView pos) {

      this.pos = pos;

   }

}