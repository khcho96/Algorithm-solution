import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> reportCount = new LinkedHashMap<>();
        for (String id : id_list) {
            reportCount.put(id, 0);
        }

        Map<String, Set<String>> reportMap = new LinkedHashMap<>();
        for (String id : id_list) {
            reportMap.put(id, new LinkedHashSet<>());
        }

        for (String string : report) {
            String from = string.split(" ")[0];
            String to = string.split(" ")[1];

            reportMap.get(from).add(to);
        }

        for (String id : reportCount.keySet()) {
            for (Set<String> set : reportMap.values()) {
                if (set.contains(id)) reportCount.put(id, reportCount.get(id) + 1);
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = (int) reportMap.get(id_list[i]).stream()
                    .filter(s -> reportCount.get(s) >= k)
                    .count();
        }
        return answer;
    }
}