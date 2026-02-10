import java.time.*;
import java.util.*;

class Solution {
    public static String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int index = 0;

        List<Work> list = new ArrayList<>();
        for (String[] plan : plans) {
            list.add(new Work(plan[0], toMin(plan[1]), Integer.parseInt(plan[2])));
        }
        list.sort(Comparator.comparing(Work::getStart));

        Deque<Work> stack = new ArrayDeque<>();
        stack.addLast(list.remove(0));
        int cur = stack.peekLast().start;
        while (!stack.isEmpty() || !list.isEmpty()) {
            if (stack.isEmpty()) {
                cur = list.get(0).start;
                stack.addLast(list.remove(0));
            }
            else if (!list.isEmpty()) {
                while (!stack.isEmpty() && cur + stack.peekLast().playTime <= list.get(0).start) {
                    cur += stack.peekLast().playTime;
                    answer[index++] = stack.removeLast().name;
                }
                if (!stack.isEmpty()) stack.peekLast().playTime -= list.get(0).start - cur;

                cur = list.get(0).start;
                stack.addLast(list.remove(0));
            } else {
                while (!stack.isEmpty()) {
                    answer[index++] = stack.removeLast().name;
                }
            }
        }

        return answer;
    }

    private static int toMin(String s) {
        String[] split = s.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    public static class Work {
        String name;
        int start;
        int playTime;

        public Work(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }

        public int getStart() {
            return start;
        }
    }
}
