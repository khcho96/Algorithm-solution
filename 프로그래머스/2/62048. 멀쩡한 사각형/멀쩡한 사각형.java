class Solution {

    public long solution(int w, int h) {
        int newW = Math.min(w, h);
        int newH = Math.max(w, h);
        double inclination = newH / (double) newW * -1;

        long answer = 0;
        for (int x = 0; x < newW; x++) {
            int y1 = (int) Math.ceil(inclination * (x - newW) + newH);
            int y2 = (int) Math.floor(inclination * (x + 1 - newW) + newH);

            answer += y1 - y2;
        }
        return (long) w * h - answer;
    }
}
