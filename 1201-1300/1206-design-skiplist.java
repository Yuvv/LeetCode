import java.util.Random;

class ListNode {
    int val;
    ListNode next;
    transient ListNode[] group;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Skiplist {

    static final int MAX_LEVEL = 16;

    private ListNode[] headGroup;
    private final Random random;

    public Skiplist() {
        random = new Random(System.currentTimeMillis());
    }

    private ListNode[] buildNewGroup(int num) {
        return buildNewGroup(num, random.nextInt(MAX_LEVEL) + 1);
    }

    private ListNode[] buildNewGroup(int num, int level) {
        ListNode[] group = new ListNode[level];
        for (int i = 0; i < level; i++) {
            group[i] = new ListNode(num);
            group[i].group = group;
        }
        return group;
    }

    public boolean search(int target) {
        if (headGroup == null) {
            return false;
        }
        int level = MAX_LEVEL - 1;
        ListNode cursor = headGroup[level];
        if (cursor.val > target) {
            return false;
        } else if (cursor.val == target) {
            return true;
        }
        // cursor.val < target
        while (cursor != null && level >= 0) {
            if (cursor.next == null || cursor.next.val > target) {
                level--;
                if (level >= 0) {
                    cursor = cursor.group[level];
                } else {
                    cursor = null;
                }
            } else if (cursor.next.val < target) {
                cursor = cursor.next;
            } else {
                // cursor.next.val == target
                return true;
            }
        }
        return false;
    }

    public void add(int num) {
        if (headGroup == null) {
            headGroup = buildNewGroup(num, MAX_LEVEL);
            return;
        }
        if (num <= headGroup[0].val) {
            int oldVal = headGroup[0].val;
            for (int i = 0; i < MAX_LEVEL; i++) {
                headGroup[i].val = num;
            }
            // link group
            ListNode[] nGroup = buildNewGroup(num, random.nextInt(MAX_LEVEL) + 1);
            for (int i = 0; i < nGroup.length; i++) {
                nGroup[i].val = oldVal;
                nGroup[i].next = headGroup[i].next;
                headGroup[i].next = nGroup[i];
            }
        } else {
            int level = MAX_LEVEL - 1;
            ListNode cursor = headGroup[level];
            // at the beginning, cursor.val < num
            while (level >= 0) {
                if (cursor.next == null || cursor.next.val > num) {
                    level--;
                    if (level >= 0) {
                        cursor = cursor.group[level];
                    }
                } else if (cursor.next.val < num) {
                    cursor = cursor.next;
                } else {
                    // cursor.next.val == target, insert after
                    cursor = cursor.next;
                    break;
                }
            }
            // cursor nerve be null
            ListNode[] cursorGroup = cursor.group;
            ListNode[] nGroup = buildNewGroup(num, cursorGroup.length);
            for (int i = 0; i < nGroup.length; i++) {
                nGroup[i].next = cursorGroup[i].next;
                cursorGroup[i].next = nGroup[i];
            }
        }
    }

    public boolean erase(int num) {
        if (headGroup == null) {
            return false;
        }
        if (headGroup[0].val > num) {
            return false;
        }
        // replace first if first one hits
        if (headGroup[0].val == num) {
            if (headGroup[0].next == null) {
                headGroup = null;
                return true;
            }
            ListNode[] nextGroup = headGroup[0].next.group;
            int nextVal = nextGroup[0].val;
            int nextLevel = nextGroup.length;
            for (int i = 0; i < MAX_LEVEL; i++) {
                headGroup[i].val = nextVal;
                if (i < nextLevel) {
                    headGroup[i].next = nextGroup[i].next;
                }
            }
            return true;
        }

        int level = MAX_LEVEL - 1;
        ListNode cursor = headGroup[level];
        // cursor.val < num
        while (cursor != null && level >= 0) {
            if (cursor.next == null || cursor.next.val > num) {
                level--;
                if (level >= 0) {
                    cursor = cursor.group[level];
                } else {
                    cursor = null;
                }
            } else if (cursor.next.val < num) {
                cursor = cursor.next;
            } else {
                // cursor.next.val == target
                ListNode[] targetGroup = cursor.next.group;
                while (cursor != null && level >= 0) {
                    cursor.next = cursor.next.next;
                    level--;
                    if (level >= 0) {
                        cursor = cursor.group[level];
                        while (cursor.next.group != targetGroup) {
                            cursor = cursor.next;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}

public class Solution  {

    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        System.out.println(skiplist.search(0)); // return False
        skiplist.add(4);
        System.out.println(skiplist.search(1)); // return True
        System.out.println(skiplist.erase(0));  // return False, 0 is not in skiplist.
        System.out.println(skiplist.erase(1));  // return True
        System.out.println(skiplist.search(1)); // return False, 1 has already been erased.

        Skiplist skiplist1 = new Skiplist();
        skiplist1.add(1);
        skiplist1.add(2);
        skiplist1.add(8);
        System.out.println(false + "\t" + skiplist1.search(0));
        skiplist1.add(4);
        System.out.println(true + "\t" + skiplist1.search(1));
        System.out.println(true + "\t" + skiplist1.search(2));
        System.out.println(false + "\t" + skiplist1.search(3));
        System.out.println(true + "\t" + skiplist1.search(4));
        System.out.println(true + "\t" + skiplist1.search(8));
        System.out.println(false + "\t" + skiplist1.search(10));
        System.out.println(false + "\t" + skiplist1.erase(0));
        System.out.println(false + "\t" + skiplist1.erase(9));
        System.out.println(true + "\t" + skiplist1.erase(8));
        System.out.println(true + "\t" + skiplist1.erase(1));
        System.out.println(false + "\t" + skiplist1.search(1));
        System.out.println(false + "\t" + skiplist1.search(8));
    }
}