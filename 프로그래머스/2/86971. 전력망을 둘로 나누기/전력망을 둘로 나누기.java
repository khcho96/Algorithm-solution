import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] wire : wires) {
            if (!map.containsKey(wire[0])) {
                map.put(wire[0], new HashSet<>(Set.of(wire[1])));
            } else {
                map.get(wire[0]).add(wire[1]);
            }

            if (!map.containsKey(wire[1])) {
                map.put(wire[1], new HashSet<>(Set.of(wire[0])));
            } else {
                map.get(wire[1]).add(wire[0]);
            }
        }

        Set<Integer> answers = new HashSet<>();
        func(map, 0, 1, n, answers);
        return answers.stream().min(Integer::compareTo).orElse(-1);
    }

    private static int func(Map<Integer, Set<Integer>> map, int from, int now, int n, Set<Integer> answers) {
        int count = 0;
        for (Integer i : map.get(now)) {
            if (from == i) continue;
            count += func(map, now, i, n, answers);
        }
        count++;

        answers.add(Math.abs(n - 2 * count));

        return count;
    }
}
