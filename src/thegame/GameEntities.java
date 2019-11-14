package thegame;

import thegame.entity.EffectEntity;
import thegame.entity.GameEntity;
import thegame.entity.LivingEntity;
import thegame.entity.bullet.NormalBullet;
import thegame.entity.enemy.NormalEnemy;
import thegame.entity.tile.Mountain;
import thegame.entity.tile.Target;
import thegame.utilities.Pair;
import thegame.utilities.UnorderedPair;
import thegame.entity.Config;

import javax.annotation.Nonnull;
import java.util.*;

public final class GameEntities {
    private static final Set<UnorderedPair<Class<? extends GameEntity>, Class<? extends GameEntity>>> COLLISION_PAIR_SET
            = new HashSet<>(Set.of(
            UnorderedPair.immutableOf(Mountain.class, NormalEnemy.class),
//			UnorderedPair.immutableOf(Mountain.class, SmallerEnemy.class),
//			UnorderedPair.immutableOf(Mountain.class, TankerEnemy.class),
//			UnorderedPair.immutableOf(Mountain.class, BossEnemy.class),
            UnorderedPair.immutableOf(NormalEnemy.class, NormalEnemy.class)//,
//			UnorderedPair.immutableOf(SmallerEnemy.class, SmallerEnemy.class),
//			UnorderedPair.immutableOf(TankerEnemy.class, TankerEnemy.class),
//			UnorderedPair.immutableOf(BossEnemy.class, BossEnemy.class)
    ));

    private static final Set<Pair<Class<? extends EffectEntity>, Class<? extends LivingEntity>>> EFFECT_LIVING_SET
            = new HashSet<>(Set.of(
            Pair.immutableOf(NormalBullet.class, NormalEnemy.class),
//			Pair.immutableOf(MachineGunBullet.class, NormalEnemy.class),
//			Pair.immutableOf(SniperBullet.class, NormalEnemy.class),
//			Pair.immutableOf(NormalBullet.class, SmallerEnemy.class),
//			Pair.immutableOf(MachineGunBullet.class, SmallerEnemy.class),
//			Pair.immutableOf(SniperBullet.class, SmallerEnemy.class),
//			Pair.immutableOf(NormalBullet.class, TankerEnemy.class),
//			Pair.immutableOf(MachineGunBullet.class, TankerEnemy.class),
//			Pair.immutableOf(SniperBullet.class, TankerEnemy.class),
//			Pair.immutableOf(NormalBullet.class, BossEnemy.class),
//			Pair.immutableOf(MachineGunBullet.class, BossEnemy.class),
//			Pair.immutableOf(SniperBullet.class, BossEnemy.class),
            Pair.immutableOf(NormalEnemy.class, Target.class)//,
//			Pair.immutableOf(SmallerEnemy.class, Target.class),
//			Pair.immutableOf(TankerEnemy.class, Target.class),
//			Pair.immutableOf(BossEnemy.class, Target.class)
    ));

    private GameEntities() {
    }


    public static Collection<GameEntity> getContainingEntities(Collection<GameEntity> entities,
                                                               double posX, double posY, double width, double height) {
        final List<GameEntity> outputEntities = new ArrayList<>(Config._TILE_MAP_COUNT);
        for (final GameEntity entity : entities) {
            if (entity.isContaining(posX, posY, width, height)) outputEntities.add(entity);
        }
        return outputEntities;
    }


    public static Collection<GameEntity> getContainedEntities(Collection<GameEntity> entities,
                                                              double posX, double posY, double width, double height) {
        final List<GameEntity> outputEntities = new ArrayList<>(Config._TILE_MAP_COUNT);
        for (final GameEntity entity : entities) {
            if (entity.isBeingContained(posX, posY, width, height)) outputEntities.add(entity);
        }
        return outputEntities;
    }


    public static Collection<GameEntity> getOverlappedEntities(Collection<GameEntity> entities,
                                                               double posX, double posY, double width, double height) {
        final List<GameEntity> outputEntities = new ArrayList<>(Config._TILE_MAP_COUNT);
        for (final GameEntity entity : entities) {
            if (entity.isBeingOverlapped(posX, posY, width, height)) outputEntities.add(entity);
        }
        return outputEntities;
    }


    public static <E extends GameEntity> Collection<E> getFilteredContainingEntities(Collection<GameEntity> entities,
                                                                                     Class<E> entityClass, double posX, double posY, double width, double height) {
        final List<E> outputEntities = new ArrayList<>(Config._TILE_MAP_COUNT);
        for (final GameEntity entity : entities) {
            if (entityClass.isInstance(entity) && entity.isContaining(posX, posY, width, height)) {
                outputEntities.add(entityClass.cast(entity));
            }
        }
        return outputEntities;
    }


    public static <E extends GameEntity> Collection<E> getFilteredContainedEntities(Collection<GameEntity> entities,
                                                                                    Class<E> entityClass, double posX, double posY, double width, double height) {
        final List<E> outputEntities = new ArrayList<>(Config._TILE_MAP_COUNT);
        for (final GameEntity entity : entities) {
            if (entityClass.isInstance(entity) && entity.isBeingContained(posX, posY, width, height)) {
                outputEntities.add(entityClass.cast(entity));
            }
        }
        return outputEntities;
    }

    public static <E extends GameEntity> Collection<E> getFilteredOverlappedEntities(Collection<GameEntity> entities,
                                                                                     Class<E> entityClass, double posX, double posY, double width, double height) {
        final List<E> outputEntities = new ArrayList<>(Config._TILE_MAP_COUNT);
        for (final GameEntity entity : entities) {
            if (entityClass.isInstance(entity) && entity.isBeingOverlapped(posX, posY, width, height)) {
                outputEntities.add(entityClass.cast(entity));
            }
        }
        return outputEntities;
    }


    public static boolean isCollidable(@Nonnull Class<? extends GameEntity> entityClassA, @Nonnull Class<? extends GameEntity> entityClassB) {
        return COLLISION_PAIR_SET.contains(UnorderedPair.immutableOf(entityClassA, entityClassB));
    }


    public static Collection<GameEntity> getCollidedEntities(Collection<GameEntity> entities,
                                                             Class<? extends GameEntity> entityClass, double posX, double posY, double width, double height) {
        final List<GameEntity> outputEntities = new ArrayList<>(Config._TILE_MAP_COUNT);
        for (final GameEntity entity : entities) {
            if (entity.isBeingOverlapped(posX, posY, width, height) && isCollidable(entityClass, entity.getClass())) {
                outputEntities.add(entity);
            }
        }
        return outputEntities;
    }


    public static boolean isAffectable(@Nonnull Class<? extends EffectEntity> effectClass, @Nonnull Class<? extends LivingEntity> livingClass) {
        return EFFECT_LIVING_SET.contains(Pair.immutableOf(effectClass, livingClass));
    }




    public static <E extends GameEntity, V extends E> Collection<V> entitiesFilter(Collection<E> entities, Class<V> entityClass) {
        final List<V> outputEntities = new ArrayList<>(Config._TILE_MAP_COUNT);
        for (final E entity : entities)
            if (entityClass.isInstance(entity)) outputEntities.add(entityClass.cast(entity));
        return outputEntities;
    }
}
