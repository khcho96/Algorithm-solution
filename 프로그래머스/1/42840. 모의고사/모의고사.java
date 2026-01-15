import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] cnt = new int[3];
        int[] one = new int[]{1,2,3,4,5};
        int[] two = new int[]{2,1,2,3,2,4,2,5};
        int[] three = new int[]{3,3,1,1,2,2,4,4,5,5};
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i % one.length]) cnt[0]++;
            if(answers[i] == two[i % two.length]) cnt[1]++;
            if(answers[i] == three[i % three.length]) cnt[2]++;
        }
        
        int max = Arrays.stream(cnt)
            .max()
            .orElse(0);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (max == cnt[i]) {
                list.add(i + 1);
            }
        }
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}