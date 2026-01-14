import java.util.*;

class Solution {
    public int[] solution(long n) {
        String string = String.valueOf(n);
        int[] list = Arrays.stream(string.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] answer = new int[list.length];
        for (int i = list.length - 1; i >= 0; i--) {
            answer[list.length - 1 - i] = list[i];
        }
        
        return answer;
    }
}