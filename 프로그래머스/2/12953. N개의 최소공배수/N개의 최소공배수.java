import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int max = Arrays.stream(arr).boxed().max(Integer::compareTo).orElse(1);

        int answer = 0;
        for (int i = max;; i += max) {
            int finalI = i;
            if (Arrays.stream(arr).boxed().allMatch(num -> finalI % num == 0)) {
                answer =  finalI;
                break;
            }
        }

        return answer;
    }
}