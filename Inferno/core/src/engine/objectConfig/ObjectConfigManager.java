package engine.objectConfig;

import java.util.HashMap;

public class ObjectConfigManager {
    private static final HashMap<String, ObjectConfig> allObjects = new HashMap<>();

    public static void addObjectConfig(ObjectConfig objectConfig) {
        allObjects.put(objectConfig.getId(), objectConfig);
    }


}
