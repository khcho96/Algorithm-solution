import java.math.BigInteger;

class Solution {
    public int solution(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }
        
        return dp[n].remainder(new BigInteger("1234567")).intValue();
    }
}