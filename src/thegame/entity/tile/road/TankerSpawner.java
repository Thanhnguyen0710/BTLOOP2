package thegame.entity.tile.road;

import thegame.entity.Config;
import thegame.entity.enemy.TankerEnemy;

public class TankerSpawner  extends Spawner<TankerEnemy> {
    public TankerSpawner(long createdTick, int posX, int posY, int width, int height, long spawnInterval, long initialDelay, long numOfSpawn) {
        super(createdTick, posX, posY, width, height, Config.SMALLER_ENEMY_SIZE, TankerEnemy.class, spawnInterval, initialDelay, numOfSpawn);
    }
    @Override
    protected final TankerEnemy doSpawn(long createdTick, int posX, int posY) {
        return new TankerEnemy(createdTick, posX, posY);
    }
}
