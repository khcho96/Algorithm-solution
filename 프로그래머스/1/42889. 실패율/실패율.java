import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int N, int[] stages) {
        List<Stage> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(new Stage(i));
        }

        List<Integer> list1 = Arrays.stream(stages)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int sum = 0;
        for (int i = 0; i < list1.size();) {
            int frequency = Collections.frequency(list1, list1.get(i));
            sum += frequency;
            if (list1.get(i) <= N) {
                list.get(list1.get(i) - 1).setFailRate(frequency / (double) sum);
            }
            i += frequency;
        }
        return list.stream()
                .sorted(Comparator.comparingDouble(Stage::getFailRate).reversed().thenComparingInt(Stage::getStage))
                .map(Stage::getStage)
                .mapToInt(Integer::intValue)
                .toArray();
    }
    
    public class Stage {
        public int stage;
        public double failRate = 0;

        Stage(int stage) {
            this.stage = stage;
        }

        public int getStage() {
            return stage;
        }

        public double getFailRate() {
            return failRate;
        }

        public void setFailRate(double failRate) {
            this.failRate = failRate;
        }
    }
}