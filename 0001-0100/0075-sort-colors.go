package main

import (
	"fmt"
)

func sortColors(nums []int) {
	zeroIdx, twoIdx := 0, len(nums) - 1
	scanIdx := 0
	for scanIdx <= twoIdx {
		if nums[scanIdx] == 2 {
			// swap
			nums[scanIdx], nums[twoIdx] = nums[twoIdx], nums[scanIdx]
			twoIdx--
		} else if nums[scanIdx] == 0 && scanIdx != zeroIdx {
			// swap
			nums[scanIdx], nums[zeroIdx] = nums[zeroIdx], nums[scanIdx]
			zeroIdx++
		} else {
			scanIdx++
		}
	}
}

func main() {
	// [0,0,1,1,2,2]  expected
	a := []int{2, 0, 2, 1, 1, 0}
	sortColors(a)
	fmt.Println(a)
	// [0,0,0,1,1,1,2,2]  expected
	b := []int{0, 2, 1, 0, 2, 1, 1, 0, 2}
	sortColors(b)
	fmt.Println(b)
	// [0,1,2]  expected
	c := []int{2, 0, 1}
	sortColors(c)
	fmt.Println(c)
}
