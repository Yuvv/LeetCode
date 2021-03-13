package main

import "fmt"

func removeDuplicates(nums []int) int {
	nLen := len(nums)
	if nLen <= 2 {
		return nLen
	}
	lastIdx := 0
	times := 1
	for cur := 1; cur < nLen; cur++ {
		if nums[cur] == nums[lastIdx] {
			times++
		} else {
			times = 1
		}
		if times <= 2 {
			lastIdx++
			nums[lastIdx] = nums[cur]
		}
	}
	return lastIdx + 1
}

func main() {
	// [1,1,2,2,3]
	fmt.Println(removeDuplicates([]int{1, 1, 1, 2, 2, 3}))
}
