import java.util.*;

class Solution {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        for (int move : moves) {
            int doll = getDoll(board, move);
            if (doll == 0) continue;

            if (!stack.isEmpty() && stack.peekLast() == doll) {
                answer += 2;
                stack.removeLast();
            } else {
                stack.addLast(doll);
            }
        }

        return answer;
    }

    private int getDoll(int[][] board, int move) {
        for (int[] ints : board) {
            if (ints[move - 1] != 0) {
                int temp = ints[move - 1];
                ints[move - 1] = 0;
                return temp;
            }
        }
        return 0;
    }
}
