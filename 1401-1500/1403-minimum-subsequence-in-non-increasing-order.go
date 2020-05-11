package main

import (
	"fmt"
	"sort"
)


func minSubsequence(nums []int) []int {
	if len(nums) <= 1 {
		return nums
	}
	sort.Sort(sort.Reverse(sort.IntSlice(nums)))
	leftSum, rightSum := 0, 0
	left, right := 0, len(nums) - 1
	for left <= right {
		rightSum += nums[right]
		right--
		for leftSum <= rightSum {
			leftSum += nums[left]
			left++
		}
	}
	return nums[:left]
}


func main() {
	// [10,9] expected
	fmt.Println(minSubsequence([]int {4, 3, 10, 9, 8}))
	// [7,7,6] expected
	fmt.Println(minSubsequence([]int {4, 4, 7, 6, 7}))
	// [6] expected
	fmt.Println(minSubsequence([]int {6}))
}