class palindrome {

    static boolean isPalindrome(int n) {
        int temp = Math.abs(n), reverse = 0;

        while (temp != 0) {
            reverse = reverse * 10 + temp % 10;
            temp /= 10;
        }

        return reverse == Math.abs(n);
    }

    public static void main(String[] args) {
        int n = 12321;
        System.out.println(isPalindrome(n));
    }
}