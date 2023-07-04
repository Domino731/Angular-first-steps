package engine.objects.entities;

public abstract class Entity {

    protected float x,y;
    public Entity(float x, float y) {
        this.x = x;
        this.y = y;

    }

    public static class Constants {
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int JUMP = 2;
        public static final int FALLING = 3;
        public static final int GROUND = 4;
        public static final int HIT = 5;
        public static final int ATTACK_1 = 6;
        public static final int ATTACK_JUMP_1 = 7;
        public static final int ATTACK_JUMP_2 = 8;
    }
}
