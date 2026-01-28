import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String str = str1.substring(i, i + 2);

            if (!str.matches("[a-z]{2}")) continue;

            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>(List.of(1, 0)));
            } else {
                map.get(str).set(0, map.get(str).get(0) + 1);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String str = str2.substring(i, i + 2);

            if (!str.matches("[a-z]{2}")) continue;

            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>(List.of(0, 1)));
            } else {
                map.get(str).set(1, map.get(str).get(1) + 1);
            }
        }

        if (map.isEmpty()) return 65536;

        int interCount = 0;
        int unionCount = 0;
        for (String string : map.keySet()) {
            int count1 = map.get(string).get(0);
            int count2 = map.get(string).get(1);

            if (count1 == 0 || count2 == 0) {
                unionCount += Math.max(count1, count2);
            } else {
                unionCount += Math.max(count1, count2);
                interCount += Math.min(count1, count2);
            }
        }

        return (int) (((double) interCount / unionCount) * 65536);
    }
}