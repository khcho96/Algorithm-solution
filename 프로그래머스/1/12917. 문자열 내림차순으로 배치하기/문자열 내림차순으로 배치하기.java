import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        List<String> list = Arrays.stream(s.split(""))
                .sorted()
                .collect(Collectors.toList());

        list.sort(Comparator.reverseOrder());
        
        return String.join("", list);
    }
}