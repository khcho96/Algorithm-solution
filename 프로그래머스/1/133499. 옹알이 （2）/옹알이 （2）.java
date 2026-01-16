class Solution {
    public int solution(String[] babbling) {
        String[] possible = new String[]{"aya", "ye", "woo", "ma"};
        int answer = 0;
        for (String string : babbling) {
            String preMatch = "";
            while (true) {
                String temp = preMatch;
                for (int i = 0; i < 4; i++) {
                    if (string.startsWith(possible[i]) && !preMatch.equals(possible[i])) {
                        string = string.substring(possible[i].length());
                        preMatch = possible[i];
                        break;
                    }
                }

                if (string.isBlank() || preMatch.equals(temp)) {
                    break;
                }
            }
            if (string.isBlank()) {
                answer++;
            }
        }
        return answer;
    }
}
