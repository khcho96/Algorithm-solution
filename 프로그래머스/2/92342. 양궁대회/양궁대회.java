import java.util.*;
import org.w3c.dom.Attr;

class Solution {

    public int[] answer;
    public int maxDiff = -1;

    public int[] solution(int n, int[] info) {
        answer = new int[info.length];
        int aPeachScore = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] > 0) aPeachScore += 10 - i;
        }
        func(n, new int[info.length], info, 0, aPeachScore, 0);

        if (maxDiff > 0) return answer;
        else return new int[]{-1};
    }

    private void func(int remain, int[] state, int[] info, int myScore, int aPeachScore, int start) {
        if (remain == 0) {
            if (maxDiff < myScore - aPeachScore) {
                maxDiff = myScore - aPeachScore;
                answer = Arrays.copyOf(state, state.length);
            } else if (maxDiff == myScore - aPeachScore && isAnswer(state)) {
                answer = Arrays.copyOf(state, state.length);
            }
            return;
        }

        for (int i = start; i < state.length; i++) {
            if (remain >= info[i] + 1) {
                state[i] = info[i] + 1;
                if (info[i] == 0) func(remain - state[i], state, info, myScore + 10 - i, aPeachScore, i + 1);
                else func(remain - state[i], state, info, myScore + 10 - i, aPeachScore - (10 - i), i + 1);
            } else if (i == state.length - 1) {
                state[i] = remain;
                func(remain - state[i], state, info, myScore, aPeachScore, i + 1);
            }
            state[i] = 0;
        }
    }

    private boolean isAnswer(int[] state) {
        int oldMinIndex = 0;
        int oldMaxValue = 0;
        for (int i = answer.length - 1; i >= 0; i--) {
            if (answer[i] > 0) {
                oldMinIndex = i;
                oldMaxValue = answer[i];
                break;
            }
        }

        int newMinIndex = 0;
        int newMaxValue = 0;
        for (int i = state.length - 1; i >= 0; i--) {
            if (state[i] > 0) {
                newMinIndex = i;
                newMaxValue = state[i];
                break;
            }
        }
        
        if (newMinIndex > oldMinIndex) return true;
        return newMinIndex == oldMinIndex && newMaxValue >= oldMaxValue;
    }
}
