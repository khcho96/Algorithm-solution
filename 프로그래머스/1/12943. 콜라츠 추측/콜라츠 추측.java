class Solution {
    public int solution(int num) {
        int answer = 0;
        long number = (long) num;
        
        if (number == 1) return 0;
        
        for (int i = 1; i <= 500; i++) {
            if (number % 2 == 0) number /= 2;
            else number = number * 3 + 1;
            
            answer++;
            System.out.println(answer + " : " + num);
            if (number == 1) break;
        }
        
        if (number != 1) return -1;
        
        return answer;
    }
}