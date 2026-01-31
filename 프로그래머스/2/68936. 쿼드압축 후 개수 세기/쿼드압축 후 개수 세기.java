import java.util.*;

class Solution {
    public int[] solution(int[][] arr) {
        int size = arr.length;
        List<Integer> list = func(arr, size, 0, 0);
        
        int[] answer = new int[]{Collections.frequency(list, 0), Collections.frequency(list, 1)};
        return answer;
    }

    private static List<Integer> func(int[][] arr, int size, int i, int j) {
        if (size == 1) return new ArrayList<>(List.of(arr[i][j]));

        size /= 2;

        List<Integer> list1 = func(arr, size, i, j);
        List<Integer> list2 = func(arr, size, i + size, j);
        List<Integer> list3 = func(arr, size, i, j + size);
        List<Integer> list4 = func(arr, size, i + size, j + size);

        if (list1.equals(List.of(0)) && list2.equals(List.of(0)) && list3.equals(List.of(0)) && list4.equals(List.of(0))) {
            return new ArrayList<>(List.of(0));
        }

        if (list1.equals(List.of(1)) && list2.equals(List.of(1)) && list3.equals(List.of(1)) && list4.equals(List.of(1))) {
            return new ArrayList<>(List.of(1));
        }

        ArrayList<Integer> answer = new ArrayList<>();
        answer.addAll(list1);
        answer.addAll(list2);
        answer.addAll(list3);
        answer.addAll(list4);

        return answer;
    }
}