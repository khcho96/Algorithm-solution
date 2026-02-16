import java.time.LocalTime;

class Solution {

    public String solution(String m, String[] musicinfos) {
        String newM = getNewString(m);
        String answer = "";
        int answerPlayTime = 0;

        for (String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");

            LocalTime start = LocalTime.parse(split[0]);
            LocalTime end = LocalTime.parse(split[1]);
            int playTime = (end.getHour() * 60 + end.getMinute()) - (start.getHour() * 60 + start.getMinute());
            String name = split[2];
            String melody = getMelody(split[3], playTime);

            if (melody.contains(newM) && answerPlayTime < playTime) {
                answerPlayTime = playTime;
                answer = name;
            }
        }

        if (answer.isBlank()) return "(None)";
        return answer;
    }

    private String getNewString(String s) {
        StringBuilder newString = new StringBuilder(",");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') continue;
            if (i == s.length() - 1) {
                newString.append(s.charAt(i));
                newString.append(",");
                break;
            }

            String substring = s.substring(i, i + 2);
            if (substring.matches("[A-Z]#")) newString.append("#");
            newString.append(s.charAt(i));
            newString.append(",");
        }
        return newString.toString();
    }

    private String getMelody(String s, int playTime) {
        int length = s.replaceAll("#", "").length();
        if (playTime <= length) return getNewString(getSubString(s, playTime));

        return (getNewString(s).repeat(playTime / length) + getNewString(getSubString(s, playTime % length))).replaceAll(",+", ",");
    }

    private String getSubString(String s, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (length > 0) {
            if (String.valueOf(s.charAt(index)).matches("[A-Z]")) stringBuilder.append(s.charAt(index++));
            if (index < s.length() && s.charAt(index) == '#') stringBuilder.append(s.charAt(index++));

            length--;
        }

        return stringBuilder.toString();
    }
}
