import java.util.*;

class Solution {

    public int solution(int[] cards) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        boolean[] visited = new boolean[cards.length];
        for (int i = 0; i < cards.length; i++) {
            if (visited[i]) continue;

            int index = i;
            int count = 0;
            while (!visited[index]) {
                count++;
                visited[index] = true;
                index = cards[index] - 1;
            }
            queue.add(count);
        }

        if (queue.size() > 1) return queue.poll() * queue.poll();
        return 0;
    }
}
