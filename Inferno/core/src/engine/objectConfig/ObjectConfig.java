package engine.objectConfig;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Holding all base data about object - id, name, specs...
 */
public class ObjectConfig {
    private final String id;
    private final String name;
    private final JsonNode specs;
    private final String type;

    public ObjectConfig(String id, String type, String name, JsonNode specs) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.specs = specs;
        ObjectConfigManager.addObjectConfig(this);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public JsonNode getSpecs() {
        return specs;
    }
}
