import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] food) {
        StringBuilder string = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            string.append(String.valueOf(i).repeat(food[i] / 2));
        }
        String answer1 = string.toString();

        String answer2 = Arrays.stream(answer1.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(""));
        
        return answer1 + "0" + answer2;
    }
}