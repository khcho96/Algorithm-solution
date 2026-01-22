class Solution {
    public int[] solution(int n, long left, long right) {
        int[] arr = new int[(int) (right - left) + 1];
        int startI = (int) (left / n);
        int startJ = (int) (left % n);
        int endI = (int) (right / n);
        int endJ = (int) (right % n);

        int index = 0;
        for (int i = startI; i <= endI; i++) {
            if (i == startI) {
                if (startI == endI) {
                    int minJ = Math.min(startJ, endJ);
                    int maxJ = Math.max(startJ, endJ);

                    if (minJ < i + 1 && maxJ < i + 1) {
                        for (int j = minJ; j <= maxJ; j++) {
                            arr[index++] = i + 1;
                        }
                    } else if (minJ < i + 1 && maxJ >= i + 1) {
                        for (int j = minJ; j < i + 1; j++) {
                            arr[index++] = i + 1;
                        }
                        for (int j = i + 1; j <= maxJ; j++) {
                            arr[index++] = j + 1;
                        }
                    } else {
                        for (int j = minJ; j <= maxJ; j++) {
                            arr[index++] = j + 1;
                        }
                    }
                } else {
                    if (startJ < i + 1) {
                        for (int j = startJ; j < i + 1; j++) {
                            arr[index++] = i + 1;
                        }
                        for (int j = i + 1; j < n; j++) {
                            arr[index++] = j + 1;
                        }
                    } else {
                        for (int j = startJ; j < n; j++) {
                            arr[index++] = j + 1;
                        }
                    }
                }
            } else if (i == endI) {
                if (endJ < i + 1) {
                    for (int j = 0; j <= endJ; j++) {
                        arr[index++] = i + 1;
                    }
                } else {
                    for (int j = 0; j < i + 1; j++) {
                        arr[index++] = i + 1;
                    }
                    for (int j = i + 1; j <= endJ; j++) {
                        arr[index++] = j + 1;
                    }
                }
            } else {
                for (int j = 0; j < i + 1; j++) {
                    arr[index++] = i + 1;
                }
                for (int j = i + 1; j < n; j++) {
                    arr[index++] = j + 1;
                }
            }
        }
        return arr;
    }
}