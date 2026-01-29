import java.math.BigInteger;

class Solution {
    public int solution(int n) {
        if (n % 2 == 1) return 0;
        if (n == 2) return 3;
        
        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.ONE;
        dp[2] = new BigInteger("3");

        for (int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2].multiply(new BigInteger("4")).add(dp[i - 4].negate());
        }
        
        return dp[n].remainder(new BigInteger("1000000007")).intValue();
    }
}