import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> list = new ArrayList<>(Arrays.stream(lottos).boxed().collect(Collectors.toList()));
        int zeroCount = Collections.frequency(list, 0);
        list.retainAll(Arrays.stream(win_nums).boxed().collect(Collectors.toSet()));

        int min = list.size();
        int max = list.size() + zeroCount;

        return new int[]{getRank(max), getRank(min)};
    }
    
    public int getRank(int count) {
        switch (count) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;
        }
    }
}