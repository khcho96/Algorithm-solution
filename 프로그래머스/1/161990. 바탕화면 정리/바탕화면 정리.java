class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = wallpaper.length;
        int luy = wallpaper[0].length();
        int rdx = 0;
        int rdy = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            int sIndex = wallpaper[i].indexOf("#");
            int eIndex = wallpaper[i].lastIndexOf("#") + 1;
            if (sIndex == -1) {
                continue;
            }

            if (luy > sIndex) luy = sIndex;
            if (rdy < eIndex) rdy = eIndex;

            if (lux == wallpaper.length) lux = i;
            rdx = i + 1;
        }

        return new int[]{lux, luy, rdx, rdy};
    }
}