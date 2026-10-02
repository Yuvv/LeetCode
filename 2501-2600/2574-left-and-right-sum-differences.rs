struct Solution;

impl Solution {
    pub fn left_right_difference(nums: Vec<i32>) -> Vec<i32> {
        let mut prefix_sum = vec![0; nums.len() + 1];
        for i in 0..nums.len() {
            prefix_sum[i + 1] = prefix_sum[i] + nums[i];
        }

        let mut res = vec![0; nums.len()];
        for i in 0..nums.len() {
            res[i] = (prefix_sum[nums.len()] - prefix_sum[i + 1] - prefix_sum[i]).abs();
        }

        res
    }
}

fn main() {
    // [15,1,11,22]
    println!("{:?}", Solution::left_right_difference(vec![10, 4, 8, 3]),);
}
