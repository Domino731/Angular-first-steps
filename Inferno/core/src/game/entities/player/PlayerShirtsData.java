package game.entities.player;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static utils.TxtUtils.getPixmapFromTextureRegion;

public class PlayerShirtsData {
    private HashMap<Integer, Integer> shirtColors = new HashMap<>();
    private HashMap<Integer, Integer> pantsColors = new HashMap<>();
    Texture pantsTxt = new Texture("sprites/style/pants.png");

    public TextureRegion arm;

    public PlayerShirtsData() {

    }

    // TODO: test method, remove later
    public TextureRegion test(TextureRegion currentShirt) {
        pantsColors = setPantsColorsBasedOnShirt(currentShirt);
        TextureRegion pants = new TextureRegion(pantsTxt, 0, 0, 16, 16);
        return createArmTextureRegion2(pants, pantsColors, true);
    }

    private TextureRegion createArmTextureRegion2(TextureRegion armTxtRg, HashMap<Integer, Integer> colorsMap, boolean debug) {
        Pixmap pixmap = getPixmapFromTextureRegion(armTxtRg);
        for (int x = 0; x < pixmap.getWidth(); x++) {
            for (int y = 0; y < pixmap.getHeight(); y++) {
                int colorInt = pixmap.getPixel(x, y);
                Integer color = colorsMap.get(colorInt);
                if (colorInt != 0 && color == null) {
                    System.out.println(colorInt);
                }
                if (color != null) {
                    pixmap.drawPixel(x, y, color);
                } else {
                    pixmap.drawPixel(x, y, colorInt);
                }
            }
        }

        Texture newTxt = new Texture(pixmap);
        return new TextureRegion(newTxt);
    }


    public TextureRegion[][] createShirtSleeves(TextureRegion[][] arms, TextureRegion shirtTxtRg) {
        setColorsBasedOnShirt(shirtTxtRg, false);
        TextureRegion[][] newArms = new TextureRegion[PlayerTextures.ARMS_MAX_TEXTURES][PlayerTextures.MAX_ANIMATION_FRAMES];

        for (int i = 0; i < arms.length; i++) {
            TextureRegion[] armsTxtRg = arms[i];
            // skip reversed textures
            if (i == PlayerTextures.STATE_RUNNING_LEFT) {
                armsTxtRg = arms[PlayerTextures.STATE_RUNNING_RIGHT];
            }
            if (i == PlayerTextures.STATE_IDLE_LEFT) {
                armsTxtRg = arms[PlayerTextures.STATE_IDLE_RIGHT];
            }
//            System.out.println(armsTxtRg);
            for (int j = 0; j < armsTxtRg.length; j++) {
                TextureRegion armTxtRg = armsTxtRg[j];
                if (armTxtRg != null) {
                    newArms[i][j] = createArmTextureRegion(armTxtRg, shirtColors, false);
                }
            }
        }

        // reverse colored textures
        for (int i = 0; i < newArms[PlayerTextures.STATE_RUNNING_LEFT].length; i++) {
            TextureRegion armTxtRg = newArms[PlayerTextures.STATE_RUNNING_LEFT][i];
            if (armTxtRg != null) {
                armTxtRg.flip(true, false);
            }
        }
        for (int i = 0; i < newArms[PlayerTextures.STATE_IDLE_LEFT].length; i++) {
            TextureRegion armTxtRg = newArms[PlayerTextures.STATE_IDLE_LEFT][i];
            if (armTxtRg != null) {
                armTxtRg.flip(true, false);
            }
        }

        return newArms;
    }


    public TextureRegion[][] createPants(TextureRegion[][] pants, TextureRegion shirtTxtRg) {
        pantsColors = setPantsColorsBasedOnShirt(shirtTxtRg);
        TextureRegion[][] newArms = new TextureRegion[PlayerTextures.ARMS_MAX_TEXTURES][PlayerTextures.MAX_ANIMATION_FRAMES];

        for (int i = 0; i < pants.length; i++) {
            TextureRegion[] armsTxtRg = pants[i];
            // skip reversed textures
            if (i == PlayerTextures.STATE_RUNNING_LEFT) {
                armsTxtRg = pants[PlayerTextures.STATE_RUNNING_RIGHT];
            }
            if (i == PlayerTextures.STATE_IDLE_LEFT) {
                armsTxtRg = pants[PlayerTextures.STATE_IDLE_RIGHT];
            }
//            System.out.println(armsTxtRg);
            for (int j = 0; j < armsTxtRg.length; j++) {
                TextureRegion armTxtRg = armsTxtRg[j];
                if (armTxtRg != null) {
                    newArms[i][j] = createArmTextureRegion(armTxtRg, pantsColors, false);
                }
            }
        }

        // reverse colored textures
        for (int i = 0; i < newArms[PlayerTextures.STATE_RUNNING_LEFT].length; i++) {
            TextureRegion armTxtRg = newArms[PlayerTextures.STATE_RUNNING_LEFT][i];
            if (armTxtRg != null) {
                armTxtRg.flip(true, false);
            }
        }
        for (int i = 0; i < newArms[PlayerTextures.STATE_IDLE_LEFT].length; i++) {
            TextureRegion armTxtRg = newArms[PlayerTextures.STATE_IDLE_LEFT][i];
            if (armTxtRg != null) {
                armTxtRg.flip(true, false);
            }
        }

        return newArms;
    }

