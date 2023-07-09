package engine.spritesLoader;

public class Utils {

    public static String getSpriteSource(String spriteName) {
        return switch (spriteName) {
            // Outdoors
            case "Outdoors summer" -> "/sprites/tileSets/outdoors_summer.png";
            case "Outdoors autumn" -> "/sprites/tileSets/outdoors_fall.png";
            case "Outdoors winter" -> "/sprites/tileSets/outdoors_winter.png";
            case "Outdoors spring" -> "/sprites/tileSets/outdoors_spring.png";
            // Island
            case "Island summer" -> "/sprites/tileSets/island_summer.png";
            case "Island autumn" -> "/sprites/tileSets/island_fall.png";
            case "Island winter" -> "/sprites/tileSets/island_winter.png";
            case "Island spring" -> "/sprites/tileSets/island_spring.png";
            // Beach
            case "Beach summer" -> "/sprites/tileSets/beach_summer.png";
            case "Beach autumn" -> "/sprites/tileSets/beach_fall.png";
            case "Beach winter" -> "/sprites/tileSets/beach_winter.png";
            case "Beach spring" -> "/sprites/tileSets/beach_spring.png";
            // other
            case "Bug land" -> "/sprites/tileSets/bug_land.png";
            case "Coop" -> "/sprites/tileSets/coop.png";
            case "Darkroom" -> "/sprites/tileSets/darkroom.png";
            case "Desert" -> "/sprites/tileSets/desert.png";
            default -> "";
        };
    }


}
