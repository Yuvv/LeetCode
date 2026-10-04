struct Solution;

impl Solution {
    pub fn count_commas(n: i32) -> i32 {
        // 1 <= n <= 100_000
        let d = n / 1000;
        let r = n % 1000;
        if d > 0 {
            return (d - 1) * 1000 + 1 + r;
        } else {
            return 0;
        }
    }
}

fn main() {
    // 3
    println!("{}", Solution::count_commas(1002));
    // 99000
    println!("{}", Solution::count_commas(99999));
}
