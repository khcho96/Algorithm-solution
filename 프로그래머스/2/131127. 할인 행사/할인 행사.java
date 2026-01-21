import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantCount = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantCount.put(want[i], number[i]);
        }

        Map<String, Integer> curCount = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            curCount.put(discount[i], curCount.getOrDefault(discount[i], 0) + 1);
        }

        int answer = 0;
        for (int i = 9; i < discount.length; i++) {
            curCount.put(discount[i], curCount.getOrDefault(discount[i], 0) + 1);

            if (isAllSatisfied(wantCount, curCount)) {
                answer++;
            }
            curCount.put(discount[i - 9], curCount.get(discount[i - 9]) - 1);
        }

        return answer;
    }

    private static boolean isAllSatisfied(Map<String, Integer> wantCount, Map<String, Integer> curCount) {
        for (String string : wantCount.keySet()) {
            if (!wantCount.get(string).equals(curCount.getOrDefault(string, 0))) {
                return false;
            }
        }
        return true;
    }
}