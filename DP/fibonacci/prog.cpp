#include<vector>
using namespace std;

int fibo(int n,vector<int>& dp){
    if(dp[n]!=-1){
        return dp[n];
    }
    return dp[n] = fibo(n-1,dp) + fibo(n-2,dp);
}


int getFibo(int n){
    vector<int> dp(n+1,-1);
    dp[1] = 0;
    dp[2] = 1;
    return fibo(n,dp);
}