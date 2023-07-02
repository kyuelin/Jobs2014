package dev.kyuelin.codechef;

/**
 * Created by kennethlin on 6/14/16.
 */
public class DynamicProg {
    public static void getMinStepsToOneByMemorization(int n) {
        int[] memo = new int[n+1];
        for(int i=0; i<n+1; i++) {
            memo[i]=-1;
        }
        System.out.println(getMinSteps(n, memo));
    }

    public static int getMinSteps(int n, int[] memo) {
        if(n==1) return 0;
        if(memo[n] != -1) return memo[n];
        int r = 1+getMinSteps(n-1, memo);
        if(n%2 ==0) r = Math.min(r, 1+getMinSteps(n/2, memo));
        if(n%3 ==0) r = Math.min(r, 1+getMinSteps(n/3, memo));
        memo[n]=r;
        return r;
    }

    public static void getMinStepsToOneByBottomUpDP(int n) {
        int[] dp;
        int i;
        dp = new int[n+1];

        dp[1]=0;
        for (i=2; i<=n; i--) {
            dp[i]=1+dp[i-1];
            if(i%2==0) dp[i]=Math.min(dp[i], dp[i/2]);
            if(i%3==0) dp[i]=Math.min(dp[i], dp[i/3]);
        }
        System.out.println(dp[n]);
    }

    public static void main(String[] args) {
        getMinStepsToOneByBottomUpDP(6);
        getMinStepsToOneByMemorization(6);
    }


}
