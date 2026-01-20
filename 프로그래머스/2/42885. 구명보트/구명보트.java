import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int i1 = 0;
        int i2 = people.length - 1;
        int last = people.length - 1;
        int sum;
        while (i1 <= i2) {
            if (i1 == i2) {
                sum = people[i1];
            } else {
                sum = people[i1] + people[i2];
            }
            while (sum > limit) {
                i2--;
                if (i1 == i2) {
                    sum = people[i1];
                } else {
                    sum = people[i1] + people[i2];
                }
            }

            answer += 1 + (last - i2);
            i1++;
            i2--;
            last = i2;
        }
        return answer;
    }
}