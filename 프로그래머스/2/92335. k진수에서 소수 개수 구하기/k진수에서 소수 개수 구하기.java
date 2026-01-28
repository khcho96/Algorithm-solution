import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            stringBuilder.insert(0, n % k);
            n /= k;
        }
        List<Long> list = Arrays.stream(stringBuilder.toString().split("0"))
                .filter(s -> !s.isBlank())
                .map(Long::parseLong)
                .collect(Collectors.toList());

        int answer = 0;
        for (Long a : list) {
            if (isPrime(a)) answer++;
        }
        return answer;
    }

    private static boolean isPrime(Long a) {
        if (a == 1) return false;

        for (int i = 2; i <= (int) Math.sqrt(a); i++) {
            if (a % i == 0) return false;
        }

        return true;
    }
}