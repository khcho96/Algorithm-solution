class Solution {
    public static int solution(int [][]board)
    {
        int answer = 0;
        int[][] dp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) continue;

                int one = (i - 1 >= 0) ? dp[i - 1][j] : 0;
                int two = (j - 1 >= 0) ? dp[i][j - 1] : 0;
                int three = (i - 1 >= 0 && j - 1 >= 0) ? dp[i - 1][j - 1] : 0;

                dp[i][j] = Math.min(Math.min(one, two), three) + 1;

                answer = Math.max(answer, dp[i][j]);
            }
        }

        return answer * answer;
    }
}
