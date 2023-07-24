package game.entities.player;

import utils.Checkbox;
import utils.TextureData;
import utils.vectors.DimensionVector;
import utils.vectors.Vector;

import java.util.ArrayList;

public class NewPlayerConstants {
    public static Vector<Integer> position = new Vector<>(100, 100);
    public static ArrayList<Checkbox> checkboxArray = getCheckboxArray();
    public static final String textureSrc = "sprites/entities/player.png";
    public static final TextureData textureData = new TextureData((short) 9, (short) 6, (short) 64, (short) 40, textureSrc);
    public static final DimensionVector<Integer> dim = new DimensionVector<>(64, 40);

    private static ArrayList<Checkbox> getCheckboxArray() {
        ArrayList<Checkbox> payload = new ArrayList<>();
        payload.add(new Checkbox("PLAYER", new Vector<>(position.x, position.y), new DimensionVector<>(100, 100)));
        return new ArrayList<>();
    }
}
