use std::collections::HashSet;

struct Solution;

impl Solution {
    pub fn find_missing_elements(nums: Vec<i32>) -> Vec<i32> {
        let mut hm = HashSet::new();
        let mut n_min = i32::MAX;
        let mut n_max = i32::MIN;
        for n in nums {
            hm.insert(n);
            n_min = n.min(n_min);
            n_max = n.max(n_max);
        }
        let mut res = vec![];
        for i in (n_min+1)..n_max {
            if !hm.contains(&i) {
                res.push(i);
            }
        }
        return res;
    }
}

fn main() {
    let nums = vec![1,4,2,5];
    let missing_elements = Solution::find_missing_elements(nums);
    println!("Missing elements: {:?}", missing_elements);  // Output: [3]
}