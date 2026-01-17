import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Map<Integer, Boolean> lostMap = new HashMap<>();
        Map<Integer, Boolean> reserveMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            lostMap.put(i, false);
            reserveMap.put(i, false);
        }
        for (int i : lost) {
            lostMap.put(i, true);
        }
        for (int i : reserve) {
            if (!lostMap.get(i)) reserveMap.put(i, true);
            else lostMap.put(i, false);
        }

        int answer = n;
        for (int i = 1; i <= n; i++) {
            if (lostMap.get(i)) {
                if (i > 1 && reserveMap.get(i - 1)) {
                    reserveMap.put(i - 1, false);
                    continue;
                }

                if (i < n && reserveMap.get(i + 1)) {
                    reserveMap.put(i + 1, false);
                    continue;
                }

                answer--;
            }
        }
        
        return answer;
    }
}