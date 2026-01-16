class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) answer++;
        }
        return answer;
    }
    
    public boolean isPrime(int x) {
        if (x == 1) return false;

        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }

        return true;
    }
}