package thegame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("test");
        Image background = new Image(this.getClass().getResourceAsStream("/image/background/background.png"));
        ImageView backgroundView = new ImageView();
        backgroundView.setImage(background);
        backgroundView.setFitHeight(700);
        backgroundView.setFitWidth(1050);

        Image bossenemy = new Image("/image/enemy/boss_enemy.jpg");
        ImageView bossenemyView = new ImageView(bossenemy);
        bossenemyView.setFitWidth(50);
        bossenemyView.setFitHeight(50);
        StackPane root = new StackPane();
        backgroundView.setLayoutX(0);
        backgroundView.setLayoutY(0);
        bossenemyView.setLayoutX(0);
        bossenemyView.setLayoutY(350);
        root.getChildren().addAll(backgroundView,bossenemyView);
        Scene scene = new Scene(root,1050,700);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
