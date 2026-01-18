import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
       List<Integer> list = new ArrayList<>(List.of(10, 10));
        int[][] distance = new int[][]{
                {0, 3, 2, 1}, // 0
                {4, 1, 2, 3}, // 1
                {3, 0, 1, 2}, // 2
                {4, 1, 2, 3}, // 3
                {3, 2, 1, 2}, // 4
                {2, 1, 0, 1}, // 5
                {3, 2, 1, 2}, // 6
                {2, 3, 2, 1}, // 7
                {1, 2, 1, 0}, // 8
                {2, 3, 2, 1}, // 9
                {1, 4, 3, 2}, // *,#
        };
        List<Integer> mid = List.of(0, 2, 5, 8);
        int mainHand = hand.equals("right") ? 1 : 0;
        String[] hands = new String[]{"L", "R"};

        StringBuilder answer = new StringBuilder();
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                list.set(0, number);
                answer.append(hands[0]);
            } else if (number == 3 || number == 6 || number == 9) {
                list.set(1, number);
                answer.append(hands[1]);
            } else {
                int leftDis = distance[list.get(0)][mid.indexOf(number)];
                int rightDis = distance[list.get(1)][mid.indexOf(number)];
                if (leftDis < rightDis) {
                    list.set(0, number);
                    answer.append(hands[0]);
                } else if (leftDis > rightDis) {
                    list.set(1, number);
                    answer.append(hands[1]);
                } else {
                    list.set(mainHand, number);
                    answer.append(hands[mainHand]);
                }
            }
        }
        return answer.toString();
    }
}