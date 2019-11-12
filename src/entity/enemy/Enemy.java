package entity.enemy;

import entity.GameEntity;

public interface Enemy extends GameEntity {
    int getShield();

    double getMoveSpeed();

    int getHealth();

    int getReward();

    boolean isEnemyDead();

}
