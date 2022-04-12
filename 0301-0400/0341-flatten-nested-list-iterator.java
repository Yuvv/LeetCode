import java.util.*;

/*
 * 0341-flatten-nested-list-iterator.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/04/12
 */
public class NestedIterator implements Iterator<Integer> {

    private final LinkedList<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new LinkedList<>();
        if (nestedList != null && !nestedList.isEmpty()) {
            for (NestedInteger e : nestedList) {
                stack.addLast(e);
            }
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            NestedInteger ni = stack.pop();
            return ni.getInteger();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            NestedInteger ni = stack.pop();
            List<NestedInteger> niList = ni.getList();
            for (int i = niList.size() - 1; i >= 0; i--) {
                stack.addFirst(niList.get(i));
            }
        }
        return !stack.isEmpty();
    }

    public static void main(String[] args) {

        // []
        List<Integer> rl = new ArrayList<>();
        List<NestedInteger> niList = Collections.singletonList(new NestedIntegerImpl(new ArrayList<>(0)));
        NestedIterator nit = new NestedIterator(niList);
        while (nit.hasNext()) {
            rl.add(nit.next());
        }
        System.out.println(rl);
    }
}



// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}


class NestedIntegerImpl implements NestedInteger {
    private Integer val;
    private List<NestedInteger> list;

    public NestedIntegerImpl(Integer val) {
        this.val = val;
    }

    public NestedIntegerImpl(List<NestedInteger> list) {
        this.list = list;
    }

    @Override
    public boolean isInteger() {
        return val != null;
    }

    @Override
    public Integer getInteger() {
        return val;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}