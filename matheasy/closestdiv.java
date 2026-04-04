import java.util.Scanner;
class Div {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n and m such that m != 0:");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int result;

        if (n >= 0) {
            result = (n / m) * m;   
        } else {
            result = (n / m) * m;
            if (result > n) {
                result -= Math.abs(m);
            }
        }

        System.out.println(result);
    }
}