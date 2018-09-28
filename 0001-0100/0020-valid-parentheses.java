class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char c: s.toCharArray()){
            switch (c) {
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:
                    stack.push(c);
                    break;
            }
        }

        return stack.isEmpty();
    }
}