import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Deque<Integer> origin1 = new ArrayDeque<>(Arrays.stream(queue1).boxed().collect(Collectors.toList()));
        Deque<Integer> origin2 = new ArrayDeque<>(Arrays.stream(queue2).boxed().collect(Collectors.toList()));
        Deque<Integer> q1 = new ArrayDeque<>(Arrays.stream(queue1).boxed().collect(Collectors.toList()));
        Deque<Integer> q2 = new ArrayDeque<>(Arrays.stream(queue2).boxed().collect(Collectors.toList()));
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();

        int answer = 0;
        int q1Count = 0;
        int q2Count = 0;
        while (true) {
            boolean isPossible = true;
            if (sum1 < sum2) {
                while (sum1 < sum2) {
                    int removed = q2.removeFirst();
                    if(!origin2.isEmpty()) origin2.removeFirst();
                    q2Count++;
                    q1.addLast(removed);
                    sum1 += removed;
                    sum2 -= removed;
                    answer++;

                    if (origin1.isEmpty() && origin2.isEmpty()) {
                        isPossible = false;
                        break;
                    }
                }
            } else if (sum1 > sum2) {
                while (sum1 > sum2) {
                    int removed = q1.removeFirst();
                    if(!origin1.isEmpty()) origin1.removeFirst();
                    q1Count++;
                    q2.addLast(removed);
                    sum1 -= removed;
                    sum2 += removed;
                    answer++;

                    if (origin1.isEmpty() && origin2.isEmpty()) {
                        isPossible = false;
                        break;
                    }
                }
            } else {
                break;
            }

            if (!isPossible) {
                answer = -1;
                break;
            }
        }
        return answer;
    }
}