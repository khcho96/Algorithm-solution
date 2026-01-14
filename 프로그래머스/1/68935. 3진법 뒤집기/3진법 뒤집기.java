class Solution {
    public int solution(int n) {
        long origin3 = 0;
        int digit = 0;
        for (int i = 0; n > 0; i++) {
            origin3 += (n % 3) * (long) Math.pow(10, i);
            n /= 3;
            digit++;
        }

        int answer = 0;
        for (int i = digit - 1; i >= 0; i--) {
            answer += (int) (origin3 % 10) * (int) Math.pow(3, i);
            origin3 /= 10;
        }
        return answer;
    }
}