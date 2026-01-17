import java.util.*;

class Solution {
    public int solution(String dartResult) {
        List<Integer> scores = new ArrayList<>();
        int index = -1;
        for (int i = 0; i < dartResult.length(); i++) {
            String c = String.valueOf(dartResult.charAt(i));

            if (c.matches("\\d")) {
                if (dartResult.charAt(i) == '1' && dartResult.charAt(i + 1) == '0') {
                    scores.add(10);
                    i++;
                } else {
                    scores.add(Integer.parseInt(c));
                }
                index++;
            } else if (c.matches("[SDT]")) {
                if (c.equals("D")) {
                    scores.set(index, scores.get(index) * scores.get(index));
                } else if (c.equals("T")) {
                    scores.set(index, scores.get(index) * scores.get(index) * scores.get(index));
                }
            } else {
                if (c.equals("#")) {
                    scores.set(index, scores.get(index) * -1);
                } else {
                    if (index >= 1) {
                        scores.set(index - 1, scores.get(index - 1) * 2);
                    }
                    scores.set(index, scores.get(index) * 2);
                }
            }
        }
        return scores.stream().mapToInt(Integer::intValue).sum();
    }
}