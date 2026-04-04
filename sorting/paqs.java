import java.util.*;

public class paqs {

    public static void quick(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int p = part(arr, lo, hi);
            quick(arr, lo, p - 1);
            quick(arr, p + 1, hi);
        }
    }

    private static int part(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo - 1;

        for (int j = lo; j < hi; j++) {
            if (arr[j] <= pivot) {
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        int t = arr[i + 1];
        arr[i + 1] = arr[hi];
        arr[hi] = t;

        return i + 1;
    }

    public static void bin(int[] arr) {
        int lo = 0, hi = arr.length - 1;

        while (lo < hi) {
            if (arr[lo] == 0) lo++;
            else if (arr[hi] == 1) hi--;
            else {
                arr[lo++] = 0;
                arr[hi--] = 1;
            }
        }
    }

    public static void moveZero(int[] arr) {
        int pos = 0;

        for (int x : arr)
            if (x != 0)
                arr[pos++] = x;

        while (pos < arr.length)
            arr[pos++] = 0;
    }

    public static void dnf(int[] arr) {
        int lo = 0, mid = 0, hi = arr.length - 1;

        while (mid <= hi) {
            if (arr[mid] == 0) {
                int t = arr[lo];
                arr[lo++] = arr[mid];
                arr[mid++] = t;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int t = arr[mid];
                arr[mid] = arr[hi];
                arr[hi--] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        quick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        int[] b = {1, 0, 1, 0, 1};
        bin(b);
        System.out.println(Arrays.toString(b));

        int[] c = {0, 1, 0, 3, 12};
        moveZero(c);
        System.out.println(Arrays.toString(c));

        int[] d = {2, 0, 2, 1, 1, 0};
        dnf(d);
        System.out.println(Arrays.toString(d));
    }
}