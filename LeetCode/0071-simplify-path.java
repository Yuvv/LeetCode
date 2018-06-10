class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> dirStack = new LinkedList<>();
        for (String dir : path.split("/")) {
            if (dir.equals("..")) {
                if (!dirStack.isEmpty()) {
                    dirStack.removeLast();
                }
            } else if (!dir.equals(".") && !dir.isEmpty()) {
                dirStack.add(dir);
            }
        }
        StringBuilder sb = new StringBuilder("/");

        dirStack.forEach(dir -> {
            sb.append(dir + "/");
        });
        if (sb.lastIndexOf("/") == sb.length() - 1 && sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
        // /.... 的情况
        // StringBuilder sb = new StringBuilder();
        // char lastChar = '\0';
        // int lastIndex;
        // for (char c : path.toCharArray()) {
        //     switch (c) {
        //         case '.':
        //             if (lastChar == '.') {
        //                 if (sb.length() > 0) {
        //                     sb.deleteCharAt(sb.length() - 1);   //  /home/../ab 的情况，先删除末尾的 /
        //                 }
        //                 lastIndex = sb.lastIndexOf("/");
        //                 if (lastIndex > 0) {
        //                     sb.delete(lastIndex, sb.length());
        //                 }
        //             }
        //             break;
        //         case '/':
        //             if (lastChar == '.')  {
        //                 if (sb.length() > 0) {    // sb 此时可能为空，比如 /home/../abc
        //                    sb.deleteCharAt(sb.length() - 1);   // /home/./a  的情况
        //                 }
        //             }
        //             if (lastChar != '/')  {
        //                 sb.append(c);   // 排除 /home//user 的情况
        //             }
        //             break;
        //         default:
        //             sb.append(c);
        //             break;
        //     }
        //     lastChar = c;
        // }
        // if (lastChar == '/') {
        //     sb.deleteCharAt(sb.length() - 1);  //  /home// 的情况
        // }
        // if (sb.length() == 0) {
        //     return "/";
        // }
        // return sb.toString();
    }
}