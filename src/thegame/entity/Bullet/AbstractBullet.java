package thegame.entity.Bullet;

public abstract class AbstractBullet implements GameEntity {
    private int posX;
    private int posY;
    private int deltaX;
    private int deltaY;
    private double speeed;
    private int strength;

    public double getSpeeed() {
        return speeed;
    }

    public int getStrength() {
        return strength;
    }

    public AbstractBullet(int posX, int posY, int deltaX, int deltaY, double speeed, int strength) {
        this.posX = posX;
        this.posY = posY;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.speeed = speeed;
        this.strength = strength;
    }

    @Override
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    @Override
    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }
}
