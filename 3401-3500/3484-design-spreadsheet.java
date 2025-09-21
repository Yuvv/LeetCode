import java.util.*;
/**
 * 3484-design-spreadsheet.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2025/09/21
 */
public class Spreadsheet {

    private Map<String, Map<String, Integer>> rows;

    public Spreadsheet(int rows) {
        this.rows = new HashMap<>(rows);
    }

    private String[] convertRowCol(String val) {
        int i = 0;
        while (i < val.length()) {
            char ch = val.charAt(i);
            if (ch < 'A' || ch > 'Z') {
                break;
            }
            i++;
        }
        return new String[]{val.substring(0, i), val.substring(i)};
    }

    public void setCell(String cell, int value) {
        String[] rowcol = convertRowCol(cell);
        rows.computeIfAbsent(rowcol[0], k -> new HashMap<>()).put(rowcol[1], value);
    }

    public void resetCell(String cell) {
        String[] rowcol = convertRowCol(cell);
        rows.computeIfAbsent(rowcol[0], k -> new HashMap<>()).remove(rowcol[1]);
    }

    public int getValue(String formula) {
        int idx = formula.indexOf('+');
        String a = formula.substring(1, idx);
        String b = formula.substring(idx+1);
        int av = 0;
        if (a.charAt(0) >= 'A' && a.charAt(0) <= 'Z') {
            String[] rowcol = convertRowCol(a);
            av = rows.computeIfAbsent(rowcol[0], k -> new HashMap<>()).getOrDefault(rowcol[1], 0);
        } else {
            av = Integer.parseInt(a);
        }
        int bv = 0;
        if (b.charAt(0) >= 'A' && b.charAt(0) <= 'Z') {
            String[] rowcol = convertRowCol(b);
            bv = rows.computeIfAbsent(rowcol[0], k -> new HashMap<>()).getOrDefault(rowcol[1], 0);
        } else {
            bv = Integer.parseInt(b);
        }
        return av + bv;
    }

    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet(3); // Initializes a spreadsheet with 3 rows and 26 columns
        System.out.println(spreadsheet.getValue("=5+7")); // returns 12 (5+7)
        spreadsheet.setCell("A1", 10); // sets A1 to 10
        System.out.println(spreadsheet.getValue("=A1+6")); // returns 16 (10+6)
        spreadsheet.setCell("B2", 15); // sets B2 to 15
        System.out.println(spreadsheet.getValue("=A1+B2")); // returns 25 (10+15)
        spreadsheet.resetCell("A1"); // resets A1 to 0
        System.out.println(spreadsheet.getValue("=A1+B2")); // returns 15 (0+15)
    }
}