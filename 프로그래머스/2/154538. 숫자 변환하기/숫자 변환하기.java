import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] ints = new int[y + 1];
        boolean[] check = new boolean[y + 1];
        ints[x] = 0;
        check[x] = true;
        for (int i = x + 1; i <= y; i++) {
            int dp1 = -1;
            if (i - n > 0 && check[i - n]) {
                check[i] = true;
                dp1 = ints[i - n] + 1;
            }

            int dp2 = -1;
            if (i % 2 == 0 && check[i / 2]) {
                check[i] = true;
                dp2 = ints[i / 2] + 1;
            }

            int dp3 = -1;
            if (i % 3 == 0 && check[i / 3]) {
                check[i] = true;
                dp3 = ints[i / 3] + 1;
            }

            if (dp1 == -1 && dp2 == -1 && dp3 == -1) {
                ints[i] = -1;
            } else if (dp1 == -1 && dp2 == -1) {
                ints[i] = dp3;
            } else if (dp1 == -1 && dp3 == -1) {
                ints[i] = dp2;
            } else if (dp2 == -1 && dp3 == -1) {
                ints[i] = dp1;
            } else if (dp1 == -1) {
                ints[i] = Math.min(dp2, dp3);
            } else if (dp2 == -1) {
                ints[i] = Math.min(dp1, dp3);
            } else if (dp3 == -1) {
                ints[i] = Math.min(dp1, dp2);
            } else {
                ints[i] = Math.min(Math.min(dp1, dp2), dp3);
            }
        }
        
        return ints[y];
    }
}