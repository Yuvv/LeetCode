import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

/*
 * 0284-peeking-iterator.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/21
 */
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> it;
    private Integer next;

    // Java Iterator interface reference:
    // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    it = iterator;
        next = null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (next != null) {
            return next;
        }
        if (it.hasNext()) {
            next = it.next();
        }
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (next != null) {
            Integer toReturn = next;
            next = null;
            return toReturn;
        }
        if (it.hasNext()) {
            return it.next();
        }
        return next;
	}

	@Override
	public boolean hasNext() {
	    if (next != null) {
            return true;
        }
        return it.hasNext();
	}
}

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        PeekingIterator peekingIterator = new PeekingIterator(list.iterator()); // [1,2,3]
        System.out.println(peekingIterator.next());    // return 1, the pointer moves to the next element [1,2,3].
        System.out.println(peekingIterator.peek());    // return 2, the pointer does not move [1,2,3].
        System.out.println(peekingIterator.next());    // return 2, the pointer moves to the next element [1,2,3]
        System.out.println(peekingIterator.next());    // return 3, the pointer moves to the next element [1,2,3]
        System.out.println(peekingIterator.hasNext()); // return False
    }
}