package utils.colors;

import java.util.Arrays;
import java.util.Comparator;

public class ColorSorter {
    public static Integer[] sort(int[] colors) {
        Integer[] payload = new Integer[colors.length];

        for (int i = 0; i < colors.length; i++) {
            int color = colors[i];
            payload[i] = color;
        }

        Arrays.sort(payload, new DarknessComparator());

        return payload;
    }

    static class DarknessComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer color1, Integer color2) {
            int darkness1 = calculateDarkness(color1);
            int darkness2 = calculateDarkness(color2);
            return Integer.compare(darkness1, darkness2);
        }

        private int calculateDarkness(int color) {
            int red = (color >> 16) & 0xFF;
            int green = (color >> 8) & 0xFF;
            int blue = color & 0xFF;
            return (int) (0.2126 * red + 0.7152 * green + 0.0722 * blue);
        }
    }
}
