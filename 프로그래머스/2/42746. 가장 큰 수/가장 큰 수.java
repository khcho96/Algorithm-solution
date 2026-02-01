import java.util.*;

class Solution {

    public static String solution(int[] numbers) {
        String[] strings = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(strings, (a, b) -> (b + a).compareTo(a + b));
        
        if (strings[0].equals("0")) return "0";
        return String.join("", strings);
    }
}

/*
** AI 사용해서 해결함 **
1. 두 문자열 a, b 를 비교할때 a + b랑 b + a를 비교하면 되는데 그 부분을 생각 못해서 AI 도움을 받음.
2. [0,0,0]인 케이스(맨 앞이 0이 오는 경우) : 0을 반환하는 것 생각 못함.
*/