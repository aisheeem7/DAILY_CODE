import java.util.*;

public class medium {

    public static int atoi(String s) {
        s = s.strip();
        if (s.isEmpty()) return 0;

        int sign = 1, i = 0;

        if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(0) == '+') i++;

        long res = 0;

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            res = res * 10 + (s.charAt(i++) - '0');

            if (res * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (res * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int) (res * sign);
    }

    public static String url(String s) {
        int spaces = 0;

        for (char c : s.toCharArray())
            if (c == ' ') spaces++;

        char[] arr = new char[s.length() + 2 * spaces];
        int j = arr.length - 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                arr[j--] = '0';
                arr[j--] = '2';
                arr[j--] = '%';
            } else {
                arr[j--] = s.charAt(i);
            }
        }

        return new String(arr);
    }

    public static String mul(String a, String b) {
        int m = a.length(), n = b.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (a.charAt(i) - '0') * (b.charAt(j) - '0');

                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p2] = sum % 10;
                pos[p1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int x : pos)
            if (!(sb.length() == 0 && x == 0))
                sb.append(x);

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static boolean iso(String s, String t) {
        int[] m1 = new int[256], m2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            int c1 = s.charAt(i), c2 = t.charAt(i);

            if (m1[c1] != m2[c2]) return false;

            m1[c1] = m2[c2] = i + 1;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(atoi("   -42"));
        System.out.println(url("hello world"));

        System.out.println(mul("123", "456"));

        System.out.println(iso("egg", "add"));
    }
}
