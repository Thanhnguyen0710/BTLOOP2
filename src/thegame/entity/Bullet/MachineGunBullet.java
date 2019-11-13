package thegame.entity.Bullet;

import thegame.entity.Config;

public class MachineGunBullet extends AbstractBullet {
    public MachineGunBullet(int posX, int posY, int deltaX, int deltaY) {
        super(posX, posY, deltaX, deltaY, Config.MACHINE_GUN_BULLET_SPEED,Config.MACHINE_GUN_BULLET_STRENGTH);
    }
}
