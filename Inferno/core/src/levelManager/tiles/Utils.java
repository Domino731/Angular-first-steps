package levelManager.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import engine.Textures;
import utils.EngineLog;

public class Utils {
    public static TextureRegion createTileTexture(String spriteSheetName, int x, int y) {
        Texture texture = null;
//        System.out.println(spriteSheetName);
        switch (spriteSheetName) {
            case "Outdoors summer":
                texture = Textures.outdoorsSummerTxt;
                break;
            case "Outdoors autumn":
                texture = Textures.outdoorsFallTxt;
                break;
            case "Outdoors winter":
                texture = Textures.outdoorsWinterTxt;
                break;
            case "Outdoors spring":
                texture = Textures.outdoorsSpringTxt;
                break;
            case "Island summer":
                texture = Textures.islandSummerTxt;
                break;
            case "Island autumn":
                texture = Textures.islandFallTxt;
                break;
            case "Island winter":
                texture = Textures.islandWinterTxt;
                break;
            case "Island spring":
                texture = Textures.islandSpringTxt;
                break;
            case "Beach summer":
                texture = Textures.beachSummerTxt;
                break;
            case "Beach autumn":
                texture = Textures.beachFallTxt;
                break;
            case "Beach winter":
                texture = Textures.beachWinterTxt;
                break;
            case "Beach spring":
                texture = Textures.beachSpringTxt;
                break;
            case "Bug land":
                texture = Textures.bugLandTxt;
                break;
            case "Coop":
                texture = Textures.coopTxtTxt;
                break;
            case "Darkroom":
                texture = Textures.darkroomTxt;
                break;
            case "Desert":
                texture = Textures.desertTxt;
                break;
            default:
                EngineLog.error("No match for " + spriteSheetName + " in Utils.createTileTexture");
                texture = Textures.outdoorsSpringTxt;
        }
        return new TextureRegion(texture, x * 16, y * 16, 16, 16);
    }
}
