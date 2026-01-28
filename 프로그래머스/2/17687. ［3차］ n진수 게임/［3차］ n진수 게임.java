class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int cnt = 0;
        for (long j = 0; ; j++) {
            String string = Long.toString(j, n);
            for (int k = 0; k < string.length(); k++) {
                if ((cnt % m) + 1 == p) {
                    answer.append(string.charAt(k));
                }
                cnt++;
            }
            if (answer.length() >= t) {
                break;
            }
        }
        
        return answer.toString().toUpperCase().substring(0, t);
    }
}