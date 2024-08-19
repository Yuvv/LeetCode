import java.util.*;

/**
 * 0386-lexicographical-numbers.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2024/08/19
 */
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> resList = new ArrayList<>(n);
        for (int i1 = 1; i1 <= Math.min(n, 9); i1++) { // 10
            resList.add(i1);
            for (int i2 = i1*10; i2 <= Math.min(n, (i1+1)*10-1); i2++) { // 100
                resList.add(i2);
                for (int i3 = i2*10; i3 <= Math.min(n, (i2+1)*10-1); i3++) { // 1000
                    resList.add(i3);
                    for (int i4 = i3*10; i4 <= Math.min(n, (i3+1)*10-1); i4++) { // 10000
                        resList.add(i4);
                        for (int i5 = i4*10; i5 <= Math.min(n, (i4+1)*10-1); i5++) { // 100000
                            resList.add(i5);
                        }
                    }
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [1,10,11,12,13,2,3,4,5,6,7,8,9]
        System.out.println(s.lexicalOrder(13));
        // [1,2]
        System.out.println(s.lexicalOrder(2));
    }
}
