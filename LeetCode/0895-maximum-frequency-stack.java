/**
 * 实现一个最频繁数据栈（最主要的是`stackMap`结构，详见注释）
 * https://leetcode.com/problems/maximum-frequency-stack/description/
 */
class FreqStack {

    /**
     * 计数 map，记录每个元素出现次数
     */
    private Map<Integer, Integer> counterMap;

    /**
     * 栈 map，每种次数都有一个栈，当 x 添加进来时会被添加到该计数的栈里面（会被重复添加）
     */
    private Map<Integer, LinkedList<Integer>> stackMap;

    /**
     * 最大计数
     */
    private int maxCount;

    public FreqStack() {
        stackMap = new HashMap<>();
        counterMap = new HashMap<>();
        maxCount = 0;
    }

    public void push(int x) {
        int curCount = counterMap.getOrDefault(x, 0) + 1;
        if (curCount > maxCount) {
            maxCount = curCount;
        }
        counterMap.put(x, curCount);
        if (!stackMap.containsKey(curCount)) {
            stackMap.put(curCount, new LinkedList<>());
        }
        stackMap.get(curCount).push(x);
    }

    public int pop() {
        int x = stackMap.get(maxCount).pop();
        counterMap.put(x, maxCount - 1);
        if (stackMap.get(maxCount).isEmpty()) {
            maxCount--;
        }
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */