package entity.tile.tower;

import entity.tile.Tower;

public abstract class AbstractTower implements Tower {
    private int posX;
    private int posY;
    private double range;
    private int speed;

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public AbstractTower(int posX, int posY, double range, int speed) {
        this.posX = posX;
        this.posY = posY;
        this.range = range;
        this.speed = speed;
    }

    @Override
    public int getPosX() {
        return 0;
    }

    @Override
    public int getPosY() {
        return 0;
    }
}
