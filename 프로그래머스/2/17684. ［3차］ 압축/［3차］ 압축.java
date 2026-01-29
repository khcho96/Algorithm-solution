import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dic = new HashMap<>();
        int index = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            dic.put(String.valueOf(c), index++);
        }

        List<Integer> answer = new ArrayList<>();
        while (!msg.isBlank()) {
            String old = "";
            for (int i = msg.length(); i > 0; i--) {
                old = msg.substring(0, i);
                if (dic.containsKey(old)) {
                    answer.add(dic.get(old));
                    msg = msg.substring(i);
                    break;
                }
            }

            if (!msg.isBlank()) {
                dic.put(old + msg.charAt(0), index++);
            }
        }
        return answer.stream()
                        .mapToInt(Integer::intValue)
                                .toArray();
    }
}