import java.util.*;

class Solution {
    public static String solution(String number, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < number.length(); i++) {
            int num = Integer.parseInt(String.valueOf(number.charAt(i)));
            while (!stack.isEmpty() && stack.peekLast() < num) {
                stack.removeLast();
                k--;
                if (k == 0) break;
            }
            stack.addLast(num);

            if (k == 0) {
                for (int j = i + 1; j < number.length(); j++) {
                    stack.addLast(Integer.parseInt(String.valueOf(number.charAt(j))));
                }
                break;
            }
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