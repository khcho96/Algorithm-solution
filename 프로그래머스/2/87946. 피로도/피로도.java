class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        for (int i = 0; i < dungeons.length; i++) {
            int depth = 0;
            boolean[] visit = new boolean[dungeons.length];
            answer = Math.max(answer, func(dungeons, i, k, depth + 1, visit));
        }
        return answer;
    }

    private int func(int[][] dungeons, int i, int remain, int depth, boolean[] visit) {
        if (dungeons[i][0] > remain) {
            return depth - 1;
        }

        visit[i] = true;
        int max = -1;
        boolean check = false;
        for (int j = 0; j < dungeons.length; j++) {
            if (!visit[j]) {
                check = true;
                max = Math.max(max, func(dungeons, j, remain - dungeons[i][1], depth + 1, visit));
            }
        }
        visit[i] = false;

        if (check) return max;
        return depth;
    }
}
