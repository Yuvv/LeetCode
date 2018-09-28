class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            if (! map.containsKey(s.charAt(i))) {
                for (int j=i+1; j<s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        map.put(s.charAt(i), true);
                        break;
                    }
                }
                if (! map.containsKey(s.charAt(i))) {
                    return i;
                }
            }
        }
        return -1;
    }
}