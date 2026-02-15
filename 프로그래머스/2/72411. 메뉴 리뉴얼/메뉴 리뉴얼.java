import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public Set<Integer> courses = new HashSet<>();
    public Map<Set<String>, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        for (int i : course) courses.add(i);

        for (String order : orders) {
            func(new HashSet<>(), order, 0);
        }

        List<String> list = new ArrayList<>();

        for (int size : course) {
            int max = 1;
            List<String> list1 = new ArrayList<>();
            for (Set<String> set : map.keySet()) {
                if (map.get(set) < 2) continue;
                if (set.size() == size && max < map.get(set)) {
                    list1 = new ArrayList<>();
                    list1.add(String.join("", set.stream().sorted().collect(Collectors.toList())));
                    max = map.get(set);
                } else if (set.size() == size && max == map.get(set)) {
                    list1.add(String.join("", set.stream().sorted().collect(Collectors.toList())));
                }
            }
            list.addAll(list1);
        }
        list.sort(null);

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    private void func(Set<String> set, String order, int start) {
        if (courses.contains(set.size())) {
            map.put(new HashSet<>(set), map.getOrDefault(set, 0) + 1);
        }

        for (int i = start; i < order.length(); i++) {
            set.add(String.valueOf(order.charAt(i)));
            func(set, order, i + 1);
            set.remove(String.valueOf(order.charAt(i)));
        }
    }
}
