import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public long solution(long n) {
        String[] split = String.valueOf(n).split("");
        List<String> list = Arrays.stream(split)
                .map(Integer::parseInt)
                .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                .map(String::valueOf)
                .collect(Collectors.toList());

        String join = String.join("", list);

        long answer = Long.parseLong(join);
        
        return answer;
    }
}