import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] units = new int[]{781, 156, 31, 6, 1};
        Map<String, Integer> mul = Map.of("A", 0, "E", 1, "I", 2, "O", 3, "U", 4);
        for (int i = 0; i < word.length(); i++) {
            String s = String.valueOf(word.charAt(i));
            answer += units[i] * mul.get(s) + 1;
        }
        return answer;
    }
}
