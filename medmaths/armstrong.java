class armstrong {

    static boolean isArmstrong(int n) {
        int temp = n, sum = 0, digits = String.valueOf(n).length();

        while (temp != 0) {
            int r = temp % 10;
            sum += Math.pow(r, digits);
            temp /= 10;
        }

        return sum == n;
    }

    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
    }
}