import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<String> names = List.of(name);
        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            for (String string : photo[i]) {
                if (names.contains(string)) {
                    answer[i] += yearning[names.indexOf(string)];
                }
            }
        }
        return answer;
    }
}