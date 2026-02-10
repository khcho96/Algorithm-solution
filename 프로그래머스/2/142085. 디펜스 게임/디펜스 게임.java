import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int index = 0;
        while (true) {
            if (n - enemy[index] >= 0) {
                queue.add(enemy[index]);
                n -= enemy[index++];
            } else if (k > 0) {
                k--;
                if (!queue.isEmpty()) {
                    if (queue.peek() >= enemy[index]) n += queue.poll();
                    else index++;
                } else {
                    index++;
                }
            } else {
                break;
            }

            if (index == enemy.length) {
                break;
            }
        }

        return index;
    }
}
