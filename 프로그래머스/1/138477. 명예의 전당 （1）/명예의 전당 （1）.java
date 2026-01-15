import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        List<Integer> fames = new ArrayList<>();
        fames.add(score[0]);
        answer[0] = score[0];
        for (int i = 1; i < score.length; i++) {
            int finalI = i;
            if (fames.stream().anyMatch(s -> s < score[finalI]) || fames.size() < k) {
                fames.add(score[finalI]);
                if (fames.size() > k) {
                    fames.remove(0);
                }
            }
            fames.sort(null);

            answer[i] = fames.get(0);
        }
        
        return answer;
    }
}