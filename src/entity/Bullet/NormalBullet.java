package entity.Bullet;

import entity.Config;

public class NormalBullet extends AbstractBullet {
    public NormalBullet(int posX, int posY, int deltaX, int deltaY) {
        super(posX, posY, deltaX, deltaY, Config.NORMAL_BULLET_SPEED,Config.NORMAL_BULLET_STRENGTH);
    }
}
