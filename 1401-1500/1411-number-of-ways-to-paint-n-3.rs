struct Solution;

impl Solution {
    pub fn num_of_ways(n: i32) -> i32 {
        let MOD: i64 = 1_000_000_007;
        let mut x = 6;
        let mut y = 6;
        for i in 2..=n {
            let n_x = (3 * x + 2 * y) % MOD;
            let n_y = (2 * x + 2 * y) % MOD;
            x = n_x;
            y = n_y;
        }

        return ((x + y) % MOD) as i32;
    }
}

fn main() {
    // 30228214
    println!("{}", Solution::num_of_ways(5000));
}
