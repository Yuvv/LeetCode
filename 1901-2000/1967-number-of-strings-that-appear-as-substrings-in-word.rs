struct Solution;

impl Solution {
    pub fn num_of_strings(patterns: Vec<String>, word: String) -> i32 {
        let mut total = 0;
        for p in &patterns {
            if word.find(p).is_some() {
                total += 1;
            }
        }
        total
    }
}

fn main() {
    println!(
        "{}",
        Solution::num_of_strings(vec!["a", "ab", "bc", "d"], "abc".to_string())
    );
}
