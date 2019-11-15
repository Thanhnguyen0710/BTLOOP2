package thegame.entity.enemy;

import thegame.entity.Config;

public class TankerEnemy extends AbstractEnemy{
    public TankerEnemy(long createdTick, int posX, int posY) {
        super(createdTick, posX, posY, Config.TANKER_ENEMY_SHIELD,Config.TANKER_ENEMY_HEALTH,Config.TANKER_ENEMY_REWARD,Config.TANKER_ENEMY_MOVESPEED,true);
    }
}
