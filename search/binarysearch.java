import java.util.*;
public class binarysearch {

    public static int searchInsertPosition(int[] arr, int k) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == k) return mid;
            if (arr[mid] < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    public static int lowerBound(int[] arr, int k) {
        int lo = 0, hi = arr.length, ans = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= k) {
                ans = mid;
                hi = mid;
            } else lo = mid + 1;
        }
        return ans;
    }

    public static int upperBound(int[] arr, int k) {
        int lo = 0, hi = arr.length, ans = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > k) {
                ans = mid;
                hi = mid;
            } else lo = mid + 1;
        }
        return ans;
    }

    public static int singleNonDuplicate(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid % 2 == 1) mid--;
            if (arr[mid] == arr[mid + 1]) lo = mid + 2;
            else hi = mid;
        }
        return arr[lo];
    }

    public static int findMissingNumber(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] - mid == 1) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo + 1;
    }

    public static int countOccurrences(int[] arr, int x) {
        return upperBound(arr, x) - lowerBound(arr, x);
    }

    public static int[] search2DMatrix(int[][] mat, int target) {
        int row = 0, col = mat[0].length - 1;
        while (row < mat.length && col >= 0) {
            if (mat[row][col] == target) return new int[]{row, col};
            if (mat[row][col] > target) col--;
            else row++;
        }
        return new int[]{-1, -1};
    }

    public static int searchRotated(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) return mid;
            if (arr[lo] <= arr[mid]) {
                if (target >= arr[lo] && target < arr[mid]) hi = mid - 1;
                else lo = mid + 1;
            } else {
                if (target > arr[mid] && target <= arr[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1;
    }

    public static boolean searchRotatedWithDups(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) return true;
            if (arr[lo] == arr[mid] && arr[mid] == arr[hi]) {
                lo++;
                hi--;
                continue;
            }
            if (arr[lo] <= arr[mid]) {
                if (target >= arr[lo] && target < arr[mid]) hi = mid - 1;
                else lo = mid + 1;
            } else {
                if (target > arr[mid] && target <= arr[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return false;
    }

    public static List<Integer> kClosest(int[] arr, int x, int k) {
        int pos = lowerBound(arr, x);
        int lo = pos - 1, hi = pos;
        List<Integer> res = new ArrayList<>();
        while (k-- > 0) {
            if (lo < 0) res.add(arr[hi++]);
            else if (hi >= arr.length) res.add(arr[lo--]);
            else if (Math.abs(arr[lo] - x) <= Math.abs(arr[hi] - x)) res.add(arr[lo--]);
            else res.add(arr[hi++]);
        }
        return res;
    }

    public static int searchAlmostSorted(int[] arr, int k) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == k) return mid;
            if (mid - 1 >= lo && arr[mid - 1] == k) return mid - 1;
            if (mid + 1 <= hi && arr[mid + 1] == k) return mid + 1;
            if (arr[mid] > k) hi = mid - 2;
            else lo = mid + 2;
        }
        return -1;
    }

    public static int findPeak1D(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < arr[mid + 1]) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static int[] findPeak2D(int[][] mat) {
        int lo = 0, hi = mat[0].length - 1;
        while (lo <= hi) {
            int midCol = lo + (hi - lo) / 2;
            int maxRow = 0;
            for (int r = 0; r < mat.length; r++)
                if (mat[r][midCol] > mat[maxRow][midCol]) maxRow = r;

            boolean leftBig = midCol > 0 && mat[maxRow][midCol - 1] > mat[maxRow][midCol];
            boolean rightBig = midCol < mat[0].length - 1 && mat[maxRow][midCol + 1] > mat[maxRow][midCol];

            if (!leftBig && !rightBig) return new int[]{maxRow, midCol};
            if (leftBig) hi = midCol - 1;
            else lo = midCol + 1;
        }
        return new int[]{-1, -1};
    }

    public static int rangeCount(int[] arr, int l, int r, int x) {
        if (x < l || x > r) return 0;
        return countOccurrences(arr, x);
    }

    public static int kthMissing(int[] arr, int k) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo + k;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 5, 6, 8};

        System.out.println(searchInsertPosition(arr, 3));
        System.out.println(lowerBound(arr, 4));
        System.out.println(upperBound(arr, 4));
        System.out.println(countOccurrences(arr, 4));
        System.out.println(kthMissing(arr, 2));
    }
}