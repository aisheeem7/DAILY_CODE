import java.util.*;
public class 2darrays{

    public static List<Integer> diag(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        List<Integer> res = new ArrayList<>();

        for (int c = 0; c < n; c++) {
            int r = 0, j = c;
            while (r < m && j < n) res.add(mat[r++][j++]);
        }

        for (int r = 1; r < m; r++) {
            int i = r, c = 0;
            while (i < m && c < n) res.add(mat[i++][c++]);
        }

        return res;
    }

    public static List<Integer> boundary(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        List<Integer> res = new ArrayList<>();

        if (m == 1) {
            for (int x : mat[0]) res.add(x);
            return res;
        }

        if (n == 1) {
            for (int[] r : mat) res.add(r[0]);
            return res;
        }

        for (int c = 0; c < n; c++) res.add(mat[0][c]);
        for (int r = 1; r < m - 1; r++) res.add(mat[r][n - 1]);
        for (int c = n - 1; c >= 0; c--) res.add(mat[m - 1][c]);
        for (int r = m - 2; r >= 1; r--) res.add(mat[r][0]);

        return res;
    }

    public static List<Integer> spiral(int[][] mat) {
        List<Integer> res = new ArrayList<>();

        int top = 0, bot = mat.length - 1;
        int left = 0, right = mat[0].length - 1;

        while (top <= bot && left <= right) {
            for (int c = left; c <= right; c++) res.add(mat[top][c]);
            top++;

            for (int r = top; r <= bot; r++) res.add(mat[r][right]);
            right--;

            if (top <= bot)
                for (int c = right; c >= left; c--) res.add(mat[bot][c]);
            bot--;

            if (left <= right)
                for (int r = bot; r >= top; r--) res.add(mat[r][left]);
            left++;
        }

        return res;
    }

    public static boolean toe(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        for (int r = 1; r < m; r++)
            for (int c = 1; c < n; c++)
                if (mat[r][c] != mat[r - 1][c - 1]) return false;

        return true;
    }

    public static List<Integer> zig(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        List<Integer> res = new ArrayList<>();

        for (int r = 0; r < m; r++) {
            if (r % 2 == 0)
                for (int c = 0; c < n; c++) res.add(mat[r][c]);
            else
                for (int c = n - 1; c >= 0; c--) res.add(mat[r][c]);
        }

        return res;
    }

    public static int[][] trans(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] t = new int[n][m];

        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                t[c][r] = mat[r][c];

        return t;
    }

    public static void rot(int[][] mat) {
        int n = mat.length;

        for (int r = 0; r < n; r++)
            for (int c = r + 1; c < n; c++) {
                int t = mat[r][c];
                mat[r][c] = mat[c][r];
                mat[c][r] = t;
            }

        for (int r = 0; r < n; r++) {
            int lo = 0, hi = n - 1;
            while (lo < hi) {
                int t = mat[r][lo];
                mat[r][lo++] = mat[r][hi];
                mat[r][hi--] = t;
            }
        }
    }

    public static void life(int[][] b) {
        int m = b.length, n = b[0].length;

        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int live = 0;

                for (int d = 0; d < 8; d++) {
                    int nr = r + dr[d], nc = c + dc[d];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && (b[nr][nc] & 1) == 1)
                        live++;
                }

                if ((b[r][c] & 1) == 1 && (live == 2 || live == 3)) b[r][c] |= 2;
                if ((b[r][c] & 1) == 0 && live == 3) b[r][c] |= 2;
            }
        }

        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                b[r][c] >>= 1;
    }

    public static int[] query(int m, int n, int[][] q) {
        int[][] mat = new int[m][n];
        int num = 1;

        List<Integer> res = new ArrayList<>();
        Set<String> seen = new LinkedHashSet<>();

        for (int[] x : q) {
            String key = x[0] + "," + x[1];

            if (!seen.contains(key)) {
                seen.add(key);
                mat[x[0]][x[1]] = num++;
            }
        }

        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                if (mat[r][c] != 0) res.add(mat[r][c]);

        res.sort(Comparator.naturalOrder());

        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void setZero(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        boolean fr = false, fc = false;

        for (int c = 0; c < n; c++)
            if (mat[0][c] == 0) { fr = true; break; }

        for (int r = 0; r < m; r++)
            if (mat[r][0] == 0) { fc = true; break; }

        for (int r = 1; r < m; r++)
            for (int c = 1; c < n; c++)
                if (mat[r][c] == 0) {
                    mat[r][0] = 0;
                    mat[0][c] = 0;
                }

        for (int r = 1; r < m; r++)
            for (int c = 1; c < n; c++)
                if (mat[r][0] == 0 || mat[0][c] == 0)
                    mat[r][c] = 0;

        if (fr) Arrays.fill(mat[0], 0);

        if (fc)
            for (int r = 0; r < m; r++)
                mat[r][0] = 0;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(diag(mat));
        System.out.println(boundary(mat));
        System.out.println(spiral(mat));

        System.out.println(zig(mat));

        System.out.println(toe(mat));

        System.out.println(Arrays.deepToString(trans(mat)));

        rot(mat);
        System.out.println(Arrays.deepToString(mat));
    }
}
