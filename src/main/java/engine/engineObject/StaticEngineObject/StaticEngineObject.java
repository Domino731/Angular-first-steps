package engine.engineObject.StaticEngineObject;

import engine.engineObject.DynamicEngineObject.DynamicEngineObjectType;
import engine.engineObject.EngineObject;
import engine.utils.vectors.Vector2i;
import engine.utils.vectors.Vector2s;

public class StaticEngineObject extends EngineObject {
    private DynamicEngineObjectType type;

    public StaticEngineObject(DynamicEngineObjectType type, String name, Vector2i cords, Vector2s size) {
        super(name, cords, size);
        this.type = type;
    }
}
