import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : tangerine) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }

        Map<Integer, Integer> map2 = new TreeMap<>(Comparator.comparingInt(Integer::intValue).reversed());
        for (Integer value : map1.values()) {
            map2.put(value, map2.getOrDefault(value, 0) + 1);
        }

        int answer = 0;
        int cur = 0;
        for (Integer key : map2.keySet()) {
            int count = map2.get(key);

            for (int i = 0; i < count; i++) {
                cur += key;
                answer++;
                if (cur >= k) {
                    break;
                }
            }
            if (cur >= k) {
                break;
            }
        }
        return answer;
    }
}