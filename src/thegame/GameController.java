package thegame;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class GameController extends AnimationTimer {
    private Stage primaryStage;

    private Image gameStart = new Image("/image/background/background.png");
    private ImageView gameStartView = new ImageView(gameStart);

    private Pane pane = new Pane();
    private Scene startGame = new Scene(pane,1200,700);

    private GameField field = new GameField();


    public GameController (Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    private GameRender render = new GameRender(field,pane);

    @Override
    public void handle(long l) {

    }

    public void start(){
        pane.getChildren().add(gameStartView);
        primaryStage.setScene(startGame);
        render.render();
        super.start();
    }
}
