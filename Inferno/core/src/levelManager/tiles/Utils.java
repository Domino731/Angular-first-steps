package levelManager.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import engine.Textures;
import utils.EngineLog;

public class Utils {
    public static TextureRegion createTileTexture(String spriteSheetName, int x, int y) {
        Texture texture = null;
        System.out.println(spriteSheetName);
        switch (spriteSheetName) {
            case "Outdoors summer":
                texture = Textures.outdoorsSummerTxt;
            case "Outdoors autumn":
                texture = Textures.outdoorsFallTxt;
            case "Outdoors winter":
                texture = Textures.outdoorsWinterTxt;
            case "Outdoors spring":
                texture = Textures.outdoorsSpringTxt;
            case "Island summer":
                texture = Textures.islandSummerTxt;
            case "Island autumn":
                texture = Textures.islandFallTxt;
            case "Island winter":
                texture = Textures.islandWinterTxt;
            case "Island spring":
                texture = Textures.islandSpringTxt;
            case "Beach summer":
                texture = Textures.beachSummerTxt;
            case "Beach autumn":
                texture = Textures.beachFallTxt;
            case "Beach winter":
                texture = Textures.beachWinterTxt;
            case "Beach spring":
                texture = Textures.beachSpringTxt;
            case "Bug land":
                texture = Textures.bugLandTxt;
            case "Coop":
                texture = Textures.coopTxtTxt;
            case "Darkroom":
                texture = Textures.darkroomTxt;
            case "Desert":
                texture = Textures.desertTxt;
            default:
                EngineLog.error("No match for " + spriteSheetName + " in Utils.createTileTexture");
                texture = Textures.outdoorsSpringTxt;
        }
        return new TextureRegion(texture, x, y);
    }

    ;
}
