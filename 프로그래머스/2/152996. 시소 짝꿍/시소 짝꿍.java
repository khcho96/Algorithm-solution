import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<List<Integer>> set = new HashSet<>();

        for (int weight : weights) {
            count.put(weight, count.getOrDefault(weight, 0) + 1);

            for (int i = 2; i <= 4; i++) {
                if (!map.containsKey(weight * i)) {
                    map.put(weight * i, new HashSet<>(Set.of(weight)));
                } else if (!map.get(weight * i).contains(weight * i)) {
                    map.get(weight * i).add(weight);
                }
            }
        }

        for (int torque : map.keySet()) {
            Set<Integer> weightSet = map.get(torque);
            List<Integer> list = weightSet.stream().sorted().collect(Collectors.toList());
            if (!set.contains(list)) {
                if (weightSet.size() == 2) {
                    int n1 = count.get(list.get(0));
                    int n2 = count.get(list.get(1));
                    answer += (long) n1 * n2;
                    set.add(list);
                } else if (weightSet.size() == 3) {
                    int n1 = count.get(list.get(0));
                    int n2 = count.get(list.get(1));
                    int n3 = count.get(list.get(2));
                    answer += (long) n1 * n2;
                    answer += (long) n1 * n3;
                    answer += (long) n2 * n3;
                    set.add(List.of(list.get(0), list.get(1)));
                    set.add(List.of(list.get(0), list.get(2)));
                    set.add(List.of(list.get(1), list.get(2)));
                }
            }
        }

        for (int weight : count.keySet()) {
            int n = count.get(weight);
            answer += (long) n * (n - 1) / 2;
        }

        return answer;
    }
}
