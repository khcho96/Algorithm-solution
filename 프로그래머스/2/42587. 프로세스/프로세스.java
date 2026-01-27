import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.stream(priorities).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        int answer = 0;
        int index = 0;
        while (!deque.isEmpty()) {
            if (priorities[index % priorities.length] == deque.peekFirst()) {
                deque.removeFirst();
                answer++;

                if (location == index % priorities.length) break;
            }

            index++;
        }
        return answer;
    }
}