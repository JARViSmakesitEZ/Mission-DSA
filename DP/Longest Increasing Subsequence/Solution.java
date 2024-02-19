import java.util.Arrays;

public class Solution {

    //return just the length
    static int solve(int currIndex, int prevIndex, int[] arr, int[] dp) {
        if (currIndex == arr.length) {
            return 0;
        }
        if (dp[currIndex] != -1) {
            return dp[currIndex];
        }
        int len = 0;
        if (prevIndex == -1 || arr[prevIndex] < arr[currIndex]) {
            len = 1 + solve(currIndex + 1, currIndex, arr, dp);//include curr
        }
        len = Math.max(len, solve(currIndex + 1, prevIndex, arr, dp));//do not include curr
        dp[currIndex] = len;
        return len;
    }

    static List<Integer> solve

    static int LIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = solve(0, -1, arr, dp);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println("Length of LIS is " + LIS(arr));
    }
}
