struct Solution;

impl Solution {
    pub fn min_element(nums: Vec<i32>) -> i32 {
        let mut res = i32::MAX;
        for num in nums {
            let mut sum = 0;
            let mut n = num;
            while n > 0 {
                sum += n % 10;
                n /= 10;
                if sum > res {
                    break; // fast fail
                }
            }
            res = res.min(sum);
        }
        return res;
    }
}


fn main() {
    let nums1 = vec![10, 12, 13, 14];
    let result1 = Solution::min_element(nums1);
    println!("The minimum element after replacement is: {}", result1);  // 1
    let nums2 = vec![999,19,199];
    let result2 = Solution::min_element(nums2);
    println!("The minimum element after replacement is: {}", result2);  // 10
}