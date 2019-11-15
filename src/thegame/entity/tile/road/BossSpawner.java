package thegame.entity.tile.road;

import thegame.entity.Config;
import thegame.entity.enemy.BossEnemy;

public class BossSpawner extends Spawner<BossEnemy> {
    public BossSpawner(long createdTick, int posX, int posY, int width, int height, long spawnInterval, long initialDelay, long numOfSpawn) {
        super(createdTick, posX, posY, width, height, Config.SMALLER_ENEMY_SIZE, BossEnemy.class, spawnInterval, initialDelay, numOfSpawn);
    }
    @Override
    protected final BossEnemy doSpawn(long createdTick, int posX, int posY) {
        return new BossEnemy(createdTick, posX, posY);
    }
}
