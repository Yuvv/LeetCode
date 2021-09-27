package main

import "fmt"

func singleNumber(nums []int) []int {
	xor := 0
	for i := 0; i < len(nums); i++ {
		xor ^= nums[i]
	}
	// now, xor = x ^ y
	// let's find right-most '1' bit
	i := 0
	for (xor & 1) == 0 {
		xor >>= 1
		i++
	}
	// compute in two group
	xor = 1 << i
	group_a, group_b := 0, 0
	for i := 0; i < len(nums); i++ {
		if (nums[i] & xor) > 0 {
			group_a ^= nums[i]
		} else {
			group_b ^= nums[i]
		}
	}

	return []int{group_a, group_b}
}

func main() {
	// [3,5]
	fmt.Println(singleNumber([]int{1, 2, 1, 3, 2, 5}))
	// [-1,0]
	fmt.Println(singleNumber([]int{-1, 0}))
	// [1,0]
	fmt.Println(singleNumber([]int{0, 1}))
	// [1,5]
	fmt.Println(singleNumber([]int{3, 5, 10, 3, 10, 0, 0, 1}))
	// [1,5]
	fmt.Println(singleNumber([]int{3, 5, 10, 3, 10, 2, 2, 1}))
}
