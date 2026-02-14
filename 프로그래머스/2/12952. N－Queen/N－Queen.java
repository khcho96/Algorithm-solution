import java.util.*;

class Solution {

    public int solution(int n) {
        int[][] isPossibles = new int[n][n];
        return func(isPossibles, 0, n);
    }

    private int func(int[][] isPossibles, int cur, int n) {
        int count = 0;
        if (cur == n - 1) {
            for (int i = 0; i < n; i++) if (isPossibles[cur][i] == 0) count++;
            return count;
        }

        boolean isContinue = false;
        for (int i = 0; i < n; i++) if (isPossibles[cur][i] == 0) isContinue = true;
        if (!isContinue) return 0;

        for (int i = 0; i < n; i++) {
            if (isPossibles[cur][i] != 0) continue;

            // isPossibles 세팅
            int index = 1;
            for (int j = cur + 1; j < n; j++) {
                isPossibles[j][i]++;
                if (i - index >= 0) isPossibles[j][i - index]++;
                if (i + index < n) isPossibles[j][i + index]++;
                index++;
            }
            // func
            count += func(isPossibles, cur + 1, n);
            // isPossibles 리셋
            index = 1;
            for (int j = cur + 1; j < n; j++) {
                isPossibles[j][i]--;
                if (i - index >= 0) isPossibles[j][i - index]--;
                if (i + index < n) isPossibles[j][i + index]--;
                index++;
            }
        }

        return count;
    }

    public void main(String[] args) {
        System.out.println(solution(4));
    }
}
