import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> stack = new ArrayDeque<>();
        int answer = 0;
        int index = 1;
        while (answer < order.length) {
            if (index < order[answer]) {
                stack.add(index++);
            } else if (index > order[answer]) {
                if (stack.removeLast() != order[answer]) {
                    break;
                } else {
                    answer++;
                }
            } else {
                answer++;
                index++;
            }
        }
        return answer;
    }
}