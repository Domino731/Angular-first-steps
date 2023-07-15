package objects.tree;

import engine.engineObject.DynamicEngineObject.DynamicEngineObject;
import engine.utils.vectors.Vector2i;
import engine.utils.vectors.Vector2s;



public class Tree extends DynamicEngineObject {
    public Tree(String name, Vector2i cords, Vector2s size){
        super(name, cords, size);
    }
}
