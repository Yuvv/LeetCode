public class Solution {
    /*
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if(str.length == 0) {
            return;
        }
        offset = str.length - offset % str.length;
        String s = new String(str);
        for(int i=0; i<s.length(); i++) {
            str[i] = s.charAt((offset+i)%str.length);
        }
    }
}