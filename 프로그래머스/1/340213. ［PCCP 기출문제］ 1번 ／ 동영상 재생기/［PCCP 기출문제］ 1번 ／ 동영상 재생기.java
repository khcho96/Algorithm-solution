class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        for (String command : commands) {
            if (getInt(op_start) <= getInt(pos) && getInt(pos) < getInt(op_end)) {
                pos = op_end;
            }

            if (command.equals("next")) {
                int mm;
                int ss;
                if (getInt(pos) % 100 >= 50) {
                    mm = (getInt(pos) / 100) + 1;
                    ss = getInt(pos) % 10;
                } else {
                    mm = getInt(pos) / 100;
                    ss = getInt(pos) % 100 + 10;
                }
                pos = String.format("%02d:%02d", mm, ss);

                if (getInt(pos) >= getInt(video_len)) pos = video_len;
            } else {
                int mm;
                int ss;
                if (getInt(pos) % 100 < 10) {
                    mm = (getInt(pos) / 100) - 1;
                    ss = 50 + getInt(pos) % 10;
                } else {
                    mm = getInt(pos) / 100;
                    ss = getInt(pos) % 100 - 10;
                }

                if (mm < 0) pos = "00:00";
                else pos = String.format("%02d:%02d", mm, ss);
            }

            if (getInt(op_start) <= getInt(pos) && getInt(pos) < getInt(op_end)) {
                pos = op_end;
            }
        }
        return pos;
    }
    
    private static int getInt(String time) {
        return Integer.parseInt(time.replace(":", ""));
    }
}