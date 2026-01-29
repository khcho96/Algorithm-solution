import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Map<Integer, Integer> server = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            int need = players[i] / m;
            int curServerCount = 0;
            for (int time = i - k + 1; time <= i; time++) {
                if (time >= 0) curServerCount += server.getOrDefault(time, 0);
            }
            if (need - curServerCount > 0) {
                server.put(i, need - curServerCount);
                answer += (need - curServerCount);
            } else {
                server.put(i, 0);
            }
        }
        return answer;
    }
}