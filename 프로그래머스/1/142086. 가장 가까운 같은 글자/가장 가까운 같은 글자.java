import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));

            int value = map.getOrDefault(c, i);

            if (value == i) {
                answer[i] = -1;
            } else {
                answer[i] = i - value;
            }
            map.put(c, i);
        }
        return answer;
    }
}