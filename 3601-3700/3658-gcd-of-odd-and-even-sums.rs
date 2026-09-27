impl Solution {
    pub fn gcd_of_odd_even_sums(n: i32) -> i32 {
        // first `n` odd numbers sum to `n*n`
        // first `n` even numbers sum to `n*(n+1)`
        // gcd(n, n+1) = 1
        n
    }
}

struct Solution;

fn main() {
    let n = 5;
    let result = Solution::gcd_of_odd_even_sums(n);
    println!("The GCD of the sums of the first {} odd and even numbers is: {}", n, result);
}