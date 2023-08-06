package utils;

public class ArrayUtils {
    public static boolean contains(int[] array, int value) {
        boolean payload = false;

        for (int item : array) {
            if (value == item) {
                payload = true;
                break;
            }
        }

        return payload;
    }
}
