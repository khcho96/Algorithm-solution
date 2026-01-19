import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            String string = String.valueOf(s.charAt(i));

            if (string.equals("(")) {
                stack.addLast(string);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                if (!stack.peekLast().equals("(")) {
                    return false;
                }
                
                stack.removeLast();
            }
        }

        return stack.isEmpty();
    }
}