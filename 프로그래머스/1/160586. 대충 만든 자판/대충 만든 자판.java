import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<String, Integer> map = new HashMap<>();
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                if (i + 1 < map.getOrDefault(String.valueOf(key.charAt(i)), 101)) {
                    map.put(String.valueOf(key.charAt(i)), i + 1);
                }
            }
        }

        int[] answer = new int[targets.length];
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                String key = String.valueOf(targets[i].charAt(j));
                if (map.containsKey(key)) {
                    answer[i] += map.get(key);
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}