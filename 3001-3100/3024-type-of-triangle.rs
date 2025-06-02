struct Solution;

impl Solution {
    pub fn triangle_type(nums: Vec<i32>) -> String {
        if nums[0] + nums[1] <= nums[2] ||
           nums[0] + nums[2] <= nums[1] ||
           nums[1] + nums[2] <= nums[0] {
            return "none".to_string();
        }
        if nums[0] == nums[1] && nums[1] == nums[2] {
            return "equilateral".to_string();
        }
        if nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2] {
            return "isosceles".to_string();
        }
        return "scalene".to_string();
    }
}

fn main() {
    let nums = vec![3, 4, 5];
    let result = Solution::triangle_type(nums);
    println!("{}", result); // Output: "scalene"
    // "equilateral"
    println!("{}", Solution::triangle_type(vec![2, 2, 2])); // Output: "equilateral"

}
