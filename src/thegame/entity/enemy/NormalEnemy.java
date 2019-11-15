package thegame.entity.enemy;

import thegame.entity.Config;
import thegame.entity.enemy.AbstractEnemy;


public class NormalEnemy extends AbstractEnemy {
    public NormalEnemy(long createdTick, int posX, int posY) {
        super(createdTick, posX, posY, Config.NORMAL_ENEMY_SHIELD, Config.NORMAL_ENEMY_HEALTH, Config.NORMAL_ENEMY_REWARD, Config.NORMAL_ENEMY_MOVESPEED, true);
    }
}
