import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int m, int[] section) {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.stream(section).boxed().collect(Collectors.toList()));

        int answer = 0;
        do {
            int cur = deque.removeFirst();
            
            while (!deque.isEmpty() && deque.peekFirst() <= cur + m - 1) {
                deque.removeFirst();
            }

            answer++;
        } while (!deque.isEmpty());
        return answer;
    }
}