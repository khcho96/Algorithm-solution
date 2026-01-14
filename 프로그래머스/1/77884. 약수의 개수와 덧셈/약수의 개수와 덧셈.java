class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int x = left; x <= right; x++) {
            int dc = calculateDivisorCount(x);
            if (dc % 2 == 0) {
                answer += x;
            } else {
                answer -= x;
            }
        }
        return answer;
    }
    
    public int calculateDivisorCount(int n) {
        int cnt = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0 && i != Math.sqrt(n)) {
                cnt += 2;
            } else if (n % i == 0) {
                cnt++;
            }
        }

        return cnt;
    }
}