import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[][] list = new int[][]{{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] count = new int[3];

        for (int i = 0; i < 3; i++) for (int j = 0; j < answers.length; j++) if (list[i][j % list[i].length] == answers[j]) count[i]++;

        int max = Math.max(Math.max(count[0], count[1]), count[2]);
        for (int i = 0; i < 3; i++) if (max == count[i]) answer.add(i + 1);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
