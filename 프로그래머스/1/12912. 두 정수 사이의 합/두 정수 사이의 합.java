class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        for(int x = a; x <= b; x++) {
            answer += x;
        }
        
        return answer;
    }
}