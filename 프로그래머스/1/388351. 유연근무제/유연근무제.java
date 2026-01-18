class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        for (int i = 0; i < timelogs.length; i++) {
            if (startday == 7) {
                timelogs[i][0] = 0;
                timelogs[i][6] = 0;
            } else {
                timelogs[i][6 - startday] = 0;
                timelogs[i][7 - startday] = 0;
            }
        }

        int answer = schedules.length;
        for (int i = 0; i < timelogs.length; i++) {
            int endTime;
            if (schedules[i] % 100 >= 50) {
                endTime = (schedules[i] / 100 + 1) * 100 + (schedules[i] % 10);
            } else {
                endTime = schedules[i] + 10;
            }
            for (int j = 0; j < timelogs[i].length; j++) {
                if (timelogs[i][j] != 0 && timelogs[i][j] > endTime) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
}