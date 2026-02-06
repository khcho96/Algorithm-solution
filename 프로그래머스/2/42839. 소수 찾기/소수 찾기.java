import java.util.*;

class Solution {
    public static int solution(String numbers) {
        boolean[] visit = new boolean[numbers.length()];
        Set<Integer> primes = new HashSet<>();
        for (int i = 0; i < numbers.length(); i++) {
            String s = String.valueOf(numbers.charAt(i));
            visit[i] = true;
            dfs(s, primes, numbers, visit);
            visit[i] = false;
        }
        return primes.size();
    }

    private static void dfs(String s, Set<Integer> primes, String numbers, boolean[] visit) {
        if (isPrime(s)) primes.add(Integer.parseInt(s));

        for (int i = 0; i < numbers.length(); i++) {
            if (visit[i]) continue;

            visit[i] = true;
            dfs(s + numbers.charAt(i), primes, numbers, visit);
            visit[i] = false;
        }
    }

    private static boolean isPrime(String s) {
        int num = Integer.parseInt(s);
        if (num == 0 || num == 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
