import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>(Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList()));

        if (list.isEmpty()) return new int[]{-1};

        Integer min = list.stream()
                .min(Integer::compareTo)
                .orElse(0);
        
        list.remove(min);
        
        if (list.isEmpty()) return new int[]{-1};
        
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}