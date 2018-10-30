class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>(s.length());
        Map<Character, Character> mapR = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            map.putIfAbsent(s.charAt(i), t.charAt(i));
            mapR.putIfAbsent(t.charAt(i), s.charAt(i));
            if (map.get(s.charAt(i)) != t.charAt(i) || mapR.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}