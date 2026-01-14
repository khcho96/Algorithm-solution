class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            
            if (c.isBlank()) {
                cnt = 0;
                answer.append(" ");
                continue;
            }

            if (cnt % 2 == 0) {
                answer.append(c.toUpperCase());
                cnt++;
            } else {
                answer.append(c.toLowerCase());
                cnt++;
            }
        }
        
        return answer.toString();
    }
}