package thegame.entity.enemy;

import thegame.GameField;
import thegame.entity.tile.road.Target;

public abstract class AbstractEnemy implements Enemy {
    private int shield;
    private int posX;
    private int posY;
    private int health;
    private int reward;
    private double moveSpeed;
    private boolean enemyDead;

    public AbstractEnemy(int posX, int posY,int shield, int health, int reward, double moveSpeed, boolean enemyDead) {
        this.shield = shield;
        this.posX = posX;
        this.posY = posY;
        this.health = health;
        this.reward = reward;
        this.moveSpeed = moveSpeed;
        this.enemyDead = enemyDead;
    }

    @Override
    public int getShield() {
        return shield;
    }

    @Override
    public int getPosX() {
        return posX;
    }

    @Override
    public int getPosY() {
        return posY;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getReward() {
        return reward;
    }

    @Override
    public double getMoveSpeed() {
        return moveSpeed;
    }

    @Override
    public boolean isEnemyDead() {
        return enemyDead;
    }

    @Override
    public boolean onDestroy(GameField field) {
        Target target = new Target();
        if(health <= 0 ) return true;
        else if (posX == target.getPosX() && posY == target.getPosY()) {
            field.setHealth(field.getHealth()-1);
            return true;
        }
        else return false;
    }

    public void move(GameField field){
        if(field.gameFeild[posX+1][posY] == 0){
            posX += 1;
        }
        else if(field.gameFeild[posX][posY+1] == 0){
            posY += 1;
        }
        else posY -= 1;
    }
}
