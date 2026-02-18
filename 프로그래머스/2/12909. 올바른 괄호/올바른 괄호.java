import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.addLast("(");
            else if (stack.isEmpty()) return false;
            else stack.removeLast();
        }

        return stack.isEmpty();
    }
}