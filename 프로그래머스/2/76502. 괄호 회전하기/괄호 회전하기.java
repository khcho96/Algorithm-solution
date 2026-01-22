import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<String, String> map = Map.of(
                ")", "(",
                "}", "{",
                "]", "["
        );

        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (isRight(map, stringBuilder.toString())) answer++;

            stringBuilder.append(stringBuilder.charAt(0));
            stringBuilder.delete(0, 1);
        }

        return answer;
    }

    private static boolean isRight(Map<String, String> map, String string) {
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < string.length(); i++) {
            String value = String.valueOf(string.charAt(i));

            if (map.containsValue(value)) { // open
                deque.addLast(value);
            } else { // close
                if (deque.isEmpty()) {
                    return false;
                } else {
                    if (deque.peekLast().equals(map.get(value))) {
                        deque.removeLast();
                    } else {
                        return false;
                    }
                }
            }
        }

        return deque.isEmpty();
    }
}