class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ('a' <= c && c <= 'z') {
                answer.append((char) ((c + n - 'a') % ('z' - 'a' + 1) + 'a'));
            } else if ('A' <= c && c <= 'Z') {
                answer.append((char) ((c + n - 'A') % ('Z' - 'A' + 1) + 'A'));
            } else {
                answer.append(" ");
            }
        }
        return answer.toString();
    }
}