import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] topping) {
        Set<Integer> set1 = new HashSet<>();
        List<Integer> list = new ArrayList<>(Arrays.stream(topping).boxed().collect(Collectors.toList()));
        int count = Arrays.stream(topping).boxed().collect(Collectors.toSet()).size();
        Set<Integer> set = new HashSet<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            map.put(topping[i], i);
        }

        int answer = 0;
        for (int i = 0; i < topping.length; i++) {
            if (set.size() == count) {
                answer++;
            }

            set.add(topping[i]);
            if (map.get(topping[i]) == i) count--;
        }
        return answer;
    }
}