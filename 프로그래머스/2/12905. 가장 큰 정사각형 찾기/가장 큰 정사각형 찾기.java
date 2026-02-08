import java.util.*;

class Solution {
    public static int solution(int [][]board)
    {
        int answer = 0;
        int[][] dp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) dp[i][j] = 0;
                else {
                    int one = (i - 1 >= 0) ? dp[i - 1][j] : 0;
                    int two = (j - 1 >= 0) ? dp[i][j - 1] : 0;
                    int three = (i - 1 >= 0 && j - 1 >= 0) ? dp[i - 1][j - 1] : 0;

                    if (one == two && two == three) dp[i][j] = one + 1;
                    else if (one == 0 || two == 0 || three == 0) dp[i][j] = 1;
                    else {
                        dp[i][j] = Math.min(one, two);
                        if (Math.min(one, two) <= three) dp[i][j]++;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }

        return answer * answer;
    }
}
