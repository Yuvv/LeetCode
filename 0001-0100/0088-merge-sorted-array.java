class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int pos = n + m - 1;
        
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[pos] = nums1[i];
                i--;
            } else {
                nums1[pos] = nums2[j];
                j--;
            }
            pos--;
        }
        
        while (j >= 0) {
            nums1[pos] = nums2[j];
            j--;
            pos--;
        }
    }
}