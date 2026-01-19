import java.util.*;

class Solution {
    public String solution(String s) {
        return Arrays.stream(s.split(" "))
                .map(Integer::parseInt)
                .min(Integer::compareTo)
                .orElse(0) + " " + Arrays.stream(s.split(" "))
                .map(Integer::parseInt)
                .max(Integer::compareTo)
                .orElse(0);
    }
}