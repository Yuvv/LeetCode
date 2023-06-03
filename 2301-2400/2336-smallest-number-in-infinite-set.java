import java.util.*;

/*
 * 2336-smallest-number-in-infinite-set.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/06/03
 */
class SmallestInfiniteSet {

    private TreeSet<Integer> set;

    public SmallestInfiniteSet() {
        this.set = new TreeSet<>();
        for (int i = 1; i <= 1000; i++) {
            this.set.add(i);
        }
    }

    public int popSmallest() {
        return this.set.pollFirst();
    }

    public void addBack(int num) {
        this.set.add(num);
    }

    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
        smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
        smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
        smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
        smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
        smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
                                           // is the smallest number, and remove it from the set.
        smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
        smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.

    }
}