import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings)
                .sorted(Comparator.comparing((String s) -> s.charAt(n)).thenComparing(s -> s))
                .collect(Collectors.toList())
                .toArray(new String[0]);
    }
}