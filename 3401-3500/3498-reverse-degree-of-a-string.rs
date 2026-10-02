struct Solution;

impl Solution {
    pub fn reverse_degree_traditional(s: String) -> i32 {
        let mut res: i32 = 0;
        for (i, c) in s.chars().enumerate() {
            res += ('z' as i32 - c as i32 + 1) * (i + 1) as i32;
        }

        res
    }

    pub fn reverse_degree(s: String) -> i32 {
        s.bytes()
            .enumerate()
            .map(|(i, b)| i32::from(b'z' - b + 1) * (i + 1) as i32)
            .sum()
    }
}

fn main() {
    println!("{}", Solution::reverse_degree("abc".to_string()));
}
