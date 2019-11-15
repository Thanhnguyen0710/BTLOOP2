package thegame.entity.tile;

import thegame.entity.enemy.AbstractEnemy;

public abstract class Tile extends AbstractEnemy {
    protected Tile(long createdTick, int posX, int posY, int width, int height) {
        super(createdTick, posX, posY, width, height);
    }
}
