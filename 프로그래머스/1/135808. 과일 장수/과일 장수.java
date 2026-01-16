import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int m, int[] score) {
        List<Integer> list = Arrays.stream(score)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int answer = 0;
        for (int i = 0; i <= list.size() - m; i += m) {
            answer += list.get(i + m - 1) * m;
        }
        return answer;
    }
}