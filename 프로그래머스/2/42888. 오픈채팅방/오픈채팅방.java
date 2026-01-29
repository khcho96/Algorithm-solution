import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<User> users = new ArrayList<>();
        List<String> order = new ArrayList<>();
        Map<String, String> msg = Map.of(
                "Enter", "님이 들어왔습니다.",
                "Leave", "님이 나갔습니다."
        );
        Map<String, User> userMap = new HashMap<>();
        for (String r : record) {
            if (r.split(" ")[0].equals("Enter")) {
                String uid = r.split(" ")[1];
                String name = r.split(" ")[2];

                User user;
                if (userMap.containsKey(uid)) {
                    user = userMap.get(uid);
                } else {
                    user = new User(uid);
                    userMap.put(uid, user);
                }

                user.setName(name);
                users.add(user);
                order.add(msg.get("Enter"));
            } else if (r.split(" ")[0].equals("Leave")) {
                users.add(userMap.get(r.split(" ")[1]));
                order.add(msg.get("Leave"));
            } else {
                userMap.get(r.split(" ")[1]).setName(r.split(" ")[2]);
            }
        }

        String[] answer = new String[order.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = users.get(i).name + order.get(i);
        }
        return answer;
    }

    public static class User {
        String uid;
        String name;

        public User(String uid) {
            this.uid = uid;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}