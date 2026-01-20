import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while (!s.equals("1")) {
            List<String> split = List.of(s.split(""));
            answer[0]++;
            answer[1] += Collections.frequency(split, "0");

            int n = s.replaceAll("0", "").length();
            StringBuilder string = new StringBuilder();
            while (n > 0) {
                string.insert(0, n % 2 + "");
                n /= 2;
            }

            s = string.toString();
        }
        return answer;
    }
}