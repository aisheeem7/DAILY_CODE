class josephus {

    static int solve(int n, int k) {
        int res = 0;

        for (int i = 1; i <= n; i++)
            res = (res + k) % i;

        return res + 1;
    }

    public static void main(String[] args) {
        int n = 7, k = 3;
        System.out.println(solve(n, k));
    }
}