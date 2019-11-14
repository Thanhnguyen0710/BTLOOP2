package thegame.entity;

public final class Config {
    public static final String GAME_NAME = "Tower Defense";
    public static final long GAME_TPS = 20;
    /**
     * Nanoseconds per tick
     */
    public static final long GAME_NSPT = Math.round(1000000000.0 / GAME_TPS);

    /**
     * Size of the tile, in pixel.
     * 1.0 field unit == TILE_SIZE pixel on the screen.
     * Change it base on your texture size.
     */
    public static final long TILE_SIZE = 32;
    /**
     * Num of tiles the screen can display if fieldZoom is TILE_SIZE,
     * in other words, the texture will be display as it without scaling.
     */
    public static final long TILE_HORIZONTAL = 30;
    /**
     * Num of tiles the screen can display if fieldZoom is TILE_SIZE,
     * in other words, the texture will be display as it without scaling.
     */
    public static final long TILE_VERTICAL = 20;
    /**
     * An arbitrary number just to make some code run a little faster.
     * Do not touch.
     */
    public static final int _TILE_MAP_COUNT = (int) (TILE_HORIZONTAL * TILE_VERTICAL);


    /**
     * Size of the screen.
     */
    public static final long SCREEN_WIDTH = TILE_SIZE * TILE_HORIZONTAL;
    /**
     * Size of the screen.
     */
    public static final long SCREEN_HEIGHT = TILE_SIZE * TILE_VERTICAL;

    //Enemy
    public static final int NORMAL_ENEMY_SHIELD = 3;
    public static final int NORMAL_ENEMY_REWARD = 20;
    public static final double NORMAL_ENEMY_MOVESPEED = 0.3;
    public static final int NORMAL_ENEMY_HEALTH = 100;

    public static final int SMALLER_ENEMY_SHIELD = 0;
    public static final int SMALLER_ENEMY_REWARD = 10;
    public static final double SMALLER_ENEMY_MOVESPEED = 0.4;
    public static final int SMALLER_ENEMY_HEALTH = 50;

    public static final int TANKER_ENEMY_SHIELD = 5;
    public static final int TANKER_ENEMY_REWARD = 30;
    public static final double TANKER_ENEMY_MOVESPEED = 0.2;
    public static final int TANKER_ENEMY_HEALTH = 300;

    public static final int BOSS_ENEMY_SHIELD = 8;
    public static final int BOSS_ENEMY_REWARD = 100;
    public static final double BOSS_ENEMY_MOVESPEED = 0.3;
    public static final int BOSS_ENEMY_HEALTH = 500;

    //Tower
    public static final int NORMAL_TOWER_SPEED = 30;
    public static final double NORMAL_TOWER_RANGE = 5.0;

    public static final int MACHINE_GUN_TOWER_SPEED = 5;
    public static final double MACHINE_GUN_TOWER_RANGE = 4.0;

    public static final int SNIPER_TOWER_SPEED = 60;
    public static final double SNIPER_TOWER_RANGE = 6.0;

    //BUllet
    public static final int NORMAL_BULLET_TTL = 30;
    public static final int NORMAL_BULLET_STRENGTH = 30;
    public static final double NORMAL_BULLET_SPEED = 0.3;

    public static final int MACHINE_GUN_BULLET_TTL = 15;
    public static final int MACHINE_GUN_BULLET_STRENGTH = 20;
    public static final double MACHINE_GUN_BULLET_SPEED = 0.4;

    public static final int SNIPER_BULLET_TTL = 60;
    public static final int SNIPER_BULLET_STRENGTH = 120;
    public static final double SNIPER_BULLET_SPEED = 0.5;
}
