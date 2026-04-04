import java.util.*;

public class merges {

    public static void mergeSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;

        int mid = lo + (hi - lo) / 2;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        int[] temp = Arrays.copyOfRange(arr, lo, hi + 1);

        int i = 0, j = mid - lo + 1, k = lo;

        while (i <= mid - lo && j <= hi - lo) {
            if (temp[i] <= temp[j]) arr[k++] = temp[i++];
            else arr[k++] = temp[j++];
        }

        while (i <= mid - lo) arr[k++] = temp[i++];
        while (j <= hi - lo) arr[k++] = temp[j++];
    }

    public static List<Integer> union(int[] a, int[] b) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                if (res.isEmpty() || res.get(res.size() - 1) != a[i]) res.add(a[i]);
                i++;
            } else if (b[j] < a[i]) {
                if (res.isEmpty() || res.get(res.size() - 1) != b[j]) res.add(b[j]);
                j++;
            } else {
                if (res.isEmpty() || res.get(res.size() - 1) != a[i]) res.add(a[i]);
                i++; j++;
            }
        }

        while (i < a.length) {
            if (res.isEmpty() || res.get(res.size() - 1) != a[i]) res.add(a[i]);
            i++;
        }

        while (j < b.length) {
            if (res.isEmpty() || res.get(res.size() - 1) != b[j]) res.add(b[j]);
            j++;
        }

        return res;
    }

    public static List<Integer> inter(int[] a, int[] b) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) i++;
            else if (b[j] < a[i]) j++;
            else {
                res.add(a[i]);
                i++; j++;
            }
        }
        return res;
    }

    public static void mergeGap(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int gap = nextGap(m + n);

        while (gap > 0) {
            for (int i = 0; i + gap < m + n; i++) {
                int j = i + gap;

                int ai = (i < m) ? a[i] : b[i - m];
                int aj = (j < m) ? a[j] : b[j - m];

                if (ai > aj) {
                    if (i < m && j < m) {
                        int t = a[i]; a[i] = a[j]; a[j] = t;
                    } else if (i < m) {
                        int t = a[i]; a[i] = b[j - m]; b[j - m] = t;
                    } else {
                        int t = b[i - m]; b[i - m] = b[j - m]; b[j - m] = t;
                    }
                }
            }
            gap = nextGap(gap);
        }
    }

    private static int nextGap(int gap) {
        return (gap <= 1) ? 0 : (gap + 1) / 2;
    }

    public static int platforms(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int p = 1, max = 1, i = 1, j = 0;

        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                p++;
                i++;
            } else {
                p--;
                j++;
            }
            max = Math.max(max, p);
        }
        return max;
    }

    public static long inv(int[] arr) {
        return invSort(arr, 0, arr.length - 1);
    }

    private static long invSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return 0;

        int mid = lo + (hi - lo) / 2;

        long cnt = invSort(arr, lo, mid) + invSort(arr, mid + 1, hi);

        int[] temp = new int[hi - lo + 1];
        int i = lo, j = mid + 1, k = 0;

        while (i <= mid && j <= hi) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else {
                cnt += mid - i + 1;
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= hi) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, lo, temp.length);

        return cnt;
    }

    public static int[] surpass(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];

        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = arr[i];
            a[i][1] = i;
        }

        supSort(a, res, 0, n - 1);
        return res;
    }

    private static void supSort(int[][] arr, int[] res, int lo, int hi) {
        if (lo >= hi) return;

        int mid = lo + (hi - lo) / 2;

        supSort(arr, res, lo, mid);
        supSort(arr, res, mid + 1, hi);

        int i = lo, j = mid + 1;
        int[][] temp = new int[hi - lo + 1][2];
        int k = 0;

        while (i <= mid && j <= hi) {
            if (arr[i][0] < arr[j][0]) {
                res[arr[i][1]] += hi - j + 1;
                temp[k++] = arr[i++];
            } else temp[k++] = arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= hi) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, lo, temp.length);
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        int[] a = {1, 2, 4};
        int[] b = {2, 3, 5};
        System.out.println(union(a, b));
        System.out.println(inter(a, b));
    }
}