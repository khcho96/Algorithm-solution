import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : participant) map.put(s, map.getOrDefault(s, 0) + 1);
        for (String s : completion) {
            map.put(s, map.getOrDefault(s, 0) - 1);
            if (map.get(s) == 0) map.remove(s);
        }
        
        return map.keySet().stream().collect(Collectors.toList()).get(0);
    }
}
