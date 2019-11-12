import entity.GameEntity;
import entity.enemy.AbstractEnemy;
import entity.tile.tower.MachineGunTower;
import entity.tile.tower.NormalTower;
import entity.tile.tower.SniperTower;

import java.util.ArrayList;
import java.util.List;

public class GameField {
    public static int[][] gameFeild = {
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
                    spawnEntity.remove(i);
                    i--;
                }

            }
        }
    }

}
