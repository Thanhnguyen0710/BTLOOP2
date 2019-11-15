package thegame.entity.enemy;

import thegame.entity.Config;

public class SmallerEnemy extends AbstractEnemy{
    public SmallerEnemy(long createdTick, int posX, int posY) {
        super(createdTick, posX, posY, Config.SMALLER_ENEMY_SHIELD,Config.SMALLER_ENEMY_HEALTH,Config.SMALLER_ENEMY_REWARD,Config.SMALLER_ENEMY_MOVESPEED,true);
    }
}
