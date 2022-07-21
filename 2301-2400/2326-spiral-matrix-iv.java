/*
 * 2326-spiral-matrix-iv.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2022/07/21
 */
public class Solution {

    private ListNode setVal(int[][] matrix, int i, int j, ListNode node) {
        if (node == null) {
            matrix[i][j] = -1;
            return null;
        } else {
            matrix[i][j] = node.val;
            return node.next;
        }
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        int i = 0, j = 0;
        int left = 0, top = 0;
        int right = n - 1, bottom = m - 1;
        int count = 0;
        int targetCount = m * n;
        while (count < targetCount) {
            // right
            while (j < right && count < targetCount) {
                head = setVal(matrix, i, j, head);
                j++;
                count++;
            }
            // down
            while (i < bottom && count < targetCount) {
                head = setVal(matrix, i, j, head);
                i++;
                count++;
            }
            // left
            while (j > left && count < targetCount) {
                head = setVal(matrix, i, j, head);
                j--;
                count++;
            }
            // up
            while (i > top && count < targetCount) {
                head = setVal(matrix, i, j, head);
                i--;
                count++;
            }
            if (right == left && bottom == top) {
                setVal(matrix, i, j, head);
                count++;
            }
            if (count < targetCount) {
                // shrink
                left++;
                right--;
                top++;
                bottom--;
                // move to next start position
                i++;
                j++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
        System.out.println(java.util.Arrays.deepToString(
            s.spiralMatrix(3, 5, ListNode.fromInts(3,0,2,6,8,1,7,9,4,2,5,5,0))
        ));
        //
        System.out.println(java.util.Arrays.deepToString(
            s.spiralMatrix(33, 33, ListNode.fromInts(
                45,305,389,563,585,690,863,938,812,406,448,229,64,574,919,
                784,383,683,560,972,372,119,109,200,820,544,450,899,311,123,
                52,299,10,389,53,561,207,124,518,411,805,450,852,324,195,585,
                403,855,716,622,709,620,981,528,194,261,404,263,952,180,759,523,
                277,391,57,184,292,31,940,10,543,121,521,287,122,559,475,962,
                120,315,195,437,470,691,141,992,324,894,600,326,188,434,715,
                227,295,7,654,411,54,193,660,63,621,218,411,395,481,371,585,
                433,234,286,908,187,939,944,751,690,918,632,109,720,51,693,
                189,331,114,604,714,670,293,737,727,572,570,958,302,159,879,
                873,587,112,994,383,905,866,943,903,982,271,488,908,283,807,
                196,490,585,839,625,872,658,75,898,831,971,724,630,644,175,
                387,436,964,825,173,419,482,116,314,171,948,678,789,329,752,
                830,668,543,244,36,643,17,842,658,321,452,725,941,877,350,
                995,136,283,438,429,30,756,412,662,746,474,772,566,915,13,
                43,154,869,373,505,461,961,970,364,825,438,102,474,869,246,
                31,774,663,912,505,229,489,26,232,765,896,792,964,917,530,
                527,904,625,883,670,306,305,223,45,196,51,120,75,722,111,
                600,365,536,896,717,416,349,261,723,734,372,955,454,385,
                150,990,366,152,861,741,95,865,767,121,785,549,487,212,308,
                9,105,14,695,849,808,89,195,59,350,864,551,489,539,588,578,
                663,179,724,641,327,7,212,341,770,305,198,527,570,376,886,
                635,995,901,973,496,688,15,123,932,454,117,62,361,478,454,
                410,176,187,119,189,405,392,517,546,925,413,227,996,548,641,
                76,199,540,397,142,770,25,667,782,733,920,86,733,476,602,730,
                619,278,169,312,153,880,688,123,563,835,874,460,268,589,454,
                86,670,190,778,244,718,699,397,984,992,550,458,448,460,381,
                501,951,206,427,476,288,962,576,957,445,398,71,669,83,351,
                832,181,808,15,965,325,187,231,726,44,442,331,645,609,393,
                130,926,351,399,505,83,68,79,736,609,757,977,817,793,764,
                558,160,946,453,899,937,226,489,80,663,493,90,284,376,61,
                916,48,2,665,806,153,750,771,407,576,747,577,628,552,233,
                779,442,763,654,299,682,763,907,387,459,663,835,224,826,
                340,495,731,324,220,437,384,798,816,139,216,581,870,661,
                97,308,960,614,269,839,773,680,816,37,714,150,795,944,820,
                539,755,370,501,197,453,96,802,273,47,197,584,322,731,311,
                394,431,251,698,4,280,670,567,356,822,504,553,398,553,599,
                938,379,879,63,571,485,710,81,15,510,448,445,851,770,965,
                918,917,834,478,127,410,43,853,78,281,677,541,822,353,194,
                336,799,600,755,922,144,980,5,517,621,338,280,789,583,595,
                651,585,303,881,134,179,393,416,912,278,864,208,873,246,489,
                122,446,0,866,188,538,997,988,357,910,950,727,172,165,167,
                408,944,71,934,122,378,522,904,159,716,462,807,815,601,816,
                396,707,245,527,557,373,907,325,672,38,782,122,890,433,879,
                957,4,561,58,19,62,822,747,618,28))
        ));
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    static ListNode fromInts(int... vals) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int val : vals) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }

        return head.next;
    }
}
