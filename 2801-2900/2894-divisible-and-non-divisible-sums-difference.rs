struct Solution;


impl Solution {
    pub fn difference_of_sums(n: i32, m: i32) -> i32 {
        let mut res = 0;
        for i in 1..n+1 {
            if i % m == 0 {
                res -= i;
            } else {
                res += i;
            }
        }
        return res;
    }
}

fn main() {
    // 19
    println!("res={}", Solution::difference_of_sums(10, 3));
    // 15
    println!("res={}", Solution::difference_of_sums(5, 6));
    // -15
    println!("res={}", Solution::difference_of_sums(5, 1));
}