class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String string : babbling) {
            String preMatch = "";
            while (true) {
                if (string.startsWith("aya") && !preMatch.equals("aya")) {
                    string = string.substring("aya".length());
                    preMatch = "aya";
                    continue;
                }

                if (string.startsWith("ye") && !preMatch.equals("ye")) {
                    string = string.substring("ye".length());
                    preMatch = "ye";
                    continue;
                }

                if (string.startsWith("woo") && !preMatch.equals("woo")) {
                    string = string.substring("woo".length());
                    preMatch = "woo";
                    continue;
                }

                if (string.startsWith("ma") && !preMatch.equals("ma")) {
                    string = string.substring("ma".length());
                    preMatch = "ma";
                    continue;
                }
                
                break;
            }
            if (string.isBlank()) {
                answer++;
            }
        }
        return answer;
    }
}
