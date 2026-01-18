import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int move : moves) {
            int doll = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    doll = board[i][move - 1];
                    board[i][move - 1] = 0;
                    break;
                }
            }
            if (!deque.isEmpty()) {
                if (deque.peekFirst() == doll) {
                    deque.removeFirst();
                    answer += 2;
                } else {
                    deque.addFirst(doll);
                }
            } else if (doll != 0) {
                deque.addFirst(doll);
            }
        }
        return answer;
    }
}