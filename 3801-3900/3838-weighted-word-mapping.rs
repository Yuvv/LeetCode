struct Solution;

impl Solution {
    pub fn map_word_weights(words: Vec<String>, weights: Vec<i32>) -> String {
        let mut buff: Vec<char> = Vec::new();
        let a_u = 'a' as usize;
        for w in words {
            let mut c_sum = 0;
            for c in w.chars() {
                c_sum += weights[c as usize - a_u];
            }
            let x = ('z' as u8 - (c_sum % 26) as u8) as char;
            buff.push(x);
        }

        buff.into_iter().collect()
    }
}

fn main() {
    // "rij"
    println!(
        "{}",
        Solution::map_word_weights(
            vec![
                "abcd".parse().unwrap(),
                "def".parse().unwrap(),
                "xyz".parse().unwrap()
            ],
            vec![5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2]
        ),
    );
}
