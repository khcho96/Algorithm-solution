import java.util.*;

class Solution {

    public int solution(String dirs) {
        int answer = 0;

        Set<Set<Coordinate>> set = new HashSet<>();

        int x = 0, y = 0;
        for (String dir : dirs.split("")) {
            if (dir.equals("U") && y + 1 <= 5) {
                Set<Coordinate> coordinates = Set.of(new Coordinate(x, y), new Coordinate(x, y + 1));
                if (!set.contains(coordinates)) answer++;
                set.add(coordinates);
                y++;
            } else if (dir.equals("D") && y - 1 >= -5) {
                Set<Coordinate> coordinates = Set.of(new Coordinate(x, y), new Coordinate(x, y - 1));
                if (!set.contains(coordinates)) answer++;
                set.add(coordinates);
                y--;
            } else if (dir.equals("L") && x - 1 >= -5) {
                Set<Coordinate> coordinates = Set.of(new Coordinate(x, y), new Coordinate(x - 1, y));
                if (!set.contains(coordinates)) answer++;
                set.add(coordinates);
                x--;
            } else if (dir.equals("R") && x + 1 <= 5){
                Set<Coordinate> coordinates = Set.of(new Coordinate(x, y), new Coordinate(x + 1, y));
                if (!set.contains(coordinates)) answer++;
                set.add(coordinates);
                x++;
            }
        }

        return answer;
    }

    public class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object object) {
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            Coordinate that = (Coordinate) object;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
