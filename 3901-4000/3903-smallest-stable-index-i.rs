use std::collections::BTreeMap;

struct Solution;

impl Solution {
    pub fn first_stable_index(nums: Vec<i32>, k: i32) -> i32 {
        let mut cnt_map: BTreeMap<i32, i32> = BTreeMap::new();
        for x in &nums {
            cnt_map.entry(*x).and_modify(|x| *x += 1).or_insert(1);
        }

        let mut cur_max = i32::MIN;
        for (i, x) in nums.iter().enumerate() {
            cur_max = cur_max.max(*x);
            let min_entry = cnt_map.first_entry();
            let cur_min_value = cur_max - *min_entry.unwrap().key();
            if cur_min_value <= k {
                return i as i32; // first
            }

            let some = cnt_map.get(&x);
            if some.is_some() {
                if *some.unwrap() == 1 {
                    cnt_map.remove(&x);
                } else {
                    cnt_map.insert(*x, *some.unwrap() - 1);
                }
            }
        }

        return -1;
    }
}

fn main() {
    // 3
    println!("{:?}", Solution::first_stable_index(vec![5, 0, 1, 4], 3),);
    // -1
    println!("{:?}", Solution::first_stable_index(vec![3, 2, 1], 1),);
}
