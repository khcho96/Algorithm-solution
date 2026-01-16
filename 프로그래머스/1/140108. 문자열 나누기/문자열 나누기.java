class Solution {
    public int solution(String s) {
        int answer = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        char c = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (cnt1 == 0 && cnt2 == 0) {
                c = s.charAt(i);
                cnt1++;
                answer++;
                continue;
            }

            if (s.charAt(i) == c) cnt1++;
            else cnt2++;


            if (cnt1 == cnt2) {
                cnt1 = cnt2 = 0;
            }
        }
        return answer;
    }
}