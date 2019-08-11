package main

import "fmt"


func singleNumber(nums []int) int {
	a1, a0 := 0, 0
	for i := 0; i < len(nums); i++ {
		carry := a0 & nums[i]
		reset := a1 & carry
		a0 |= nums[i]
		a1 |= carry
		a0 ^= reset
		a1 ^= reset
	}
	return a0
}

func main() {
	nums1 := []int{2, 2, 3, 2}
	fmt.Println(singleNumber(nums1))  // 3 expected
	nums2 := []int{0, 1, 0, 1, 0, 1, 99}
	fmt.Println(singleNumber(nums2))  // 99 expected
}