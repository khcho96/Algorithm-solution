import java.util.Arrays;

class Solution {
    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int i1 = 0;
        int i2 = 0;
        int sum = sequence[0];
        int minLen = sequence.length + 1;
        while (i2 < sequence.length && i1 <= i2) {
            if (sum > k) {
                sum -= sequence[i1++];
            } else if (sum < k) {
                if (++i2 < sequence.length) sum += sequence[i2];
            } else {
                if (minLen > i2 - i1 + 1) {
                    minLen = i2 - i1 + 1;
                    answer[0] = i1;
                    answer[1] = i2;
                }
                sum -= sequence[i1++];
                if (++i2 < sequence.length) sum += sequence[i2];
            }
        }
        return answer;
    }
}