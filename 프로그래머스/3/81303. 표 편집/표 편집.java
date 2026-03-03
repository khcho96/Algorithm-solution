import java.util.*;

class Solution {

    public String solution(int n, int k, String[] cmd) {
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];
        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }
        k++;

        Deque<Integer> stack = new ArrayDeque<>();
        for (String cm : cmd) {
            if (cm.charAt(0) == 'D') {
                String[] s = cm.split(" ");
                int x = Integer.parseInt(s[1]);
                for (int i = 0; i < x; i++) k = down[k];
            } else if (cm.charAt(0) == 'U') {
                String[] s = cm.split(" ");
                int x = Integer.parseInt(s[1]);
                for (int i = 0; i < x; i++) k = up[k];
            } else if (cm.charAt(0) == 'C') {
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                stack.addLast(k);
                if (down[k] > n) k = up[k];
                else k = down[k];
            } else {
                Integer removed = stack.removeLast();
                up[down[removed]] = removed;
                down[up[removed]] = removed;
            }
        }

        char[] answer = new char[n];
        Arrays.fill(answer, 'O');

        for (Integer i : stack) {
            answer[i - 1] = 'X';
        }

        return new String(answer);
    }
}
