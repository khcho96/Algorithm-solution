class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;

        final int CYCLE = 3600 * 12;
        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;

        int oldS = (start * 720) % CYCLE;
        int oldM = (start * 12) % CYCLE;
        int oldH = start % CYCLE;
        if (oldS == oldH && oldS == oldM) answer++;
        else if (oldS == oldH) answer++;
        else if (oldS == oldM) answer++;
        for (int i = start + 1; i <= end; i++) {
            int newS = (i * 720) % CYCLE;
            int newM = (i * 12) % CYCLE;
            int newH = i % CYCLE;

            if (oldS < oldH && newS == newH && oldS < oldM && newS == newM) answer++;
            else {
                if (oldS < oldH && (newS >= newH || newS == 0)) answer++;
                if (oldS < oldM && (newS >= newM || newS == 0)) answer++;
            }

            oldS = newS;
            oldM = newM;
            oldH = newH;
        }
        return answer;
    }
}