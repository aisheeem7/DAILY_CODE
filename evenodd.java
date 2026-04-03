import java.util.Scanner;
public static boolean iseven(int n){
    if(n%2==0)
        return true;
    else
        return false;
}
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter n: ");
    int n=sc.nextInt();
    System.out.println(iseven(n));
}