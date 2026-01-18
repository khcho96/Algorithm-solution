import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> map = Map.of(
                "code", 0,
                "date", 1,
                "maximum", 2,
                "remain", 3
        );

        List<Data> list = new ArrayList<>();
        for (int[] datum : data) {
            if (datum[map.get(ext)] < val_ext) {
                list.add(new Data(datum));
            }
        }

        list.sort(Comparator.comparingInt(d -> d.getData(map.get(sort_by))));

        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            int[] ints = list.get(i).getInts();
            answer[i] = ints;
        }
        
        return answer;
    }
    
    public class Data {
        int[] ints;

        public Data(int[] ints) {
            this.ints = ints;
        }

        public int getData(int index) {
            return ints[index];
        }

        public int[] getInts() {
            return ints;
        }
    }
}