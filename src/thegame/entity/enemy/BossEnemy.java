package thegame.entity.enemy;

import thegame.entity.Config;

public class BossEnemy extends AbstractEnemy{
    public BossEnemy(long createdTick,int posX, int posY) {
        super(createdTick,posX, posY, Config.BOSS_ENEMY_SHIELD,Config.BOSS_ENEMY_HEALTH,Config.BOSS_ENEMY_REWARD,Config.BOSS_ENEMY_MOVESPEED,true);
    }
}
