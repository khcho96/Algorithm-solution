class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int x = 1; x <= number; x++) {
            answer += dividerCount(x) > limit ? power : dividerCount(x);
        }
        return answer;
    }
    
    public int dividerCount(int x) {
        int cnt = 0;
        for (int i = 1; i < Math.sqrt(x); i++) {
            if (x % i == 0) cnt += 2;
        }
        if ((int) Math.sqrt(x) * Math.sqrt(x) == x) cnt++;
        return cnt;
    }
}