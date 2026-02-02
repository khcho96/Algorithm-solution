import java.util.*;

class Solution {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> state = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < bridge_length; i++) {
            state.addLast(0);
        }

        int cur = 0;
        int sum = 0;
        int count = 0;
        while (cur < truck_weights.length) {
            if (count < bridge_length && sum + truck_weights[cur] <= weight) {
                count++;
                sum -= state.removeFirst();
                sum += truck_weights[cur];
                state.addLast(truck_weights[cur]);
                list.add(truck_weights[cur]);
                cur++;
            } else {
                int removed = state.removeFirst();
                int in = 0;
                if (removed != 0) {
                    count--;
                    sum -= removed;
                    if (sum + truck_weights[cur] <= weight) {
                        count++;
                        sum += truck_weights[cur];
                        in = truck_weights[cur++];
                    }
                }

                state.addLast(in);
                list.add(in);
            }
        }

        return bridge_length + list.size();
    }
}