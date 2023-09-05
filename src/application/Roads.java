package application;

import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Roads {

   public Roads(ImageView road) {

      Random random = new Random();
      int delay = random.nextInt(5000);

      Timeline timeline = new Timeline(new KeyFrame(Duration.millis(5), event -> {

         road.setLayoutY(road.getLayoutY() + 1);
         if (road.getLayoutY() == 790) road.setLayoutY(-165);

      }));

      timeline.setCycleCount(Animation.INDEFINITE);
      timeline.play();

   }

}