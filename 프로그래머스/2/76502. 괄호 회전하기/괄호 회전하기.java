import java.util.*;

class Solution {

    public Map<Character, Character> map = Map.of(')', '(', '}', '{', ']', '[');

    public int solution(String s) {
        int answer = 0;

        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (isCorrect(stringBuilder.toString())) answer++;

            char c = stringBuilder.charAt(0);
            stringBuilder.deleteCharAt(0);
            stringBuilder.append(c);
        }

        return answer;
    }

    private boolean isCorrect(String string) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (c == '(' || c == '{' || c == '[') stack.addLast(c);
            else if (stack.isEmpty()) return false;
            else if (map.get(c) != stack.removeLast()) return false;
        }

        return stack.isEmpty();
    }
}
