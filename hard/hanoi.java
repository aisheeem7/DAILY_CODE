class hanoi {

    static void solve(int n, char from, char to, char aux) {
        if (n == 0)
            return;

        solve(n - 1, from, aux, to);
        System.out.println("Disk " + n + " moved from " + from + " to " + to);
        solve(n - 1, aux, to, from);
    }

    public static void main(String[] args) {
        int n = 3;
        solve(n, 'A', 'C', 'B');
    }
}