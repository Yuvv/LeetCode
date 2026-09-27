struct Solution;

impl Solution {
    pub fn gcd_sum(nums: Vec<i32>) -> i64 {
        let mut prefix_gcd = vec![];
        let mut c_max = nums[0];
        for n in nums {
            c_max = c_max.max(n);
            let c = Self::gcd(n, c_max);
            prefix_gcd.push(c);
        }
        prefix_gcd.sort();
        let mut res : i64 = 0;
        while prefix_gcd.len() > 1 {
            let g_min = prefix_gcd.remove(0);
            let g_max = prefix_gcd.remove(prefix_gcd.len() - 1);
            let g = Self::gcd(g_min, g_max);
            res += g as i64;
        }
        return res;
    }

    pub fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            a
        } else {
            Self::gcd(b, a % b)
        }
    }
}

fn main() {
    let nums = vec![2,6,4];
    let result = Solution::gcd_sum(nums);
    println!("The sum of GCDs of all formed pairs is: {}", result);  // 2
                                                                     //
    let nums2 = vec![3,6,2,8];
    let result2 = Solution::gcd_sum(nums2);
    println!("The sum of GCDs of all formed pairs is: {}", result2);  // 5
}