import java.util.*;

public class Prog {
    //memoization , uses extra stack space , top down(start from what's required to base case then come back)
    static int fibo1(int n, List<Integer> dp) {
        if (dp.get(n) != -1) {
            return dp.get(n);
        }
        dp.set(n, fibo1(n - 1, dp) + fibo1(n - 2, dp));
        return dp.get(n);
    }

    //tabulation , get rid of stack space , bottom up(try to go from the base case to the required)
    static int fibo2(int n,List<Integer> dp){
        //base case
        if(n<=2){
            return dp.get(n);
        }
        for(int i = 3;i<=n;i++){
            dp.set(i, dp.get(i-1) + dp.get(i-2));
        }
        return dp.get(n);
    }

    //if you notice in the above approach , dp[i] = dp[i-1] + dp[i-2] , so you only need the previous two elements and not the whole array
    int fibo3(int n){
        if(n<=2){
            return n-1;
        }
        int prev1 = 1;
        int prev2 = 0;
        int curr = -1;
        for(int i = 3;i<=n;i++){
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }

    static int getFibo(int n) {
        List<Integer> dp = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            dp.add(-1); // Add elements to the ArrayList before setting their values
        }
        dp.set(1, 0);
        dp.set(2, 1);
        return fibo2(n, dp);
    }

    public static void main(String args[]) {
        System.out.println(getFibo(5)); // Output: 3
    }
}
