
/**
 * 2232-minimize-result-by-adding-parentheses-to-expression
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2023/12/01
 */
public class Solution {
    public String minimizeResult(String expression) {
        int min = Integer.MAX_VALUE;
        int mi = 0, mj = expression.length();
        int plusIdx = expression.indexOf('+');
        for (int i = 0; i < plusIdx; i++) {
            String asi = expression.substring(0, i);
            String psi = expression.substring(i, plusIdx);
            int ai = 1;
            if (asi.length() > 0) {
                ai = Integer.parseInt(asi);
            }
            int pi = Integer.parseInt(psi);
            for (int j = plusIdx + 1; j < expression.length(); j++) {
                String psj = expression.substring(plusIdx + 1, j + 1);
                String asj = expression.substring(j + 1);
                int pj = Integer.parseInt(psj);
                int aj = 1;
                if (asj.length() > 0) {
                    aj = Integer.parseInt(asj);
                }
                int val = ai * (pi + pj) * aj;
                if (val < min) {
                    mi = i;
                    mj = j;
                    min = val;
                }
            }
        }
        return expression.substring(0, mi) + "(" + expression.substring(mi, mj + 1) + ")"
                + expression.substring(mj + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "2(47+38)"
        System.out.println(s.minimizeResult("247+38"));
        // "1(2+3)4"
        System.out.println(s.minimizeResult("12+34"));
        // "(999+999)"
        System.out.println(s.minimizeResult("999+999"));
    }
}
