package game.entities.player.style.data;

import game.entities.player.HatsNames;
import utils.vectors.Vector;

import java.util.HashMap;

public class PlayerHatsData {
    private static HashMap<HatsNames, Config> hats = createHats();
    public static final byte HAT_SIZE = 20;

    public static Config getHat(HatsNames id) {
        return hats.get(id);
    }

    public static class Config {
        private String name;
        private Vector<Byte> offset;

        public Config(String name, byte xOffset, byte yOffset) {
            this.name = name;
            offset = new Vector<>(xOffset, yOffset);
        }

        public Vector<Byte> getOffset() {
            return offset;
        }

        public String getName() {
            return name;
        }
    }

    private static HashMap<HatsNames, Config> createHats() {
        HashMap<HatsNames, Config> payload = new HashMap<>();

        // 0 y offset
        payload.put(HatsNames.TEST_1, new Config("HAT_1", (byte) 0, (byte) 0));
        payload.put(HatsNames.TEST_2, new Config("HAT_2", (byte) 1, (byte) 0));
        payload.put(HatsNames.TEST_3, new Config("HAT_3", (byte) 2, (byte) 0));
        payload.put(HatsNames.TEST_4, new Config("HAT_4", (byte) 3, (byte) 0));
        payload.put(HatsNames.TEST_5, new Config("HAT_5", (byte) 4, (byte) 0));
        payload.put(HatsNames.TEST_6, new Config("HAT_6", (byte) 5, (byte) 0));
        payload.put(HatsNames.TEST_7, new Config("HAT_7", (byte) 6, (byte) 0));
        payload.put(HatsNames.TEST_8, new Config("HAT_8", (byte) 7, (byte) 0));
        payload.put(HatsNames.TEST_9, new Config("HAT_9", (byte) 8, (byte) 0));
        payload.put(HatsNames.TEST_10, new Config("HAT_10", (byte) 9, (byte) 0));
        payload.put(HatsNames.TEST_11, new Config("HAT_11", (byte) 10, (byte) 0));
        payload.put(HatsNames.TEST_12, new Config("HAT_12", (byte) 11, (byte) 0));

        // 1 y offset
        payload.put(HatsNames.TEST_13, new Config("HAT_13", (byte) 0, (byte) 1));
        payload.put(HatsNames.TEST_14, new Config("HAT_14", (byte) 1, (byte) 1));
        payload.put(HatsNames.TEST_15, new Config("HAT_15", (byte) 2, (byte) 1));
        payload.put(HatsNames.TEST_16, new Config("HAT_16", (byte) 3, (byte) 1));
        payload.put(HatsNames.TEST_17, new Config("HAT_17", (byte) 4, (byte) 1));
        payload.put(HatsNames.TEST_18, new Config("HAT_18", (byte) 5, (byte) 1));
        payload.put(HatsNames.TEST_19, new Config("HAT_19", (byte) 6, (byte) 1));
        payload.put(HatsNames.TEST_20, new Config("HAT_20", (byte) 7, (byte) 1));
        payload.put(HatsNames.TEST_21, new Config("HAT_21", (byte) 8, (byte) 1));
        payload.put(HatsNames.TEST_22, new Config("HAT_22", (byte) 9, (byte) 1));
        payload.put(HatsNames.TEST_23, new Config("HAT_23", (byte) 10, (byte) 1));
        payload.put(HatsNames.TEST_24, new Config("HAT_24", (byte) 11, (byte) 1));

        // 2 y offset
        payload.put(HatsNames.TEST_25, new Config("HAT_25", (byte) 0, (byte) 2));
        payload.put(HatsNames.TEST_26, new Config("HAT_26", (byte) 1, (byte) 2));
        payload.put(HatsNames.TEST_27, new Config("HAT_27", (byte) 2, (byte) 2));
        payload.put(HatsNames.TEST_28, new Config("HAT_28", (byte) 3, (byte) 2));
        payload.put(HatsNames.TEST_29, new Config("HAT_29", (byte) 4, (byte) 2));
        payload.put(HatsNames.TEST_30, new Config("HAT_30", (byte) 5, (byte) 2));
        payload.put(HatsNames.TEST_31, new Config("HAT_31", (byte) 6, (byte) 2));
        payload.put(HatsNames.TEST_32, new Config("HAT_32", (byte) 7, (byte) 2));
        payload.put(HatsNames.TEST_33, new Config("HAT_33", (byte) 8, (byte) 2));
        payload.put(HatsNames.TEST_34, new Config("HAT_34", (byte) 9, (byte) 2));
        payload.put(HatsNames.TEST_35, new Config("HAT_35", (byte) 10, (byte) 2));
        payload.put(HatsNames.TEST_36, new Config("HAT_36", (byte) 11, (byte) 2));

        // 3 y offset
        payload.put(HatsNames.TEST_37, new Config("HAT_37", (byte) 0, (byte) 3));
        payload.put(HatsNames.TEST_38, new Config("HAT_38", (byte) 1, (byte) 3));
        payload.put(HatsNames.TEST_39, new Config("HAT_39", (byte) 2, (byte) 3));
        payload.put(HatsNames.TEST_40, new Config("HAT_40", (byte) 3, (byte) 3));
        payload.put(HatsNames.TEST_41, new Config("HAT_41", (byte) 4, (byte) 3));
        payload.put(HatsNames.TEST_42, new Config("HAT_42", (byte) 5, (byte) 3));
        payload.put(HatsNames.TEST_43, new Config("HAT_43", (byte) 6, (byte) 3));
        payload.put(HatsNames.TEST_44, new Config("HAT_44", (byte) 7, (byte) 3));
        payload.put(HatsNames.TEST_45, new Config("HAT_45", (byte) 8, (byte) 3));
        payload.put(HatsNames.TEST_46, new Config("HAT_46", (byte) 9, (byte) 3));
        payload.put(HatsNames.TEST_47, new Config("HAT_47", (byte) 10, (byte) 3));
        payload.put(HatsNames.TEST_48, new Config("HAT_48", (byte) 11, (byte) 3));

        return payload;
    }

}
