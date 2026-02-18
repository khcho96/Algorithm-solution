import java.util.*;

class Solution {

    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) end - (int) begin + 1];

        int num = (int) begin;
        for (int i = 0; i < answer.length; i++) {
            answer[i] = getNum(num++);
        }

        return answer;
    }

    private int getNum(int num) {
        if (num == 1) return 0;

        int best = 1;
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (num / i <= 10_000_000) return num / i;
                else best = i;
            }
        }

        return best;
    }
}
