package thegame.entity.tile.road;

import thegame.entity.Config;

import thegame.entity.enemy.NormalEnemy;

public class NormalSpawner extends Spawner<NormalEnemy> {
     public NormalSpawner(long createdTick, int posX, int posY, int width, int height, long spawnInterval, long initialDelay, long numOfSpawn) {
         super(createdTick, posX, posY, width, height, Config.NORMAL_ENEMY_SIZE, NormalEnemy.class, spawnInterval, initialDelay, numOfSpawn);
     }
    @Override
    protected final NormalEnemy doSpawn(long createdTick, int posX, int posY) {
        return new NormalEnemy(createdTick, posX, posY);
    }
}
