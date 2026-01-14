class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int l = n < m ? n : m;
        for (int i = 1; i <= l; i++) {
            if (n % i == 0 && m % i == 0) {
                answer[0] = i;
            }
        }
        
        l = n > m ? n : m;
        for (int i = l;;i += l) {
            if (i % n == 0 && i % m == 0) {
                answer[1] = i;
                break;
            }
        }
        
        return answer;
    }
}