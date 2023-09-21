package engine.utils;

public class ArrayUtils {
    public static void reverseStringArray(String[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Swap the elements at the left and right indices
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move the indices towards each other
            left++;
            right--;
        }
    }
}
