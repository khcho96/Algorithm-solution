class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (long i = 0; i <= (long) d; i += (long) k) {
            answer += (long) Math.sqrt((long) d * (long) d - i * i) / (long) k + 1;
        }
        
        return answer;
    }
}