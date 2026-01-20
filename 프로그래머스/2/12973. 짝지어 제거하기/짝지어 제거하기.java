import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            String string = String.valueOf(s.charAt(i));

            if (!stack.isEmpty() && stack.peekLast().equals(string)) {
                stack.removeLast();
            } else {
                stack.addLast(string);
            }
        }
    
        return stack.isEmpty() ? 1 : 0;
    }
}