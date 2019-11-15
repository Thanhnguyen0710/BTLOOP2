package thegame.entity.enemy;

import thegame.GameField;

public interface Enemy extends GameEntity {
    int getShield();

    double getMoveSpeed();

    int getHealth();

    int getReward();

    boolean isEnemyDead();

    boolean onDestroy(GameField field);

}
