package main

import "fmt"

func check(nums []int) bool {
	rotated, breakout := false, false
	nLen := len(nums)
	var i int
	for i = 1; i < nLen; i++ {
		if nums[i] < nums[i-1] {
			if !rotated {
				rotated = true
			} else {
				breakout = true
				break
			}
		}
	}
	if breakout {
		return false
	}
	if rotated && nums[nLen-1] > nums[0] {
		return false
	}
	return true
}

func main() {
	// true
	fmt.Println(check([]int{1, 2, 3}))
	// true
	fmt.Println(check([]int{3, 4, 1, 2}))
	// true
	fmt.Println(check([]int{1, 1, 1}))
	// true
	fmt.Println(check([]int{3, 4, 1, 2, 3}))
	// true
	fmt.Println(check([]int{2, 1, 3, 4}))
}
