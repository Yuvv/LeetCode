package main

import "fmt"

func sortArrayByParityII(nums []int) []int {
	nLen := len(nums)
	evenIdx, oddIdx := 0, 1

	for nLen > oddIdx || nLen > evenIdx {
		for nLen > oddIdx && (nums[oddIdx]&1) > 0 {
			oddIdx += 2
		}
		for nLen > evenIdx && (nums[evenIdx]&1) == 0 {
			evenIdx += 2
		}
		if oddIdx < nLen && evenIdx < nLen {
			// just swap
			nums[oddIdx], nums[evenIdx] = nums[evenIdx], nums[oddIdx]
			oddIdx += 2
			evenIdx += 2
		}
	}

	return nums
}

func main() {
	// [4,5,2,7]s, [4,7,2,5], [2,5,4,7], [2,7,4,5]
	fmt.Println(sortArrayByParityII([]int{4, 2, 5, 7}))
	// [2,3]
	fmt.Println(sortArrayByParityII([]int{2, 3}))
}
