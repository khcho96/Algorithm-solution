class Solution {
    public int solution(String s) {
        if (s.contains("-")) {
            return Integer.parseInt(s.replace("-", "")) * -1;
        }

        if (s.contains("+")) {
            return Integer.parseInt(s.replace("+", ""));
        }

        return Integer.parseInt(s);
    }
}