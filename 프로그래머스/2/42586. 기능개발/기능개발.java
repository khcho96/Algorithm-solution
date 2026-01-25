import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] day = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            day[i] = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] > 0) {
                day[i]++;
            }
        }

        List<Integer> count = new ArrayList<>();
        int max = 0;
        for (int i : day) {
            if (max < i) {
                max = i;
                count.add(1);
            } else {
                count.set(count.size() - 1, count.get(count.size() - 1) + 1);
            }
        }
        
        return count.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}