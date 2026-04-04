import java.util.*;
public class cyclee {

    public static void cycle(int[] arr) {
        int n = arr.length;

        for (int cs = 0; cs < n - 1; cs++) {
            int item = arr[cs], pos = cs;

            for (int i = cs + 1; i < n; i++)
                if (arr[i] < item) pos++;

            if (pos == cs) continue;

            while (item == arr[pos]) pos++;

            int t = arr[pos];
            arr[pos] = item;
            item = t;

            while (pos != cs) {
                pos = cs;

                for (int i = cs + 1; i < n; i++)
                    if (arr[i] < item) pos++;

                while (item == arr[pos]) pos++;

                t = arr[pos];
                arr[pos] = item;
                item = t;
            }
        }
    }

    public static int firstPos(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; ) {
            int j = arr[i] - 1;

            if (j >= 0 && j < n && arr[j] != arr[i]) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            } else i++;
        }

        for (int i = 0; i < n; i++)
            if (arr[i] != i + 1)
                return i + 1;

        return n + 1;
    }

    public static int swaps(int[] arr) {
        int n = arr.length;

        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = arr[i];
            a[i][1] = i;
        }

        Arrays.sort(a, (x, y) -> x[0] - y[0]);

        boolean[] vis = new boolean[n];
        int s = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] || a[i][1] == i) continue;

            int len = 0, j = i;

            while (!vis[j]) {
                vis[j] = true;
                j = a[j][1];
                len++;
            }

            s += len - 1;
        }

        return s;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 5, 4, 2};
        cycle(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {3, 4, -1, 1};
        System.out.println(firstPos(arr2));

        int[] arr3 = {4, 3, 2, 1};
        System.out.println(swaps(arr3));
    }
}