package thegame.entity.enemy;

import thegame.entity.GameEntity;

public interface Enemy extends GameEntity {
    int getShield();

    double getMoveSpeed();

    int getHealth();

    int getReward();

    boolean isEnemyDead();

    boolean onDestroy();

}
