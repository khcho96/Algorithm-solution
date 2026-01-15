import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList<>(Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList()));
        List<Integer> answer = new ArrayList<>();
        for (int[] command : commands) {
            answer.add(list.subList(command[0] - 1, command[1])
                    .stream()
                    .sorted(Comparator.naturalOrder())
                    .collect(Collectors.toList())
                    .get(command[2] - 1));
        }
        
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}