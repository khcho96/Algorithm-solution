import java.util.*;

class Solution {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        List<Integer> d = new LinkedList<>();
        List<Integer> p = new LinkedList<>();
        func(cap, deliveries, n - 1, d);
        func(cap, pickups, n - 1, p);

        while (!d.isEmpty() || !p.isEmpty()) {
            if (!d.isEmpty() && !p.isEmpty()) {
                answer += Math.max(d.remove(0), p.remove(0)) * 2L;
            } else if (!d.isEmpty()) {
                answer += d.remove(0) * 2L;
            } else {
                answer += p.remove(0) * 2L;
            }
        }

        return answer;
    }

    private void func(int cap, int[] data, int index, List<Integer> list) {
        while (index >= 0) {
            if (data[index] == 0) {
                index--;
                continue;
            }

            list.add(index + 1);
            int curCap = cap;
            while (curCap > 0 && index >= 0) {
                if (data[index] == 0) {
                    index--;
                    continue;
                }

                if (curCap >= data[index]) {
                    curCap -= data[index];
                } else {
                    data[index] -= curCap;
                    break;
                }

                index--;
            }
        }
    }
}
