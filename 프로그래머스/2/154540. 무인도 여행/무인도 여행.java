import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();

        boolean[][] visit = new boolean[maps.length][maps[0].length()];

        for (int x = 0; x < maps.length; x++) {
            for (int y = 0; y < maps[0].length(); y++) {
                if (maps[x].charAt(y) != 'X' && !visit[x][y]) {
                    int count = dfs(x, y, visit, maps);

                    answer.add(count);
                }
            }
        }

        if (answer.isEmpty()) {
            return new int[]{-1};
        }
        return answer.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    private static int dfs(int x, int y, boolean[][] visit, String[] maps) {
        int count = Integer.parseInt(String.valueOf(maps[x].charAt(y)));
        visit[x][y] = true;

        if (x - 1 >= 0 && maps[x - 1].charAt(y) != 'X' && !visit[x - 1][y]) { // 상
            count += dfs(x - 1, y, visit, maps);
        }
        if (x + 1 < maps.length && maps[x + 1].charAt(y) != 'X' && !visit[x + 1][y]) { // 하
            count += dfs(x + 1, y, visit, maps);
        }
        if (y - 1 >= 0 && maps[x].charAt(y - 1) != 'X' && !visit[x][y - 1]) { // 좌
            count += dfs(x, y - 1, visit, maps);
        }
        if (y + 1 < maps[0].length() && maps[x].charAt(y + 1) != 'X' && !visit[x][y + 1]) { // 우
            count += dfs(x, y + 1, visit, maps);
        }

        return count;
    }
}
