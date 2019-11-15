package thegame.entity.tile.road;

import thegame.GameField;
import thegame.entity.enemy.AbstractEnemy;
import thegame.entity.tile.Road;
import thegame.entity.tile.Tile;

public abstract class Spawner <E extends AbstractEnemy> extends Tile {
    private final int posX = 0;
    private final int posY = 7;
    private  long spawnInterval;
    private long tickDown;
    private long numOfSpawn;
    private Class<E> spawningClass;
    private double spawningSize;

    protected Spawner(long createdTick, int posX, int posY, int width, int height, double spawningSize, Class<E> spawningClass, long spawnInterval, long initialDelay, long numOfSpawn) {
        super(createdTick, posX, posY, width, height);
        this.spawningSize = spawningSize;
        this.spawningClass = spawningClass;
        this.spawnInterval = spawnInterval;
        this.tickDown = initialDelay;
        this.numOfSpawn = numOfSpawn;
    }
    public  int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
    public final void onUpdate(GameField field) {
        this.tickDown -= 1;
        if (tickDown <= 0 && numOfSpawn > 0) {
            // TODO: get a random spot inside spawn range
            // Check if the spot is valid and then spawn an enemy
            // Remember to set this.tickDown back to this.spawnInterval
            // and decrease this.numOfSpawn once you spawn an enemy.
            field.doSpawn(doSpawn(getCreatedTick(),getPosX(),getPosY()));
            this.tickDown = spawnInterval;
            this.numOfSpawn -= 1;
        }
    }
    protected abstract E doSpawn(long createdTick,int posX, int posY);

}
