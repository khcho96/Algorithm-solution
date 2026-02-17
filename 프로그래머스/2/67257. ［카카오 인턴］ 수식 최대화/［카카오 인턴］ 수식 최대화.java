import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public long answer = 0;

    public long solution(String expression) {
        Deque<Long> numbers1 = Arrays.stream(expression.split("[+\\-*]")).map(Long::parseLong).collect(Collectors.toCollection(ArrayDeque::new));
        Deque<String> operators1 = Arrays.stream(expression.split("\\d+")).filter(s -> !s.isEmpty()).collect(Collectors.toCollection(ArrayDeque::new));
        String[] op = operators1.stream().distinct().toArray(String[]::new);

        boolean[] visited = new boolean[op.length];
        for (int i = 0; i < op.length; i++) {
            visited[i] = true;
            Deque<Long> originalNumbers = new ArrayDeque<>(numbers1);
            Deque<String> originalOperators = new ArrayDeque<>(operators1);
            func(op, visited, i, numbers1, operators1, new ArrayDeque<>(), new ArrayDeque<>());
            visited[i] = false;
            numbers1 = originalNumbers;
            operators1 = originalOperators;
        }

        return answer;
    }

    private void func(String[] op, boolean[] visited, int index, Deque<Long> numbers, Deque<String> operators, Deque<Long> newNumbers, Deque<String> newOperators) {
        while (!numbers.isEmpty() || !operators.isEmpty()) {
            if (!numbers.isEmpty()) {
                newNumbers.addLast(numbers.removeFirst());
            }

            if (!operators.isEmpty()) {
                String operator = operators.removeFirst();
                if (operator.equals(op[index])) {
                    long value;
                    if (operator.equals("+")) value = newNumbers.removeLast() + numbers.removeFirst();
                    else if (operator.equals("-")) value = newNumbers.removeLast() - numbers.removeFirst();
                    else value = newNumbers.removeLast() * numbers.removeFirst();
                    numbers.addFirst(value);
                }
                else {
                    newOperators.addLast(operator);
                }
            }
        }

        if (newNumbers.size() == 1) {
            answer = Math.max(answer, Math.abs(newNumbers.getFirst()));
            return;
        }

        for (int i = 0; i < op.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            Deque<Long> originalNumbers = new ArrayDeque<>(newNumbers);
            Deque<String> originalOperators = new ArrayDeque<>(newOperators);
            func(op, visited, i, newNumbers, newOperators, numbers, operators);
            visited[i] = false;
            newNumbers = originalNumbers;
            newOperators = originalOperators;
        }
    }
}
