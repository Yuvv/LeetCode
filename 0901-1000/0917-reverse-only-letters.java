/*
 * 0917-reverse-only-letters.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/09/14
 */
public class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            while (i < j && !(arr[i] >= 'a' && arr[i] <= 'z' || arr[i] >= 'A' && arr[i] <= 'Z')) {
                i++;
            }
            while (i < j && !(arr[j] >= 'a' && arr[j] <= 'z' || arr[j] >= 'A' && arr[j] <= 'Z')) {
                j--;
            }
            // swap i & j
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        return new String(arr);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // "dc-ba"
        System.out.println(s.reverseOnlyLetters("ab-cd"));
        // "j-Ih-gfE-dCba"
        System.out.println(s.reverseOnlyLetters("a-bC-dEf-ghIj"));
        // "Qedo1ct-eeLg=ntse-T!"
        System.out.println(s.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        // inputs
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i] + "->" + s.reverseOnlyLetters(args[i]));
        }
    }

}