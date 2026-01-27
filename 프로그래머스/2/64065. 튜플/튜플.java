import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer> count = new HashMap<>();

        List<Integer> list = Arrays.stream(s.replaceAll("[{}]", "")
                        .split(","))
                .map(String::strip)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (Integer i : list) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        List<E> answer = new ArrayList<>();
        for (Integer i : count.keySet()) {
            answer.add(new E(i, count.get(i)));
        }
        
        answer.sort(Comparator.comparingInt(E::getCount).reversed());
        
        return answer.stream()
                .map(E::getNum)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static class E {
        int num;
        int count;

        public E(int num, int count) {
            this.num = num;
            this.count = count;
        }

        public int getNum() {
            return num;
        }

        public int getCount() {
            return count;
        }
    }
}