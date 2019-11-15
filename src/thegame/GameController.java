package thegame;

import javafx.animation.AnimationTimer;
import javafx.stage.Stage;


public class GameController extends AnimationTimer {
    private Stage primaryStage;

    private GameField field;

    public GameController (Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    @Override
    public void handle(long l) {
        System.out.println("yes");
    }

}
