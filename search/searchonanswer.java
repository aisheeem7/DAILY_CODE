import java.util.*;
public class searchonanswer {

    public static long intSqrt(long n) {
        if (n < 2) return n;
        long lo = 1, hi = n / 2, ans = 1;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid <= n / mid) {
                ans = mid;
                lo = mid + 1;
            } else hi = mid - 1;
        }
        return ans;
    }

    public static int nthRoot(int n, int m) {
        int lo = 1, hi = m;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long val = (long) Math.pow(mid, n);
            if (val == m) return mid;
            if (val < m) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    public static boolean isPower(int x, int y) {
        if (x == 1) return y == 1;
        long p = 1;
        while (p < y) {
            p *= x;
            if (p == y) return true;
        }
        return false;
    }

    public static int maximizeMinDiff(int[] arr, int k) {
        Arrays.sort(arr);
        int lo = 0, hi = arr[arr.length - 1] - arr[0], ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canPickK(arr, k, mid)) {
                ans = mid;
                lo = mid + 1;
            } else hi = mid - 1;
        }
        return ans;
    }

    private static boolean canPickK(int[] arr, int k, int minGap) {
        int count = 1, last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= minGap) {
                count++;
                last = arr[i];
            }
        }
        return count >= k;
    }

    public static int smallestNumTrailingZeroes(int n) {
        int lo = 0, hi = 5 * n, ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) >= n) {
                ans = mid;
                hi = mid - 1;
            } else lo = mid + 1;
        }
        return ans;
    }

    private static int trailingZeroes(int n) {
        int z = 0;
        while (n >= 5) {
            n /= 5;
            z += n;
        }
        return z;
    }

    public static int bookAllocation(int[] pages, int m) {
        if (m > pages.length) return -1;
        int lo = Arrays.stream(pages).max().getAsInt();
        int hi = Arrays.stream(pages).sum(), ans = hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (studentsNeeded(pages, mid) <= m) {
                ans = mid;
                hi = mid - 1;
            } else lo = mid + 1;
        }
        return ans;
    }

    private static int studentsNeeded(int[] pages, int limit) {
        int students = 1, cur = 0;
        for (int p : pages) {
            if (p > limit) return Integer.MAX_VALUE;
            if (cur + p > limit) {
                students++;
                cur = 0;
            }
            cur += p;
        }
        return students;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = Arrays.stream(piles).max().getAsInt(), ans = hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (hoursNeeded(piles, mid) <= h) {
                ans = mid;
                hi = mid - 1;
            } else lo = mid + 1;
        }
        return ans;
    }

    private static long hoursNeeded(int[] piles, int k) {
        long h = 0;
        for (int p : piles) h += (p + k - 1) / k;
        return h;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int lo = 1, hi = stalls[stalls.length - 1] - stalls[0], ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canPlaceCows(stalls, k, mid)) {
                ans = mid;
                lo = mid + 1;
            } else hi = mid - 1;
        }
        return ans;
    }

    private static boolean canPlaceCows(int[] stalls, int k, int minDist) {
        int count = 1, last = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= minDist) {
                count++;
                last = stalls[i];
            }
        }
        return count >= k;
    }

    public static int paintersPartition(int[] boards, int k) {
        int lo = Arrays.stream(boards).max().getAsInt();
        int hi = Arrays.stream(boards).sum(), ans = hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (studentsNeeded(boards, mid) <= k) {
                ans = mid;
                hi = mid - 1;
            } else lo = mid + 1;
        }
        return ans;
    }

    public static int medianRowSortedMatrix(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;
        for (int[] row : mat) {
            lo = Math.min(lo, row[0]);
            hi = Math.max(hi, row[c - 1]);
        }
        int desired = (r * c + 1) / 2;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = 0;
            for (int[] row : mat) cnt += upperBound(row, mid);
            if (cnt < desired) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static int upperBound(int[] arr, int k) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] > k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    public static int kthSmallestRowColSorted(int[][] mat, int k) {
        int n = mat.length, lo = mat[0][0], hi = mat[n - 1][n - 1];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = countLessEqual(mat, mid);
            if (cnt < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private static int countLessEqual(int[][] mat, int x) {
        int cnt = 0, n = mat.length, col = n - 1;
        for (int row = 0; row < n; row++) {
            while (col >= 0 && mat[row][col] > x) col--;
            cnt += col + 1;
        }
        return cnt;
    }

    public static int minDaysBouquets(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) return -1;
        int lo = Arrays.stream(bloomDay).min().getAsInt();
        int hi = Arrays.stream(bloomDay).max().getAsInt(), ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (bouquetsPossible(bloomDay, mid, k) >= m) {
                ans = mid;
                hi = mid - 1;
            } else lo = mid + 1;
        }
        return ans;
    }

    private static int bouquetsPossible(int[] bloomDay, int day, int k) {
        int bouquets = 0, cons = 0;
        for (int d : bloomDay) {
            if (d <= day) {
                cons++;
                if (cons == k) {
                    bouquets++;
                    cons = 0;
                }
            } else cons = 0;
        }
        return bouquets;
    }

    public static int kthSmallestMultTable(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = 0;
            for (int i = 1; i <= m; i++) cnt += Math.min(mid / i, n);
            if (cnt < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static int maximizeMedian(int[] arr, int k) {
        Arrays.sort(arr);
        int lo = arr[0], hi = arr[arr.length - 1] + k, ans = arr[0];
        int medianIdx = arr.length / 2;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canMakeMedian(arr, k, mid, medianIdx)) {
                ans = mid;
                lo = mid + 1;
            } else hi = mid - 1;
        }
        return ans;
    }

    private static boolean canMakeMedian(int[] arr, int k, int minMed, int medIdx) {
        long ops = 0;
        for (int i = medIdx; i < arr.length; i++)
            ops += Math.max(0, minMed - arr[i]);
        return ops <= k;
    }

    public static int minTimeOrders(int[] a, int[] b, int n) {
        int lo = 1, hi = (int) 1e9, ans = hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long cnt = 0;
            for (int ra : a) cnt += mid / ra;
            for (int rb : b) cnt += mid / rb;
            if (cnt >= n) {
                ans = mid;
                hi = mid - 1;
            } else lo = mid + 1;
        }
        return ans;
    }

    public static long equalizeTowers(int[] heights, int[] costs) {
        int n = heights.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        Arrays.sort(idx, (a, b) -> heights[a] - heights[b]);

        long leftCost = 0, rightCost = 0, minAns = Long.MAX_VALUE;
        long[] sortedH = new long[n], sortedC = new long[n];

        for (int i = 0; i < n; i++) {
            sortedH[i] = heights[idx[i]];
            sortedC[i] = costs[idx[i]];
        }

        for (int i = 0; i < n; i++)
            rightCost += sortedC[i] * (sortedH[i] - sortedH[0]);

        for (int i = 0; i < n; i++) {
            long cur = leftCost + rightCost;
            minAns = Math.min(minAns, cur);
            if (i < n - 1) {
                long diff = sortedH[i + 1] - sortedH[i];
                leftCost += sortedC[i] * diff;
                for (int j = i + 1; j < n; j++)
                    rightCost -= sortedC[j] * diff;
            }
        }
        return minAns;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};

        System.out.println(intSqrt(25));
        System.out.println(nthRoot(2, 16));
        System.out.println(isPower(2, 16));
        System.out.println(maximizeMinDiff(arr, 3));
        System.out.println(bookAllocation(new int[]{10, 20, 30, 40}, 2));
    }
}