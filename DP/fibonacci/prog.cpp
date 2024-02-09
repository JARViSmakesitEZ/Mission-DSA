#include<vector>
using namespace std;


//memoization , uses extra stack space , top down(start from what's required to base case then come back)
int fibo1(int n,vector<int>& dp){
    if(dp[n]!=-1){
        return dp[n];
    }
    return dp[n] = fibo1(n-1,dp) + fibo1(n-2,dp);
}

//tabulation , get rid of stack space , bottom up(try to go from the base case to the required)
int fibo2(int n,vector<int>& dp){
    //base case
    if(n<=2){
        return dp[n];
    }
    for(int i = 3;i<=n;i++){
        dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
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


int getFibo(int n){
    vector<int> dp(n+1,-1);
    dp[1] = 0;
    dp[2] = 1;
    return fibo2(n,dp);
}