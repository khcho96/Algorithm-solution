class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 1;
        int x1 = 1;
        int x2 = 1;
        while (x1 <= n) {
            if (sum == n) {
                answer++;
                sum -= x1;
                x1++;
            } else if (sum > n) {
                sum -= x1;
                x1++;
            } else {
                x2++;
                sum += x2;
            }
        }
        return answer;
    }
}