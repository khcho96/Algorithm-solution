import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) numbers.add(i);

        long fac = 1;
        for (int i = 2; i < n; i++) fac *= i;

        int idx = 0;
        int i = n - 1;
        while (i > 0) {
            int pick = (int)((k - 1) / fac);
            answer[idx++] = numbers.remove(pick);
            k = (k - 1) % fac + 1;
            fac /= i;
            i--;
        }
        answer[idx] = numbers.remove(0);
        return answer;
    }
}
