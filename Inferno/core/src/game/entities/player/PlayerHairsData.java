package game.entities.player;

import utils.vectors.Vector;

import java.util.HashMap;

public class PlayerHairsData {
    private HashMap<String, Config> hairs = createHairs();

    private static HashMap<String, Config> createHairs() {
        HashMap<String, Config> hairs = new HashMap<>();

        hairs.put("TEST_1", new Config("TEST_1", (byte) 0, (byte) 0));
        hairs.put("TEST_2", new Config("TEST_2", (byte) 1, (byte) 0));
        hairs.put("TEST_3", new Config("TEST_3", (byte) 2, (byte) 0));
        hairs.put("TEST_4", new Config("TEST_4", (byte) 3, (byte) 0));
        hairs.put("TEST_5", new Config("TEST_5", (byte) 4, (byte) 0));
        hairs.put("TEST_6", new Config("TEST_6", (byte) 5, (byte) 0));
        hairs.put("TEST_7", new Config("TEST_7", (byte) 6, (byte) 0));
        hairs.put("TEST_8", new Config("TEST_8", (byte) 7, (byte) 0));

        return hairs;
    }


    public static class Config {
        private Vector<Byte> offset;
        private String name;

        public Config(String name, byte xOffset, byte yOffset) {
            this.name = name;
            offset = new Vector<>(xOffset, yOffset);
        }
    }
}
