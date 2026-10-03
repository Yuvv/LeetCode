struct SolutionTLE;
impl SolutionTLE {
    pub fn result_array(nums: Vec<i32>, k: i32) -> Vec<i64> {
        let mut nums_copy = vec![0; nums.len()];
        for (i, x) in nums.iter().enumerate() {
            nums_copy[i] = (x % k) as i64;
        }
        let mut res = vec![0; k as usize];
        for i in 0..k {
            res[i as usize] = Self::resolve_x(&nums_copy, k as i64, i as i64);
        }

        res
    }

    pub fn resolve_x(nums: &Vec<i64>, k: i64, x: i64) -> i64 {
        let mut dp: Vec<i64> = vec![0; nums.len()];
        for i in 0..nums.len() {
            let mut cnt = 0;
            let mut p = 1;
            for j in (0..=i).rev() {
                p *= nums[j];
                p %= k;
                if p == x {
                    cnt += 1;
                }
                if p == 0 && x != 0 {
                    break; // fast fail
                }
            }
            if i > 0 {
                dp[i] = dp[i - 1] + cnt;
            } else {
                dp[i] = cnt;
            }
        }

        dp[dp.len() - 1]
    }
}

struct Solution;
impl Solution {
    pub fn result_array(nums: Vec<i32>, k: i32) -> Vec<i64> {
        let mut p_dp = vec![0; k as usize];
        let mut res = vec![0; k as usize];
        for i in 0..nums.len() {
            let mut cp_dp = vec![0; k as usize];
            cp_dp[(nums[i] % k) as usize] += 1;
            for j in 0..k {
                let r = (j as i64 * nums[i] as i64) % k as i64;
                cp_dp[r as usize] += p_dp[j as usize];
            }

            p_dp = cp_dp;
            for j in 0..k {
                res[j as usize] += p_dp[j as usize] as i64;
            }
        }

        res
    }
}

fn main() {
    // [9,2,4]
    println!("{:?}", Solution::result_array(vec![1, 2, 3, 4, 5], 3),);
    // [18,1,2,0]
    println!("{:?}", Solution::result_array(vec![1, 2, 4, 8, 16, 32], 4),);
}
