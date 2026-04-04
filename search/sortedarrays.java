public class sortedarrays {

    public static double medianTwoSorted(int[] a, int[] b) {
        if (a.length > b.length) return medianTwoSorted(b, a);

        int m = a.length, n = b.length;
        int lo = 0, hi = m;

        while (lo <= hi) {
            int pa = (lo + hi) / 2;
            int pb = (m + n + 1) / 2 - pa;

            int aLeft  = (pa == 0) ? Integer.MIN_VALUE : a[pa - 1];
            int aRight = (pa == m) ? Integer.MAX_VALUE : a[pa];

            int bLeft  = (pb == 0) ? Integer.MIN_VALUE : b[pb - 1];
            int bRight = (pb == n) ? Integer.MAX_VALUE : b[pb];

            if (aLeft <= bRight && bLeft <= aRight) {
                if ((m + n) % 2 == 0)
                    return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
                return Math.max(aLeft, bLeft);
            } else if (aLeft > bRight) {
                hi = pa - 1;
            } else {
                lo = pa + 1;
            }
        }
        return -1;
    }

    public static int kthOfTwoSorted(int[] a, int[] b, int k) {
        if (a.length > b.length) return kthOfTwoSorted(b, a, k);

        int lo = Math.max(0, k - b.length);
        int hi = Math.min(k, a.length);

        while (lo <= hi) {
            int pa = (lo + hi) / 2;
            int pb = k - pa;

            int aLeft  = (pa == 0) ? Integer.MIN_VALUE : a[pa - 1];
            int aRight = (pa == a.length) ? Integer.MAX_VALUE : a[pa];

            int bLeft  = (pb == 0) ? Integer.MIN_VALUE : b[pb - 1];
            int bRight = (pb == b.length) ? Integer.MAX_VALUE : b[pb];

            if (aLeft <= bRight && bLeft <= aRight) {
                return Math.max(aLeft, bLeft);
            } else if (aLeft > bRight) {
                hi = pa - 1;
            } else {
                lo = pa + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 8};
        int[] b = {2, 7, 10, 12};

        System.out.println(medianTwoSorted(a, b));
        System.out.println(kthOfTwoSorted(a, b, 4));
    }
}