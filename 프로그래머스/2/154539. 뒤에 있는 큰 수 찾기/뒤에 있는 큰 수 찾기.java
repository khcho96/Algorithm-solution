import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        answer[answer.length - 1] = -1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] < numbers[i]) {
                answer[i - 1] = numbers[i];
                while (!stack.isEmpty() && numbers[stack.peekLast()] < numbers[i]) {
                    answer[stack.removeLast()] = numbers[i];
                }
            } else {
                answer[i - 1] = -1;
                stack.addLast(i - 1);
            }
        }
        return answer;
    }
}