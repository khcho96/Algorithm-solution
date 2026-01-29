import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = f(numbers[i]);
        }
        return answer;
    }

    private static long f(long number) {
        if (number == 0) return 1;

        int i = 0;
        long a = 0;
        long n = number;
        while (n > 0) {
            if (n % 2 == 1) a += (long) Math.pow(2, i++);
            else break;
            n /= 2;
        }

        if (a == 0) return number + 1;
        else return number + (a + 1) / 2;
    }
}