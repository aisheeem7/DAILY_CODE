import java.util.*;

public class medium {

    public static int majority(int[] arr) {
        int cand = arr[0], cnt = 1;

        for (int i = 1; i < arr.length; i++) {
            if (cnt == 0) {
                cand = arr[i];
                cnt = 1;
            } else if (arr[i] == cand) cnt++;
            else cnt--;
        }

        cnt = 0;
        for (int x : arr) if (x == cand) cnt++;

        return cnt > arr.length / 2 ? cand : -1;
    }

    public static List<Integer> majority2(int[] arr) {
        int c1 = 0, c2 = 1, n1 = 0, n2 = 0;

        for (int x : arr) {
            if (x == c1) n1++;
            else if (x == c2) n2++;
            else if (n1 == 0) { c1 = x; n1 = 1; }
            else if (n2 == 0) { c2 = x; n2 = 1; }
            else { n1--; n2--; }
        }

        n1 = n2 = 0;
        for (int x : arr) {
            if (x == c1) n1++;
            else if (x == c2) n2++;
        }

        List<Integer> res = new ArrayList<>();
        if (n1 > arr.length / 3) res.add(c1);
        if (n2 > arr.length / 3) res.add(c2);

        return res;
    }

    public static List<Integer> nByK(int[] arr, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int x : arr) {
            map.merge(x, 1, Integer::sum);

            if (map.size() == k) {
                map.replaceAll((key, val) -> val - 1);
                map.values().removeIf(v -> v == 0);
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int key : map.keySet()) {
            int cnt = 0;
            for (int x : arr) if (x == key) cnt++;
            if (cnt > arr.length / k) res.add(key);
        }

        return res;
    }

    public static int[] sub3(int[] arr) {
        int n = arr.length;

        int[] small = new int[n];
        int[] great = new int[n];

        Arrays.fill(small, -1);
        Arrays.fill(great, -1);

        int min = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[min]) min = i;
            else small[i] = min;
        }

        int max = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[max]) max = i;
            else great[i] = max;
        }

        for (int i = 0; i < n; i++) {
            if (small[i] != -1 && great[i] != -1) {
                return new int[]{arr[small[i]], arr[i], arr[great[i]]};
            }
        }

        return new int[]{};
    }

    public static void next(int[] arr) {
        int n = arr.length, i = n - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) i--;

        if (i >= 0) {
            int j = n - 1;
            while (arr[j] <= arr[i]) j--;

            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

        int lo = i + 1, hi = n - 1;
        while (lo < hi) {
            int t = arr[lo];
            arr[lo++] = arr[hi];
            arr[hi--] = t;
        }
    }

    public static int kadane(int[] arr) {
        int max = arr[0], cur = arr[0];

        for (int i = 1; i < arr.length; i++) {
            cur = Math.max(arr[i], cur + arr[i]);
            max = Math.max(max, cur);
        }

        return max;
    }

    public static long sumAll(int[] arr) {
        long sum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            sum += (long) arr[i] * (i + 1) * (n - i);
        }

        return sum;
    }

    public static int maxProd(int[] arr) {
        int max = arr[0], min = arr[0], res = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                int t = max;
                max = min;
                min = t;
            }

            max = Math.max(arr[i], max * arr[i]);
            min = Math.min(arr[i], min * arr[i]);

            res = Math.max(res, max);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majority(arr));

        int[] arr2 = {1, 2, 3, 1, 2, 1};
        System.out.println(majority2(arr2));

        int[] arr3 = {3, 4, -1, 1};
        System.out.println(Arrays.toString(sub3(arr3)));

        int[] arr4 = {1, 2, 3};
        next(arr4);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(kadane(arr5));
    }
}
