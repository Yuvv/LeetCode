// File: 3349-check-balanced-string.rs
// Author: Yuvv <yuvv_th@outlook.com>
// Date: 2024/11/13

struct Solution {}

impl Solution {
    pub fn is_balanced(num: String) -> bool {
        let mut xsum: i32 = 0;
        for (idx, chr) in num.chars().enumerate() {
            if idx % 2 == 0 {
                xsum += chr as i32 - 48;
            } else {
                xsum -= chr as i32 - 48;
            }
        }
        return xsum == 0;
    }
}

fn main() {
    // false
    println!("{}", Solution::is_balanced(String::from("1234")));
    // true
    println!("{}", Solution::is_balanced(String::from("24123")));
}
