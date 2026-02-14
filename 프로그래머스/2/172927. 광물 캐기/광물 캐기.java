import java.util.*;

class Solution {

    public Map<List<String>, Integer> map = new HashMap<>();

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        List<String> names = List.of("diamond", "iron", "stone");
        List<Integer> values = new ArrayList<>(List.of(1, 1, 1, 5, 1, 1, 25, 5, 1));
        for (String name : names) for (String string : names) map.put(List.of(name, string), values.remove(0));

        PriorityQueue<Group> queue = new PriorityQueue<>(Comparator.comparingInt(Group::getSortValue).reversed());
        int maxSize = Arrays.stream(picks).sum();

        int index = 0;
        while (queue.size() < maxSize && index < minerals.length) {
            List<String> strings = new ArrayList<>();
            while (index < minerals.length && strings.size() < 5) strings.add(minerals[index++]);

            queue.add(new Group(strings));
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < picks[i]; j++) {
                if (queue.isEmpty()) return answer;
                answer += queue.poll().getTired(i);
            }
        }

        return answer;
    }

    public class Group {
        List<String> strings;
        public int sortValue = 0;

        public Group(List<String> strings) {
            this.strings = strings;
            for (String string : strings) sortValue += map.get(List.of("stone", string));
        }

        public int getSortValue() {
            return sortValue;
        }

        public int getTired(int index) {
            int tired = 0;

            if (index == 0) for (String string : strings) tired += map.get(List.of("diamond", string));
            else if (index == 1) for (String string : strings) tired += map.get(List.of("iron", string));
            else if (index == 2) for (String string : strings) tired += map.get(List.of("stone", string));

            return tired;
        }
    }
}
