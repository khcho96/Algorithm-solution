import java.util.*;

class Solution {

    public int[] dr = new int[]{-1, 1, 0, 0, -1, -1, 1, 1, -2, 2, 0, 0};
    public int[] dc = new int[]{0, 0, 1, -1, -1, 1, -1, 1, 0, 0, -2, 2};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) answer[i] = func(places[i]);
        return answer;
    }

    private int func(String[] place) {
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[0].length(); j++) {
                if (place[i].charAt(j) != 'P') continue;

                // 상하좌우
                for (int k = 0; k < 4; k++) {
                    if (i + dr[k] >= 0 && i + dr[k] < place.length && j + dc[k] >= 0 && j + dc[k] < place.length) {
                        if (place[i + dr[k]].charAt(j + dc[k]) == 'P') return 0;
                    }
                }

                // 대각선
                for (int k = 4; k < 8; k++) {
                    if (i + dr[k] >= 0 && i + dr[k] < place.length && j + dc[k] >= 0 && j + dc[k] < place.length) {
                        if ((place[i + dr[k]].charAt(j) != 'X' || place[i].charAt(j + dc[k]) != 'X') && place[i + dr[k]].charAt(j + dc[k]) == 'P') return 0;
                    }
                }
                
                // 상하좌우 2칸 간격
                for (int k = 8; k < 12; k++) {
                    if (i + dr[k] >= 0 && i + dr[k] < place.length && j + dc[k] >= 0 && j + dc[k] < place.length) {
                        if (place[i + dr[k] / 2].charAt(j + dc[k] / 2) != 'X' && place[i + dr[k]].charAt(j + dc[k]) == 'P') return 0;
                    }
                }
            }
        }

        return 1;
    }
}
