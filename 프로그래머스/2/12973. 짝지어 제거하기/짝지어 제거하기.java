import java.util.*;

class Solution {

    public int solution(String s)
    {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peekLast() == s.charAt(i)) stack.removeLast();
            else stack.addLast(s.charAt(i));
        }

       return stack.isEmpty() ? 1 : 0;
    }
}
