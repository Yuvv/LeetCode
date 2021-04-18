import java.util.*;

/*
 * 0060-permutation-sequence.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/04/18
 */
public class Solution {

    private int[] NNN = new int[]{0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public Character popXmin(LinkedList<Character> candidate, int x) {
        int i = 1;
        Iterator<Character> it = candidate.iterator();
        while (i < x) {
            it.next();
            i++;
        }
        Character ch = it.next();
        it.remove();;
        return ch;
    }

    public String getPermutation(int n, int k) {
       List<Character> chs = new ArrayList<>(n);
        LinkedList<Character> candidate = new LinkedList<>();
        char ci = '1';
        for (int i = 0; i < n; i++) {
            candidate.add(ci);
            ci++;
        }
        int nnnCheckIndex = n;
        while (k > 0 && nnnCheckIndex > 1) {
            if (k > NNN[nnnCheckIndex - 1] && k <= NNN[nnnCheckIndex]) {
                int x = k / NNN[nnnCheckIndex - 1];
                int y = k % NNN[nnnCheckIndex - 1];
                if (y == 0) {
                    chs.add(popXmin(candidate, x));
                    k = NNN[nnnCheckIndex - 1];
                } else {
                    chs.add(popXmin(candidate, x + 1));
                    k = y;
                }
            } else {
                chs.add(popXmin(candidate, 1));
            }
            nnnCheckIndex--;
        }

        chs.addAll(candidate);
        return chs.stream().map(Object::toString).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 213
        System.out.println(s.getPermutation(3, 3));
        // 2314
        System.out.println(s.getPermutation(4, 9));
        // 123
        System.out.println(s.getPermutation(3, 1));
        // 231
        System.out.println(s.getPermutation(3, 4));
        // 987654312
        System.out.println(s.getPermutation(9, 362879));
    }
}