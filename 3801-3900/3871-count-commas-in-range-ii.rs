struct Solution;

impl Solution {
    pub fn count_commas(n: i32) -> i32 {
        // 1 <= n <= 10^15
        let mut res = 0;
        let mut base = 1_000_000_000_000_000;
        while base > 1 {
            let d = n / base;
            let r = n % base;
            if d > 0 {
                res += (d - 1) * base + 1 + r;
            }
            base /= 1000;
        }
        return res;
    }
}

fn main() {
    // 3
    println!("{}", Solution::count_commas(1002));
    // 3598998998995004
    println!("{}", Solution::count_commas(899999999999000));
}
