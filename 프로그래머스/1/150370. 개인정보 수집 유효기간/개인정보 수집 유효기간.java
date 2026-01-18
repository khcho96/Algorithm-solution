import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayInt = Integer.parseInt(today.replace(".", ""));
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            map.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String date = privacies[i].split(" ")[0];
            int year = Integer.parseInt(date.split("\\.")[0]);
            int month = Integer.parseInt(date.split("\\.")[1]);
            int day = Integer.parseInt(date.split("\\.")[2]);
            int term = map.get(privacies[i].split(" ")[1]);

            int disposeDate = calculateDisposeDate(year, month, day, term);

            if (disposeDate <= todayInt) answer.add(i + 1);
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    
    public int calculateDisposeDate(int year, int month, int day, int term) {
        int newYear = year;
        int newMonth = month + term;
        if (month + term > 12 && (month + term) % 12 == 0) {
            newYear += (month + term - 1) / 12;
            newMonth = 12;
        } else if (month + term > 12 && (month + term) % 12 != 0) {
            newYear += (month + term) / 12;
            newMonth = (month + term) % 12;
        }

        return Integer.parseInt(String.format("%d%02d%02d", newYear, newMonth, day));
    }
}