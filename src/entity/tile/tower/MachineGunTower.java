package entity.tile.tower;

import entity.Config;

public class MachineGunTower extends AbstractTower {
    public MachineGunTower(int posX, int posY) {
        super(posX, posY, Config.MACHINE_GUN_TOWER_RANGE,Config.MACHINE_GUN_TOWER_SPEED);
    }
}
