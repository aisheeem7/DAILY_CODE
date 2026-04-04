public class same {
    
    // Function to compare both strings directly
    public static boolean samee(String s1, String s2) {
        return s1.equals(s2);
    }
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abcd";
        if (samee(s1, s2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}