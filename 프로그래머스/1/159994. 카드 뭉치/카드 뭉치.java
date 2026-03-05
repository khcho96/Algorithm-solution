class Solution {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int i1 = 0, i2 = 0, gi = 0;

        while (gi < goal.length) {
            if (i1 < cards1.length && cards1[i1].equals(goal[gi])) {
                i1++;
                gi++;
            } else if (i2 < cards2.length && cards2[i2].equals(goal[gi])) {
                i2++;
                gi++;
            } else return "No";
        }

        return "Yes";
    }
}
