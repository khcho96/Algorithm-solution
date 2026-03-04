import java.util.*;

class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) queue.addLast((100 - progresses[i]) / speeds[i]);
            else queue.addLast((100 - progresses[i]) / speeds[i] + 1);
        }

        while (!queue.isEmpty()) {
            int count = 1;

            int first = queue.pollFirst();
            while (!queue.isEmpty() && first >= queue.peekFirst()) {
                count++;
                queue.pollFirst();
            }
            answer.add(count);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
