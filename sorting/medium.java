import java.util.*;

public class medium {

    public static int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();

        for (int[] iv : arr) {
            if (res.isEmpty() || res.get(res.size() - 1)[1] < iv[0]) {
                res.add(iv);
            } else {
                res.get(res.size() - 1)[1] =
                        Math.max(res.get(res.size() - 1)[1], iv[1]);
            }
        }
        return res.toArray(new int[0][]);
    }

    public static String largest(int[] nums) {
        String[] s = new String[nums.length];

        for (int i = 0; i < nums.length; i++)
            s[i] = String.valueOf(nums[i]);

        Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));

        if (s[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String x : s) sb.append(x);

        return sb.toString();
    }

    public static int war(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int wins = 0, j = 0;

        for (int i = 0; i < b.length; i++) {
            if (j < a.length && a[j] > b[i]) {
                wins++;
                j++;
            }
        }
        return wins;
    }

    public static long[] candy(int[] p, int k) {
        Arrays.sort(p);
        int n = p.length;

        long min = 0, max = 0;

        for (int i = 0; i < n; ) {
            for (int j = i; j < i + k && j < n; j++)
                min += p[j];
            i += k + (k - 1);
        }

        int lo = 0, hi = n - 1;

        while (hi >= lo) {
            for (int c = 0; c < k && hi >= lo; c++, hi--)
                max += p[hi];
            lo += k - 1;
        }

        return new long[]{min, max};
    }

    public static boolean canMeet(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        for (int i = 1; i < arr.length; i++)
            if (arr[i][0] < arr[i - 1][1]) return false;

        return true;
    }

    public static int[][] insert(int[][] arr, int[] newIv) {
        List<int[]> res = new ArrayList<>();
        int i = 0, n = arr.length;

        while (i < n && arr[i][1] < newIv[0])
            res.add(arr[i++]);

        while (i < n && arr[i][0] <= newIv[1]) {
            newIv[0] = Math.min(newIv[0], arr[i][0]);
            newIv[1] = Math.max(newIv[1], arr[i][1]);
            i++;
        }

        res.add(newIv);

        while (i < n)
            res.add(arr[i++]);

        return res.toArray(new int[0][]);
    }

    public static int moves(int[] seats, int[] stu) {
        Arrays.sort(seats);
        Arrays.sort(stu);

        int m = 0;
        for (int i = 0; i < seats.length; i++)
            m += Math.abs(seats[i] - stu[i]);

        return m;
    }

    public static int maxRot(int[] arr) {
        int n = arr.length;
        int sum = 0, cur = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            cur += i * arr[i];
        }

        int max = cur;

        for (int i = 1; i < n; i++) {
            cur += sum - (long) n * arr[n - i];
            max = Math.max(max, cur);
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] iv = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(iv)));

        int[] nums = {3,30,34,5,9};
        System.out.println(largest(nums));

        int[] a = {2,7,15};
        int[] b = {1,10,4};
        System.out.println(war(a, b));
    }
}
