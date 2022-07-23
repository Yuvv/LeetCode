/*
 * 2296-design-a-text-editor.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/23
 */
public class TextEditor {
    private StringBuilder sb;
    private int curPos;

    public TextEditor() {
        sb = new StringBuilder("|");
        curPos = 0;
    }

    public void addText(String text) {
        sb.insert(curPos, text);
        curPos += text.length();
    }

    public int deleteText(int k) {
        int from = Math.max(0, curPos - k);
        sb.delete(from, curPos);
        int count = curPos - from;
        curPos = from;
        return count;
    }

    public String cursorLeft(int k) {
        sb.deleteCharAt(curPos);
        curPos = Math.max(0, curPos - k);
        sb.insert(curPos, '|');
        int fromPos = Math.max(0, curPos - 10);
        return sb.substring(fromPos, curPos);
    }

    public String cursorRight(int k) {
        sb.deleteCharAt(curPos);
        curPos = Math.min(sb.length(), curPos + k);
        sb.insert(curPos, '|');
        int fromPos = Math.max(0, curPos - 10);
        return sb.substring(fromPos, curPos);
    }

    public static void main(String[] args) {
        // The current text is "|". (The '|' character represents the cursor)
        TextEditor textEditor = new TextEditor();
        // The current text is "leetcode|".
        textEditor.addText("leetcode");
        // return 4
        // The current text is "leet|".
        // 4 characters were deleted.
        System.out.println(textEditor.deleteText(4));
        // The current text is "leetpractice|".
        textEditor.addText("practice");
        // return "etpractice"
        // The current text is "leetpractice|".
        // The cursor cannot be moved beyond the actual text and thus did not move.
        // "etpractice" is the last 10 characters to the left of the cursor.
        System.out.println(textEditor.cursorRight(3));
        // return "leet"
        // The current text is "leet|practice".
        // "leet" is the last min(10, 4) = 4 characters to the left of the cursor.
        System.out.println(textEditor.cursorLeft(8));
        // return 4
        // The current text is "|practice".
        // Only 4 characters were deleted.
        System.out.println(textEditor.deleteText(10));
        // return ""
        // The current text is "|practice".
        // The cursor cannot be moved beyond the actual text and thus did not move.
        // "" is the last min(10, 0) = 0 characters to the left of the cursor.
        System.out.println(textEditor.cursorLeft(2));
        // return "practi"
        // The current text is "practi|ce".
        // "practi" is the last min(10, 6) = 6 characters to the left of the cursor.
        System.out.println(textEditor.cursorRight(6));
    }
}
