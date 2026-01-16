class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        if (w >= 1 && board[h][w].equals(board[h][w - 1])) answer++;
        if (w < board.length - 1 && board[h][w].equals(board[h][w + 1])) answer++;
        if (h >= 1 && board[h][w].equals(board[h - 1][w])) answer++;
        if (h < board.length - 1 && board[h][w].equals(board[h + 1][w])) answer++;
        return answer;
    }
}