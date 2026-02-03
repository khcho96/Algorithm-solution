import java.util.*;

class Solution {
    public static String solution(String number, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < number.length(); i++) {
            int num = Integer.parseInt(String.valueOf(number.charAt(i)));
            while (k > 0 && !stack.isEmpty() && stack.peekLast() < num) {
                stack.removeLast();
                k--;
            }
            stack.addLast(num);
        }

        if (k > 0) {
            for (int i = 0; i < k; i++) {
                stack.removeLast();
            }
        }

        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.removeFirst());
        }
        return answer.toString();
    }
}