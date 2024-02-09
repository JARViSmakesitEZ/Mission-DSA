import java.util.*;

public class Prog {
    static int fibo(int n, List<Integer> dp) {
        if (dp.get(n) != -1) {
            return dp.get(n);
        }
        dp.set(n, fibo(n - 1, dp) + fibo(n - 2, dp));
        return dp.get(n);
    }

    static int getFibo(int n) {
        List<Integer> dp = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            dp.add(-1); // Add elements to the ArrayList before setting their values
        }
        dp.set(1, 0);
        dp.set(2, 1);
        return fibo(n, dp);
    }

    public static void main(String args[]) {
        System.out.println(getFibo(5)); // Output: 5
    }
}
