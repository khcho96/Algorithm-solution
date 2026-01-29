import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        answer[prices.length - 1] = 0;
        Deque<Integer> notYet = new ArrayDeque<>();
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] > prices[i]) {
                answer[i - 1] = 1;
                while (!notYet.isEmpty() && prices[notYet.peekLast()] > prices[i]) {
                    int index = notYet.removeLast();
                    answer[index] = i - index;
                }
            } else {
                notYet.add(i - 1);
            }
        }

        while (!notYet.isEmpty()) {
            int index = notYet.removeLast();
            answer[index] = (prices.length - 1) - index;
        }
        
        return answer;
    }
}