class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];

        dp[0] = land[0];
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = land[i][j] + max(dp[i - 1], j);
            }
        }
        return max(dp[land.length - 1], -1);
    }

    private static int max(int[] ints, int withoutIndex) {
        int max = 0;
        for (int i = 0; i<ints.length;i++) {
            if (i == withoutIndex) continue;
            if (max < ints[i]) {
                max = ints[i];
            }
        }
        return max;
    }
}
