import java.util.*;

public class Solution {
    public int solution(int n) {
        String string = String.valueOf(n);
        int answer = Arrays.stream(string.split(""))
                .mapToInt(Integer::parseInt)
                .sum();

        return answer;
    }
}