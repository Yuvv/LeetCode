class Solution {
    public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }
        String s = "1";
        int count = 0;
        char curChar = '\0';
        StringBuilder sb;
        while (--n > 0) {
            sb = new StringBuilder();
            for (int i=0; i<s.length(); i++) {
                if (count == 0) {     // 第一次出现
                    curChar = s.charAt(i);
                    count ++;
                } else if (curChar == s.charAt(i)){
                    count++;
                } else {
                    sb.append(count);
                    sb.append(curChar);
                    curChar = s.charAt(i);
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(curChar);
            count = 0;
            s = sb.toString();
        }
        return s;
    }
}