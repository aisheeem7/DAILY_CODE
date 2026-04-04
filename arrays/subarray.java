import java.util.*;

class subarray {

    static void printSubarrays(ArrayList<Integer> arr) {
        int n = arr.size();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = i; j < n; j++) {
                sb.append(arr.get(j)).append(" ");
                System.out.println(sb);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        printSubarrays(arr);
    }
}
