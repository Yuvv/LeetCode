use std::collections::HashSet;

struct Solution {}

impl Solution {
    pub fn total_numbers(digits: Vec<i32>) -> i32 {
        let mut total: i32 = 0;
        let mut i_set = HashSet::new();
        let mut j_set = HashSet::new();
        let mut k_set = HashSet::new();
        for i in 0..digits.len() {
            if digits[i] == 0 {
                continue;
            }
            if i_set.contains(&digits[i]) {
                continue;
            }
            i_set.insert(digits[i]);
            j_set.clear();
            for j in 0..digits.len() {
                if j == i {
                    continue;
                }
                if j_set.contains(&digits[j]) {
                    continue;
                }
                j_set.insert(digits[j]);
                k_set.clear();
                for k in 0..digits.len() {
                    if k == i || k == j {
                        continue;
                    }
                    if k_set.contains(&digits[k]) {
                        continue;
                    }
                    k_set.insert(digits[k]);
                    if digits[k] % 2 == 0 {
                        total += 1;
                    }
                }
            }
        }

        total
    }
}

fn main() {
    // 2
    println!("{}", Solution::total_numbers(vec![0, 2, 2]));
    // 12
    println!("{}", Solution::total_numbers(vec![1, 2, 3, 4]));
}
