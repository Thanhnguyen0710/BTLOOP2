package thegame;

import entity.tile.GameTile;
import thegame.entity.Config;
import thegame.entity.enemy.AbstractEnemy;
import thegame.entity.tile.GameEntity;
import thegame.entity.tile.tower.AbstractTower;
import thegame.entity.tile.tower.MachineGunTower;
import thegame.entity.tile.tower.NormalTower;
import thegame.entity.tile.tower.SniperTower;

import java.util.ArrayList;
import java.util.List;

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
    private final List<AbstractEnemy> spawnEntities = new ArrayList<>(Config._TILE_MAP_COUNT);
    private int coin = 100;
    private int health = 20;

    private List<GameEntity> entities = new ArrayList<GameEntity>();

    public List<GameEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<GameEntity> entities) {
        this.entities = entities;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public void doSpawnNormalTower(int posX,int posY){
        if (entities instanceof AbstractTower)
        entities.add(new NormalTower(posX,posY));
    }

    public void doSpawnSniperTower(int posX,int posY){
        entities.add(new SniperTower(posX,posY));
    }

    public void doSpawnMachineGunTower(int posX,int posY){
        entities.add(new MachineGunTower(posX,posY));
    }

    public void doDestroy(){
        for(int i = 0 ; i < entities.size() ; i++){
            if(entities.get(i) instanceof AbstractEnemy){
                if (((AbstractEnemy) entities.get(i)).onDestroy(this)){
                    coin += ((AbstractEnemy) entities.get(i)).getReward();
                    entities.remove(i);
                    i--;
                }
            }
        }
    }
    public final void doSpawn(AbstractEnemy entity) {
        if (entity.isBeingOverlapped(0.0,0.0,21,12))
            spawnEntities.add(entity);
    }

    public boolean gameOver(){
        if (health <= 0) {
            for (int i = 0 ; i < entities.size() ; i++)
                entities.remove(0);
            return true;
        }
        return false;
    }

}
