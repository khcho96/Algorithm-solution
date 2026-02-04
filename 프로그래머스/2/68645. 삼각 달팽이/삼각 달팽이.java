import java.util.*;

class Solution {
    public int[] solution(int n) {
        int size = n * (n + 1) / 2;
        int[] answer = new int[size];

        int floor = 1;
        int index = 1;
        boolean[] visit = new boolean[size + 1];
        for (int i = 1; i <= size; i++) {
            visit[index] = true;
            answer[index - 1] = i;

            if (index + floor <= size && 1 <= index - floor && index + 1 <= size && !visit[index + floor] && !visit[index + 1] && !visit[index - floor]) { // 하, 상, 우 -> 하
                index += floor;
                floor++;
            } else if (1 <= index - floor && index + 1 <= size && !visit[index - floor] && !visit[index + 1]) { // 상, 우 -> 우
                index++;
            } else if (1 <= index - floor && index + floor <= size && !visit[index - floor] && !visit[index + floor]) { // 상, 하 -> 상
                index -= floor;
                floor--;
            } else if (index + 1 <= size && index + floor <= size && !visit[index + 1] && !visit[index + floor]) { // 우, 하 -> 하
                index += floor;
                floor++;
            } else if (index + floor <= size && !visit[index + floor]) { // 하
                index += floor;
                floor++;
            } else if (1 <= index - floor && !visit[index - floor]) { // 상
                index -= floor;
                floor--;
            } else if (index + 1 <= size && !visit[index + 1]) { // 우
                index++;
            }
        }

        return answer;
    }
}