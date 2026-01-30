import java.util.*;

class Solution {
    public int[] solution(String[] grid) {
        Coordinate[][] grids = new Coordinate[grid.length][grid[0].length()];

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                grids[i][j] = new Coordinate(String.valueOf(grid[i].charAt(j)));
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                while (!grids[i][j].isDone()) {
                    int cycle = 0;
                    Direction direction = grids[i][j].getRemainDirection();
                    grids[i][j].setOut(direction);
                    int x = i;
                    int y = j;
                    while (true) {
                        if (direction.equals(Direction.UP)) {
                            x--;
                            if (x == -1) x = grids.length - 1;
                        } else if (direction.equals(Direction.DOWN)) {
                            x++;
                            if (x == grids.length) x = 0;
                        } else if (direction.equals(Direction.LEFT)) {
                            y--;
                            if (y == -1) y = grids[0].length - 1;
                        } else {
                            y++;
                            if (y == grids[0].length) y = 0;
                        }

                        if (grids[x][y].inIsChecked(direction)) break;
                        else grids[x][y].setIn(direction);

                        direction = grids[x][y].nextDirection(direction);
                        cycle++;

                        if (grids[x][y].outIsChecked(direction)) break;
                        else grids[x][y].setOut(direction);
                    }

                    answer.add(cycle);
                }
            }
        }

        return answer.stream().sorted(Integer::compareTo).mapToInt(Integer::intValue).toArray();
    }

    public static class Coordinate {
        String name;
        Map<Direction, Boolean> in;
        Map<Direction, Boolean> out;

        public Coordinate(String name) {
            this.name = name;
            in = new HashMap<>(Map.of(Direction.UP, false,Direction.DOWN, false,Direction.LEFT, false,Direction.RIGHT, false));
            out = new HashMap<>(Map.of(Direction.UP, false,Direction.DOWN, false,Direction.LEFT, false,Direction.RIGHT, false));
        }

        public boolean isDone() {
            for (boolean b : out.values()) {
                if (!b) return false;
            }
            return true;
        }

        public Direction getRemainDirection() {
            for (Direction direction : out.keySet()) {
                if (!out.get(direction)) return direction;
            }
            return null;
        }

        public void setOut(Direction direction) {
            out.put(direction, true);
        }

        public void setIn(Direction direction) {
            in.put(direction, true);
        }

        public boolean inIsChecked(Direction direction) {
            return in.get(direction);
        }

        public boolean outIsChecked(Direction direction) {
            return out.get(direction);
        }

        public Direction nextDirection(Direction direction) {
            if (name.equals("S")) return direction;
            if (name.equals("L")) {
                if (direction.equals(Direction.UP)) return Direction.LEFT;
                if (direction.equals(Direction.DOWN)) return Direction.RIGHT;
                if (direction.equals(Direction.LEFT)) return Direction.DOWN;
                if (direction.equals(Direction.RIGHT)) return Direction.UP;
            }
            if (name.equals("R")) {
                if (direction.equals(Direction.UP)) return Direction.RIGHT;
                if (direction.equals(Direction.DOWN)) return Direction.LEFT;
                if (direction.equals(Direction.LEFT)) return Direction.UP;
                if (direction.equals(Direction.RIGHT)) return Direction.DOWN;
            }
            return null;
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
}