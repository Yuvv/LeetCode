struct Solution;

impl Solution {
    pub fn earliest_finish_time(
        land_start_time: Vec<i32>,
        land_duration: Vec<i32>,
        water_start_time: Vec<i32>,
        water_duration: Vec<i32>,
    ) -> i32 {
        let mut res: i32 = i32::MAX;
        // 1. land first, then water
        for i in 0..land_start_time.len() {
            let l_end_time = land_start_time[i] + land_duration[i];
            for j in 0..water_start_time.len() {
                res = res.min(l_end_time.max(water_start_time[j]) + water_duration[j]);
            }
        }
        // 2. water first, then land
        for i in 0..water_start_time.len() {
            let w_end_time = water_start_time[i] + water_duration[i];
            for j in 0..land_start_time.len() {
                res = res.min(w_end_time.max(land_start_time[j]) + land_duration[j]);
            }
        }

        res
    }
}

fn main() {
    // 9
    println!(
        "{}",
        Solution::earliest_finish_time(vec![2, 8], vec![4, 1], vec![6], vec![3],),
    );
}
