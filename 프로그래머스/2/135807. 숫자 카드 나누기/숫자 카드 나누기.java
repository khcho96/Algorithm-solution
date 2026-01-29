import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        return Math.max(func(arrayA, arrayB), func(arrayB, arrayA));
    }

    private static int func(int[] arrayA, int[] arrayB) {
        List<Integer> divisors = getDivisors(arrayA);

        for (Integer divisor : divisors) {
            boolean check = true;
            for (int i : arrayB) {
                if (i % divisor == 0) {
                    check = false;
                    break;
                }
            }
            if (check) return divisor;
        }
        return 0;
    }

    private static List<Integer> getDivisors(int[] arrayA) {
        int min = Arrays.stream(arrayA).min().orElse(1);
        Set<Integer> divisors = new HashSet<>();
        for (int i = 1; i <= (int) Math.sqrt(min); i++) {
            if (min % i == 0) {
                divisors.add(i);
                divisors.add(min / i);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (Integer divisor : divisors) {
            boolean check = true;
            for (int i : arrayA) {
                if (i % divisor != 0) {
                    check = false;
                    break;
                }
            }
            if (check) set.add(divisor);
        }

        return set.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
}