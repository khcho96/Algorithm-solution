import java.util.*;

class Solution {

    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        List<Boolean> list = new ArrayList<>();
        List<String> ids = new ArrayList<>();
        for (String s : record) {
            String[] split = s.split(" ");

            if (split[0].equals("Enter")) {
                map.put(split[1], split[2]);
                ids.add(split[1]);
                list.add(true);
            } else if (split[0].equals("Leave")){
                ids.add(split[1]);
                list.add(false);
            } else {
                map.put(split[1], split[2]);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)) {
                answer.add(map.get(ids.get(i)) + "님이 들어왔습니다.");
            } else {
                answer.add(map.get(ids.get(i)) + "님이 나갔습니다.");
            }
        }

        return answer.toArray(String[]::new);
    }
}
