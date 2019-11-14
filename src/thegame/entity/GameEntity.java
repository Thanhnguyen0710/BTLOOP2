package thegame.entity;

public interface GameEntity {

    long getCreatedTick();

    double getPosX();

    double getPosY();

    double getWidth();

    double getHeight();

    boolean isContaining(double posX, double posY, double width, double height);

    boolean isBeingContained(double posX, double posY, double width, double height);

    boolean isBeingOverlapped(double posX, double posY, double width, double height);
}
