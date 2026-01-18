import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Integer, Integer> map = Map.of(
                1, 3,
                2, 2,
                3, 1,
                4, 0,
                5, 1,
                6, 2,
                7, 3
        );
        Map<String, Integer> standard = new HashMap<>(
                Map.of(
                        "A", 0,
                        "N", 0,
                        "C", 0,
                        "F", 0,
                        "M", 0,
                        "J", 0,
                        "R", 0,
                        "T", 0
                )
        );

        for (int i = 0; i < survey.length; i++) {
            if (choices[i] < 4) {
                String string = String.valueOf(survey[i].charAt(0));
                standard.put(string, standard.get(string) + map.get(choices[i]));
            } else if (choices[i] > 4) {
                String string = String.valueOf(survey[i].charAt(1));
                standard.put(string, standard.get(string) + map.get(choices[i]));
            }
        }

        StringBuilder answer = new StringBuilder();
        set(standard, answer, "R", "T");
        set(standard, answer, "C", "F");
        set(standard, answer, "J", "M");
        set(standard, answer, "A", "N");
        
        return answer.toString();
    }
    
    public void set(Map<String, Integer> standard, StringBuilder answer, String a, String b) {
        if (standard.get(a) >= standard.get(b)) {
            answer.append(a);
        } else {
            answer.append(b);
        }
    }
}