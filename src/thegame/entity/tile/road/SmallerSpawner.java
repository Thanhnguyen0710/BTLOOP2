package thegame.entity.tile.road;

import thegame.entity.Config;
import thegame.entity.enemy.SmallerEnemy;

public class SmallerSpawner extends Spawner<SmallerEnemy> {
    public SmallerSpawner(long createdTick, int posX, int posY, int width, int height, long spawnInterval, long initialDelay, long numOfSpawn) {
        super(createdTick, posX, posY, width, height, Config.SMALLER_ENEMY_SIZE, SmallerEnemy.class, spawnInterval, initialDelay, numOfSpawn);
    }
    @Override
    protected final SmallerEnemy doSpawn(long createdTick, int posX, int posY) {
        return new SmallerEnemy(createdTick, posX, posY);
    }
}
