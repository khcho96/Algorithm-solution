import java.util.*;

class Solution {

    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        List<Integer> list = new ArrayList<>();
        while (k > 0) {
            list.add(k);
            if (k == 1) break;
            k = (k % 2 == 0) ? k / 2 : k * 3 + 1;
        }

        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0], b = (list.size() - 1) + ranges[i][1];

            if (a > b) {
                answer[i] = -1;
                continue;
            }

            double sum = 0;
            for (int j = a; j < b; j++) {
                sum += list.get(j) + list.get(j + 1);
            }
            answer[i] = sum / 2;
        }

        return answer;
    }
}
