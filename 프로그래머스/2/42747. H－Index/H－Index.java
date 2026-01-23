import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int answer = -1;
        int cur = -1;
        for (int i = 0; i < citations.length; i++) {
            if (cur != citations[i]) {
                cur = citations[i];
                if (citations[i] <= citations.length - i) {
                    answer = citations[i];
                } else if (answer < citations.length - i) {
                    answer = citations.length - i;
                }
            }
        }
        
        return answer;
    }
}