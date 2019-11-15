package thegame.entity.enemy;

import thegame.GameField;
import thegame.entity.tile.road.Target;

public abstract class AbstractEnemy implements Enemy {
    private long createdTick;
    private  int shield;
    private  int health;
    private  int reward;
    private  double moveSpeed;
    private  boolean enemyDead;
    private int posX;
    private int posY;
    private int width;
    private int height;

    protected AbstractEnemy(long createdTick,int posX, int posY, int width, int height){
        this.createdTick = createdTick;
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }
    protected AbstractEnemy(long createdTick, int posX, int posY,int shield, int health, int reward, double moveSpeed, boolean enemyDead) {
        this.createdTick = createdTick;
        this.shield = shield;
        this.posX = posX;
        this.posY = posY;
        this.health = health;
        this.reward = reward;
        this.moveSpeed = moveSpeed;
        this.enemyDead = enemyDead;
    }

    public long getCreatedTick() {
        return createdTick;
    }

    @Override
    public int getShield() {
        return shield;
    }


    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getReward() {
        return reward;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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
        if(field.gameField[posX+1][posY] == 0){
            posX += 1;
        }
        else if(field.gameField[posX][posY+1] == 0){
            posY += 1;
        }
        else posY -= 1;
    }

    public final boolean isContaining(double posX, double posY, double width, double height) {
        return this.posX <= posX
                && this.posY <= posY
                && this.posX + this.width >= posX + width
                && this.posY + this.height >= posY + height;
    }


    public final boolean isBeingContained(double posX, double posY, double width, double height) {
        return posX <= this.posX
                && posY <= this.posY
                && posX + width >= this.posX + this.width
                && posY + height >= this.posY + this.height;
    }


    public final boolean isBeingOverlapped(double posX, double posY, double width, double height) {
        return posX < this.posX + this.width
                && posY < this.posY + this.height
                && posX + width > this.posX
                && posY + height > this.posY;
    }
}
