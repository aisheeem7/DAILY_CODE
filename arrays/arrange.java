import java.util.*;

class arrange {

    static void rearrange(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];

        int pos = 0, neg = 1;

        for (int x : arr) {
            if (x >= 0 && pos < n) {
                res[pos] = x;
                pos += 2;
            } else if (x < 0 && neg < n) {
                res[neg] = x;
                neg += 2;
            }
        }

        for (int i = 0; i < n; i++)
            arr[i] = res[i];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -4, -1, 4};

        rearrange(arr);

        for (int x : arr)
            System.out.print(x + " ");
    }
}
