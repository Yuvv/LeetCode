
// This is MountainArray's API interface.
// You should not implement it, or speculate about its implementation
interface MountainArray {
    int get(int index);
    int length();
}

class MountainListArray implements MountainArray {
    private int[] arr;
    public MountainListArray(int[] a) {
        this.arr = a;
    }

    @Override
    public int get(int idx) {
        return arr[idx];
    }

    @Override
    public int length() {
        return arr.length;
    }
}


 /*
 * 1095-find-in-mountain-array.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/11/21
 */
public class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int lo = 0, hi = mountainArr.length() - 1;
        // find peek
        int mi = -1;
        while (lo <= hi) {
            mi = lo + (hi - lo) / 2;
            int miv = mountainArr.get(mi);
            int mivp = mountainArr.get(mi - 1);
            int mivn = mountainArr.get(mi + 1);
            if (miv > mivp && miv > mivn) {
                break;
            } else if (miv > mivp && miv < mivn) {
                lo = mi;
            } else if (miv < mivp && miv > mivn) {
                hi = mi;
            }
        }
        int res = getIndex(target, mountainArr, 0, mi, false);
        if (res >= 0) {
            return res;
        }
        return getIndex(target, mountainArr, mi, mountainArr.length() - 1, true);
    }

    public int getIndex(int target, MountainArray mountainArr, int lo, int hi, boolean reversed) {
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            int miv = mountainArr.get(mi);
            if (miv == target) {
                return mi;
            }
            if (reversed) {
                if (miv < target) {
                    hi = mi - 1;
                } else if (miv > target) {
                    lo = mi + 1;
                }
            } else {
                if (miv > target) {
                    hi = mi - 1;
                } else if (miv < target) {
                    lo = mi + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // -1
        System.out.println(s.findInMountainArray(2, new MountainListArray(new int[] {1,2,3,4,5,3,1})));
        // 2
        System.out.println(s.findInMountainArray(3, new MountainListArray(new int[] {1,2,3,4,5,3,1})));
        // 4
        System.out.println(s.findInMountainArray(0, new MountainListArray(new int[] {3,5,3,2,0})));
    }
}