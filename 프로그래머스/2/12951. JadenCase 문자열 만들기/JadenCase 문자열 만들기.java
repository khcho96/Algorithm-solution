class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean reset = true;
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (reset && !c.isBlank()) {
                reset = false;
                c = c.toUpperCase();
            } else if (c.isBlank()) {
                reset = true;
            } else {
                c = c.toLowerCase();
            }

            answer.append(c);
        }
        return answer.toString();
    }
}