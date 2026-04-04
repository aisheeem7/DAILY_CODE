import java.util.*;

public class arstr {

    public static int maxCirc(int[] arr) {
        int total = arr[0];
        int max = arr[0], curMax = arr[0];
        int min = arr[0], curMin = arr[0];

        for (int i = 1; i < arr.length; i++) {
            curMax = Math.max(arr[i], curMax + arr[i]);
            max = Math.max(max, curMax);

            curMin = Math.min(arr[i], curMin + arr[i]);
            min = Math.min(min, curMin);

            total += arr[i];
        }

        if (max < 0) return max;

        return Math.max(max, total - min);
    }

    public static String nextPal(String s) {
        char[] a = s.toCharArray();
        int n = a.length;

        boolean all9 = true;
        for (char c : a)
            if (c != '9') { all9 = false; break; }

        if (all9) {
            char[] res = new char[n + 1];
            res[0] = res[n] = '1';
            Arrays.fill(res, 1, n, '0');
            return new String(res);
        }

        int mid = n / 2;
        int l = mid - 1, r = (n % 2 == 0) ? mid : mid + 1;

        while (l >= 0 && a[l] == a[r]) { l--; r++; }

        boolean carry = l < 0 || a[l] < a[r];

        l = mid - 1; r = (n % 2 == 0) ? mid : mid + 1;
        while (l >= 0) a[r++] = a[l--];

        if (carry) {
            int c = 1;
            l = mid - 1; r = (n % 2 == 0) ? mid : mid + 1;

            if (n % 2 == 1) {
                int val = a[mid] - '0' + c;
                a[mid] = (char) ('0' + val % 10);
                c = val / 10;
            }

            while (l >= 0 && c > 0) {
                int val = a[l] - '0' + c;
                a[l] = (char) ('0' + val % 10);
                a[r] = a[l];
                c = val / 10;
                l--; r++;
            }
        }

        return new String(a);
    }

    public static long rank(String s) {
        int n = s.length();
        long r = 1;

        long[] fact = new long[n];
        fact[0] = 1;

        for (int i = 1; i < n; i++)
            fact[i] = fact[i - 1] * i;

        for (int i = 0; i < n; i++) {
            int small = 0;

            for (int j = i + 1; j < n; j++)
                if (s.charAt(j) < s.charAt(i)) small++;

            r += small * fact[n - 1 - i];
        }

        return r;
    }

    public static List<String> justify(String[] w, int width) {
        List<String> res = new ArrayList<>();
        int i = 0, n = w.length;

        while (i < n) {
            int len = w[i].length(), j = i + 1;

            while (j < n && len + 1 + w[j].length() <= width) {
                len += 1 + w[j].length();
                j++;
            }

            int count = j - i;
            int spaces = width - len + (count - 1);

            StringBuilder sb = new StringBuilder(w[i]);

            if (j == n || count == 1) {
                for (int k = i + 1; k < j; k++) {
                    sb.append(' ');
                    sb.append(w[k]);
                }
                while (sb.length() < width) sb.append(' ');
            } else {
                int gaps = count - 1;
                int sp = spaces / gaps;
                int extra = spaces % gaps;

                for (int k = i + 1; k < j; k++) {
                    int sps = sp + (k - i <= extra ? 1 : 0);
                    for (int s = 0; s < sps; s++) sb.append(' ');
                    sb.append(w[k]);
                }
            }

            res.add(sb.toString());
            i = j;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, -2, 3, 4};
        System.out.println(maxCirc(arr));

        System.out.println(nextPal("12321"));

        System.out.println(rank("abc"));

        String[] words = {"This", "is", "text", "justification"};
        System.out.println(justify(words, 16));
    }
}