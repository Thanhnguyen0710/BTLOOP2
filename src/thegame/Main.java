package thegame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Pane root = new Pane();
        Pane pane = new Pane();
        Scene startGame = new Scene(root,1050,700);
        Scene phaygame = new Scene(pane,1050,700);

        Image gamePlay = new Image("/image/background/background.png");
        ImageView gamePlayView = new ImageView(gamePlay);
        gamePlayView.setFitWidth(1050);
        gamePlayView.setFitHeight(700);
        pane.getChildren().add(gamePlayView);

        Image gameStart = new Image("/image/background/start.jpg");
        ImageView gameStartView = new ImageView(gameStart);
        root.getChildren().addAll(gameStartView);
        gameStartView.setFitHeight(700);
        gameStartView.setFitWidth(1050);

        startGame.setOnMouseClicked(mouseEvent -> {
            if((mouseEvent.getX() > 370 && mouseEvent.getX() < 681) &&
            (mouseEvent.getY() > 387 && mouseEvent.getY() < 570) )
                primaryStage.setScene(phaygame);
            startGame.setOnMouseClicked(null);
        });

        primaryStage.setScene(startGame);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
