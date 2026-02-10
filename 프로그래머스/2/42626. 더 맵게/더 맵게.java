import java.util.*;

class Solution {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue =  new PriorityQueue<>();
        for (int s : scoville) queue.add(s);

        int answer = 0;
        while (queue.size() > 1 && queue.peek() < K) {
            queue.add(queue.poll() + queue.poll() * 2);
            answer++;
        }

        if (queue.peek() >= K) return answer;
        return -1;
    }
}
