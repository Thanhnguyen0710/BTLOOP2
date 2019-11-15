package thegame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import thegame.entity.enemy.BossEnemy;
import thegame.entity.enemy.NormalEnemy;
import thegame.entity.enemy.SmallerEnemy;
import thegame.entity.enemy.TankerEnemy;
import thegame.entity.tile.tower.MachineGunTower;
import thegame.entity.tile.tower.NormalTower;
import thegame.entity.tile.tower.SniperTower;

import java.util.ArrayList;
import java.util.List;

public class GameRender {
    private GameField field;
    private Pane pane;

    public GameRender(GameField field,Pane pane){
        this.pane = pane;
        this.field = field;
    }

    private final String normal_enemy = "/image/enemy/enemy.jpg";

    private final String smaller_enemy = "/image/enemy/smaller_enemy.jpg";

    private final String tanker_enemy = "/image/enemy/tanker_enemy.jpg";

    private final String boss_enemy = "/image/enemy/boss_enemy.jpg";

    private final String normal_tower = "/image/tower/normal_tower.jpg";

    private final String sniper_tower = "/image/tower/sniper_tower.jpg";

    private final String machinegun_tower = "/image/tower/machinegun_tower.jpg";

    private List<Image> imageList = new ArrayList<Image>();

    private List<ImageView> imageViewList = new ArrayList<ImageView>();

    public List<ImageView> getImageViewList() {
        return imageViewList;
    }

    public void renderNormalEnemy(NormalEnemy normalEnemy){
        Image image = new Image(normal_enemy);
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(normalEnemy.getPosX());
        imageView.setLayoutY(normalEnemy.getPosY());
        imageViewList.add(imageView);
    }

    public void renderSmallerEnemy(SmallerEnemy smallerEnemy){
        Image image = new Image(smaller_enemy);
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(smallerEnemy.getPosX());
        imageView.setLayoutY(smallerEnemy.getPosY());
        imageViewList.add(imageView);
    }

    public void renderTankerEnemy(TankerEnemy tankerEnemy){
        Image image = new Image(tanker_enemy);
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(tankerEnemy.getPosX());
        imageView.setLayoutY(tankerEnemy.getPosY());
        imageViewList.add(imageView);
    }

    public void renderBossEnemy(BossEnemy bossEnemy){
        Image image = new Image(boss_enemy);
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(bossEnemy.getPosX());
        imageView.setLayoutY(bossEnemy.getPosY());
        imageViewList.add(imageView);
    }

    public void renderNormalTower(NormalTower normalTower){
        Image image = new Image(normal_tower);
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(normalTower.getPosX());
        imageView.setLayoutY(normalTower.getPosY());
        imageViewList.add(imageView);
    }

    public void renderSniperTower(SniperTower sniperTower){
        Image image = new Image(sniper_tower);
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(sniperTower.getPosX());
        imageView.setLayoutY(sniperTower.getPosY());
        imageViewList.add(imageView);
    }

    public void renderMachineGunTower(MachineGunTower machineGunTower){
        Image image = new Image(machinegun_tower);
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(machineGunTower.getPosX());
        imageView.setLayoutY(machineGunTower.getPosY());
        imageViewList.add(imageView);
    }

    public void render(){
        for(int i = imageViewList.size() ; i < field.getEntities().size(); i++) {
            if (field.getEntities().get(i) instanceof NormalEnemy)
                renderNormalEnemy((NormalEnemy)field.getEntities().get(i));

            if (field.getEntities().get(i) instanceof SmallerEnemy)
                renderSmallerEnemy((SmallerEnemy)field.getEntities().get(i));

            if (field.getEntities().get(i) instanceof TankerEnemy)
                renderTankerEnemy((TankerEnemy) field.getEntities().get(i));

            if (field.getEntities().get(i) instanceof BossEnemy)
                renderBossEnemy((BossEnemy)field.getEntities().get(i));

            if (field.getEntities().get(i) instanceof NormalTower)
                renderNormalTower((NormalTower) field.getEntities().get(i));

            if (field.getEntities().get(i) instanceof SniperTower)
                renderSniperTower((SniperTower) field.getEntities().get(i));

            if (field.getEntities().get(i) instanceof MachineGunTower)
                renderMachineGunTower((MachineGunTower) field.getEntities().get(i));
        }
        pane.getChildren().addAll(imageViewList);
    }
}
