package main

import "fmt"

func findMaxConsecutiveOnes(nums []int) int {
	nLen := len(nums)
	maxLen := 0
	begin := -1
	var i int
	for i = 0; i < nLen; i++ {
		if nums[i] == 0 {
			if (i - begin - 1) > maxLen {
				maxLen = i - begin - 1
			}
			begin = i
		}
	}
	if (i - begin - 1) > maxLen {
		maxLen = i - begin - 1
	}
	return maxLen
}

func main() {
	// 2
	fmt.Println(findMaxConsecutiveOnes([]int{1, 1, 0, 1, 1}))
	// 0
	fmt.Println(findMaxConsecutiveOnes([]int{0, 0, 0, 0}))
	// 3
	fmt.Println(findMaxConsecutiveOnes([]int{0, 1, 1, 1, 0, 1, 1}))
	// 7
	fmt.Println(findMaxConsecutiveOnes([]int{1, 1, 1, 1, 1, 1, 1}))
}
