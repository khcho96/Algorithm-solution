import java.util.*;

class Solution {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(0);
        for (int i = 1; i < prices.length; i++) {
            if (!stack.isEmpty() && prices[stack.peekLast()] <= prices[i]) stack.addLast(i);
            else {
                while (!stack.isEmpty() && prices[stack.peekLast()] > prices[i]) {
                    Integer removed = stack.removeLast();
                    answer[removed] = i - removed;
                }
                stack.addLast(i);
            }
        }

        for (int i : stack) {
            answer[i] = stack.peekLast() - i;
        }

        return answer;
    }
}
