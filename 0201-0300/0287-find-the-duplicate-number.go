package main

import "fmt"

func findDuplicate(nums []int) int {
	fast := nums[0]
	slow := nums[0]
	// first iteration
	for init := true; init || fast != slow; init = false {
		fast = nums[nums[fast]]
		slow = nums[slow]
	}
	// find the entrance to the cycle
	slow = nums[0]
	for fast != slow {
		fast = nums[fast]
		slow = nums[slow]
	}
	return fast
}

func main() {
	// 2 expected
	fmt.Println(findDuplicate([]int{1, 3, 4, 2, 2}))
	// 3 expected
	fmt.Println(findDuplicate([]int{3, 1, 3, 4, 2}))
	// 9 expected
	fmt.Println(findDuplicate([]int{2, 5, 9, 6, 9, 3, 8, 9, 7, 1}))
}
