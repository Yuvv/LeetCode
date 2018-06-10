class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        return quickSort(nums,0,nums.length-1,k);
        
    }
    public int quickSort(int[] nums,int left,int right,int k){
        int i = left;
        int j = right;
        int tmp = nums[i];
        while(i<j){
            while(i<j && tmp>=nums[j]) j--;
            if(i<j){
                nums[i]=nums[j];
                i++;
            }
            while(i<j && tmp<nums[i]) i++;
            if(i<j){
                nums[j]=nums[i];
                j--;
            }
            
        }
        if(i == k -1){
            return tmp;
        }else if(i< k-1){
            return quickSort(nums,i+1,right,k);
        }else{
            return quickSort(nums,left,i-1,k);
        }
    }
};