class butterfly {

    public static void main(String[] args) {

        int n = 5;

        for (int i = 1; i <= 2 * n - 1; i++) {

            int stars = (i <= n) ? i : 2 * n - i;
            int spaces = 2 * (n - stars);

            for (int j = 1; j <= stars; j++)
                System.out.print("*");

            for (int j = 1; j <= spaces; j++)
                System.out.print(" ");

            for (int j = 1; j <= stars; j++)
                System.out.print("*");

            System.out.println();
        }
    }
}