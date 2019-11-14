package thegame;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontSmoothingType;
import javafx.stage.Stage;
import thegame.entity.Config;
import thegame.entity.GameEntity;
import thegame.entity.enemy.AbstractEnemy;
import thegame.entity.tile.tower.MachineGunTower;
import thegame.entity.tile.tower.NormalTower;
import thegame.entity.tile.tower.SniperTower;
import javafx.scene.control.Button;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import static thegame.entity.Config.GAME_NAME;

public class GameField {
    public static int[][] gameField = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    private int coin = 100;
    private List<GameEntity> spawnEntity = new ArrayList<GameEntity>();

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public void doSpawnNormalTower(int posX,int posY){
        spawnEntity.add(new NormalTower(posX,posY));
    }

    public void doSpawnSniperTower(int posX,int posY){
        spawnEntity.add(new SniperTower(posX,posY));
    }

    public void doSpawnMachineGunTower(int posX,int posY){
        spawnEntity.add(new MachineGunTower(posX,posY));
    }

    public void doDestroy(){
        for(int i = 0 ; i < spawnEntity.size() ; i++){
            if(spawnEntity.get(i) instanceof AbstractEnemy){
                if (((AbstractEnemy) spawnEntity.get(i)).onDestroy()){
                    coin += ((AbstractEnemy) spawnEntity.get(i)).getReward();
                    spawnEntity.remove(i);
                    i--;
                }
            }
        }
    }
    public static void start(Stage primaryStage) throws Exception{
        Image image = new Image(this.getClass().getResourceAsStream("/image/background/start.jpg"));
        ImageView imageView = new ImageView();
        imageView.setImage(image);

        Button button1 = new Button("Start");
        Button button2 = new Button("Quit");

        VBox vbox = new VBox(button1, button2);

        Scene scene = new Scene(vbox,Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.setTitle(GAME_NAME);
        primaryStage.show();
    }


}
