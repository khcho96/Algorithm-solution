import java.util.*;

class Solution {

    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        List<Level> levels = new ArrayList<>();
        for (int i = 0; i <= N; i++) levels.add(new Level(i, 0));
        int curLevel = stages[0];
        int curLevelIndex = 0;
        for (int i = 1; i < stages.length; i++) {
            if (curLevel < stages[i]) {
                levels.get(curLevel).faliRate = (i - curLevelIndex) / (double) (stages.length - curLevelIndex) * 100;
                curLevel = stages[i];
                curLevelIndex = i;
            } else if (i == stages.length - 1) {
                levels.get(curLevel).faliRate = 100.0;
            }

            if (curLevel > N) break;
        }

        levels.remove(0);
        return levels.stream().sorted(Comparator.comparing(Level::getFaliRate).reversed()).map(Level::getLevel).mapToInt(Integer::intValue).toArray();
    }

    public class Level {
        double faliRate;
        int level;

        public Level(int level, double faliRate) {
            this.level = level;
            this.faliRate = faliRate;
        }

        public int getLevel() {
            return level;
        }

        public double getFaliRate() {
            return faliRate;
        }
    }
}
