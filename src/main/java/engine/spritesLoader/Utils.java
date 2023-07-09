package engine.spritesLoader;

public class Utils {

    public static String getSpriteSource(String spriteName) {
        return switch (spriteName) {
            // Outdoors
            case "Outdoors summer" -> "tileSets/outdoors_summer.png";
            case "Outdoors autumn" -> "tileSets/outdoors_fall.png";
            case "Outdoors winter" -> "tileSets/outdoors_winter.png";
            case "Outdoors spring" -> "tileSets/outdoors_spring.png";
            // Island
            case "Island summer" -> "tileSets/island_summer.png";
            case "Island autumn" -> "tileSets/island_fall.png";
            case "Island winter" -> "tileSets/island_winter.png";
            case "Island spring" -> "tileSets/island_spring.png";
            // Beach
            case "Beach summer" -> "tileSets/beach_summer.png";
            case "Beach autumn" -> "tileSets/beach_fall.png";
            case "Beach winter" -> "tileSets/beach_winter.png";
            case "Beach spring" -> "tileSets/beach_spring.png";
            // other
            case "Bug land" -> "tileSets/bug_land.png";
            case "Coop" -> "tileSets/coop.png";
            case "Darkroom" -> "tileSets/darkroom.png";
            case "Desert" -> "tileSets/desert.png";
            default -> "";
        };
    }


}