    private TextureRegion createArmTextureRegion(TextureRegion armTxtRg, HashMap<Integer, Integer> colorsMap, boolean debug) {
        Pixmap pixmap = getPixmapFromTextureRegion(armTxtRg);
        for (int x = 0; x < pixmap.getWidth(); x++) {
            for (int y = 0; y < pixmap.getHeight(); y++) {
                int colorInt = pixmap.getPixel(x, y);
                Integer color = colorsMap.get(colorInt);
                if (debug && colorInt != 0) {
                    System.out.println(colorInt);
                    System.out.println(color);
                }

                if (color != null) {
                    pixmap.drawPixel(x, y, color);
                } else {
                    pixmap.drawPixel(x, y, colorInt);
                }
            }
        }

        Texture newTxt = new Texture(pixmap);
        return new TextureRegion(newTxt);
    }

    private TextureRegion createPantsTextureRegion(TextureRegion txtRg) {
        return new TextureRegion();
    }

    private HashMap<Integer, Integer> setColorsBasedOnShirt(TextureRegion shirtTxtRg, boolean isPantsMode) {
        HashMap<Integer, Integer> newColors = new HashMap<>();
        newColors.put(1795177215, 1795177215);
        newColors.put(-106001921, -106001921);
        newColors.put(-529832449, -529832449);

        Pixmap pixmap = getPixmapFromTextureRegion(shirtTxtRg);

        int width = pixmap.getWidth();
        int height = pixmap.getHeight();

        ArrayList<Integer> colorsList = new ArrayList<>();
        int borderColor = 0;
        // Calculate the histogram of color occurrences within the TextureRegion
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = pixmap.getPixel(x, y);
                int r = (pixel & 0xff000000) >>> 24;
                int g = (pixel & 0x00ff0000) >>> 16;
                int b = (pixel & 0x0000ff00) >>> 8;
                int a = (pixel & 0x000000ff);

                // Ignore pixels that are completely transparent
                if (pixel != 0 && borderColor == 0) {
                    borderColor = pixel;
                }
                if (a != 0 && pixel != borderColor) {
                    colorsList.add(pixel);
                }
            }
        }

        // sorting by occurrences
        final Map<Integer, Integer> occurrenceMap = new HashMap<>();
        for (Integer number : colorsList) {
            occurrenceMap.put(number, occurrenceMap.getOrDefault(number, 0) + 1);
        }
        colorsList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return occurrenceMap.get(b) - occurrenceMap.get(a);
            }
        });

        // remove duplicates
        ArrayList<Integer> textureColors = new ArrayList<>();

        for (Integer color : colorsList) {
            if (!textureColors.contains(color)) {
                textureColors.add(color);
            }
        }

        // set main sleeve color
        newColors.put(-1910567681, textureColors.get(0));
        // set sleeve border color
        newColors.put(1242302207, borderColor);
        // set shadow color
        newColors.put(1880561919, textureColors.get(1));

        shirtColors = newColors;

        return newColors;
    }


    private HashMap<Integer, Integer> setPantsColorsBasedOnShirt(TextureRegion shirtTxtRg) {
        HashMap<Integer, Integer> newColors = new HashMap<>();
        Pixmap pixmap = getPixmapFromTextureRegion(shirtTxtRg);
        int width = pixmap.getWidth();
        int height = pixmap.getHeight();
        ArrayList<Integer> colorsList = new ArrayList<>();
        int borderColor = 0;

        // Calculate the histogram of color occurrences within the TextureRegion
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = pixmap.getPixel(x, y);
                int r = (pixel & 0xff000000) >>> 24;
                int g = (pixel & 0x00ff0000) >>> 16;
                int b = (pixel & 0x0000ff00) >>> 8;
                int a = (pixel & 0x000000ff);

                // Ignore pixels that are completely transparent
                if (pixel != 0 && borderColor == 0) {
                    borderColor = pixel;
                }
                if (a != 0 && pixel != borderColor) {
                    colorsList.add(pixel);
                }
            }
        }

        // sorting by occurrences
        final Map<Integer, Integer> occurrenceMap = new HashMap<>();
        for (Integer number : colorsList) {
            occurrenceMap.put(number, occurrenceMap.getOrDefault(number, 0) + 1);
        }
        colorsList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return occurrenceMap.get(b) - occurrenceMap.get(a);
            }
        });

        // remove duplicates
        ArrayList<Integer> textureColors = new ArrayList<>();

        for (Integer color : colorsList) {
            if (!textureColors.contains(color)) {
                textureColors.add(color);
            }
        }
        //// 1. 707410431
        //// 2. 2038337279, 2054914815, 1852930559, -1869440513
        //// 3. -959851521, -1330331137
        //// 4. -131841

        // set main sleeve color
        newColors.put(-131841, textureColors.get(0));

        // set sleeve border color
        newColors.put(707410431, borderColor);
        newColors.put(976898815, borderColor);

        // set shadow color
        int shadowColor = textureColors.get(3);
        newColors.put(2038337279, shadowColor);
        newColors.put(2054914815, shadowColor);
        newColors.put(1852930559, shadowColor);
        newColors.put(-1869440513, shadowColor);

        // shadow 2
        int shadowColor2 = textureColors.get(1);
        newColors.put(-959851521, shadowColor2);

        return newColors;
    }

}