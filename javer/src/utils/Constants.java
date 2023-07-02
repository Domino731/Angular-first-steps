package javer.src.utils;

public class Constants {
    public static class Directions {
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }


    public static class Player {
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int JUMP = 2;
        public static final int FALLING = 3;
        public static final int ATTACK = 4;

        public static int GetPlayerSpriteAmount(int playerAction){
            switch (playerAction){
                case RUNNING:
                    return 6;
                case IDLE:
                    return 5;
                case JUMP:
                    return 3;
                case FALLING:
                    return 1;
                case ATTACK:
                    return 3;
                default:
                    return 1;
            }
        }
    }
}
