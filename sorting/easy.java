import java.util.*;

public class easy {

    public static void wave(int[] arr) {
        for (int i = 0; i < arr.length - 1; i += 2) {
            if (arr[i] < arr[i + 1]) {
                int t = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = t;
            }
        }
    }

    public static String[] sortLen(String[] strs) {
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        return strs;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 5, 10, 7, 20};
        wave(arr);
        System.out.println(Arrays.toString(arr));

        String[] strs = {"apple", "hi", "banana", "cat"};
        System.out.println(Arrays.toString(sortLen(strs)));
    }
}