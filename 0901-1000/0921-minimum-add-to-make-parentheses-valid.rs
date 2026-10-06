struct Solution;

impl Solution {
    pub fn min_add_to_make_valid(s: String) -> i32 {
        // '('=40, ')'=41
        let mut stack = vec![];
        for c in s.bytes() {
            if c == 40 {
                stack.push(c);
            } else {
                if !stack.is_empty() && stack.last() == Some(&40) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        stack.len() as i32
    }

    // greedy
    pub fn min_add_to_make_valid2(s: String) -> i32 {
        let mut left = 0;
        let mut right = 0;
        for c in s.bytes() {
            if c == 40 {
                left += 1;
            } else {
                if left > 0 {
                    left -= 1;
                } else {
                    right += 1;
                }
            }
        }
        left + right
    }
}

fn main() {
    // 1
    println!("{:?}", Solution::min_add_to_make_valid(String::from("(()")));
    // 3
    println!(
        "{:?}",
        Solution::min_add_to_make_valid(String::from("())))"))
    );
}
