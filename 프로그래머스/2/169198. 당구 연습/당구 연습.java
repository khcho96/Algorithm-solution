import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for (int i = 0; i < answer.length; i++) {
            int x = balls[i][0];
            int y = balls[i][1];
            List<Integer> mins = new ArrayList<>();

            if (startX != x) {
                // 상
                int tempY = y + (n - y) * 2;
                mins.add(pow2(startX - x) + pow2(startY - tempY));
                // 하
                tempY = -1 * y;
                mins.add(pow2(startX - x) + pow2(startY - tempY));
            } else {
                if (startY < y) {
                    mins.add(pow2(startY + y));
                } else {
                    mins.add(pow2(2 * n - startY - y));
                }
            }

            if (startY != y) {
                // 좌
                int tempX = -1 * x;
                mins.add(pow2(startX - tempX)+ pow2(startY - y));
                // 우
                tempX = x + (m - x) * 2;
                mins.add(pow2(startX - tempX)+ pow2(startY - y));
            } else {
                if (startX < x) {
                    mins.add(pow2(startX + x));
                } else {
                    mins.add(pow2(2 * m - startX - x));
                }
            }

            answer[i] = mins.stream().min(Integer::compareTo).orElse(0);
        }
        return answer;
    }

    public static int pow2(int n) {
        return (int) Math.pow(n, 2);
    }
}