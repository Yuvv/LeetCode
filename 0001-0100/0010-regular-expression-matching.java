class State {
    static char START = '^';
    static char END = '$';

    char val;
    List<State> nextList;

    public State(char _val) {
        val = _val;
        nextList = new ArrayList<>();
    }

    public boolean matchStringFrom(String s, int index) {
        if (index >= s.length()) {
            for (State state : nextList) {
                if (state.val == State.END) {
                    return true;
                }
            }
            return false;
        }
        for (State state : nextList) {
            if (state.val == '.' || state.val == s.charAt(index)) {
                if (state.matchStringFrom(s, index + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addNext(State s) {
        nextList.add(s);
    }
}

class Solution {
    /**
     * 构建状态机完成
     * https://leetcode.com/problems/regular-expression-matching/description/
     */
    public boolean isMatch(String s, String p) {
        State state = buildStateMachine(p);
        return state.matchStringFrom(s, 0);
    }

    State buildStateMachine(String p) {
        State start = new State(State.START);
        State end = new State(State.END);
        int pLen = p.length();
        Map<Integer, State> map = new HashMap<>();
        map.put(-1, start);
        for (int i = 0; i < pLen; i++) {
            if (p.charAt(i) != '*') {
                map.put(i, new State(p.charAt(i)));
            }
        }

        int i;
        for (Map.Entry<Integer, State> entry : map.entrySet()) {
            State curState = entry.getValue();
            for (i = entry.getKey() + 1; i < pLen; i++) {
                if (p.charAt(i) == '*') {
                    curState.addNext(curState);
                } else {
                    curState.addNext(map.get(i));
                    if (i < pLen - 1) {
                        if (p.charAt(i + 1) != '*') {
                            break;
                        } else {
                            i++; // 跳过 '*'
                        }
                    } else if (i == pLen - 1) {
                        break;  // 跳过倒数第二个
                    }
                }
            }
            // 走到了最后
            if (i >= pLen) {
                curState.addNext(end);
            }
        }

        return start;
    }
}