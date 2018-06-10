public class Solution {
    /*
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int[] arr = new int[A.length + B.length];
        
        int i=0, j=0;
        int k = 0;
        
        // while(k < arr.length) {
            while(i < A.length && j < B.length) {
                if(A[i] <= B[j]) {
                    arr[k] = A[i];
                    i++;
                } else {
                    arr[k] = B[j];
                    j++;
                }
                k++;
            }
            while(i < A.length) {
                arr[k] = A[i];
                i++;
                k++;
            }
            while(j < B.length) {
                arr[k] = B[j];
                j++;
                k++;
            }
        // }
        
        return arr;
    }
}