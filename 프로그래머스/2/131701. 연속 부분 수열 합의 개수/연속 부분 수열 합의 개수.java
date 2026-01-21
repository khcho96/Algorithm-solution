import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>(List.of(0));
        for (int i = 1; i < elements.length; i++) {
            int sum = list.get(list.size() - 1) + elements[i - 1];
            list.add(sum);
            set.add(sum);

            for (int j = 1; j < elements.length; j++) {
                if (j + i - 1 < elements.length) {
                    sum = sum - elements[j - 1] + elements[j + i - 1];
                } else {
                    sum = sum - elements[j - 1] + elements[(j + i - 1) % elements.length];
                }
                set.add(sum);
            }
        }
        set.add(list.get(list.size() - 1) + elements[elements.length - 1]);
        
        return set.size();
    }
}