package entity.tile.tower;

import entity.Config;

public class NormalTower extends AbstractTower {
    public NormalTower(int posX, int posY) {
        super(posX, posY, Config.NORMAL_TOWER_RANGE,Config.NORMAL_TOWER_SPEED);
    }
}
