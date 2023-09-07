package game.entities.player.style.data;

import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.HashMap;

public class PlayerHairsData {
    private static HashMap<String, Config> hairs = createHairs();
    public static final DimensionVector<Byte> HAIR_SIZE = new DimensionVector<>((byte) 16, (byte) 32);

    public static HashMap<String, Config> createHairs() {
        HashMap<String, Config> hairs = new HashMap<>();

        hairs.put("1", new Config("TEST_1", (byte) 0, (byte) 0));
        hairs.put("2", new Config("TEST_2", (byte) 1, (byte) 0));
        hairs.put("3", new Config("TEST_3", (byte) 2, (byte) 0));
        hairs.put("4", new Config("TEST_4", (byte) 3, (byte) 0));
        hairs.put("5", new Config("TEST_5", (byte) 4, (byte) 0));
        hairs.put("6", new Config("TEST_6", (byte) 5, (byte) 0));
        hairs.put("7", new Config("TEST_7", (byte) 6, (byte) 0));
        hairs.put("8", new Config("TEST_8", (byte) 7, (byte) 0));

        return hairs;
    }


    public static class Config {
        private Vector<Byte> offset;
        private String name;

        public Config(String name, byte xOffset, byte yOffset) {
            this.name = name;
            offset = new Vector<>(xOffset, yOffset);
        }

        public Vector<Byte> getOffset() {
            return offset;
        }

        ;
    }

    public static Config getHairData(String hairId) {
        return hairs.get(hairId);
    }
}
