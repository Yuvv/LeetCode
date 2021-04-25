package main

import "fmt"

// 这玩意还可以用二分。。
func findPeakElement(nums []int) int {
	nLen := len(nums)
	if nLen == 1 {
		return 0
	} else if nums[0] > nums[1] {
		return 0
	} else if nums[nLen-1] > nums[nLen-2] {
		return nLen - 1
	} else {
		i := 1
		for i < nLen-1 {
			if nums[i+1] < nums[i] && nums[i-1] < nums[i] {
				return i
			}
			i++
		}
	}

	return -1
}

func main() {
	// 2
	fmt.Println(findPeakElement([]int{1, 2, 3, 1}))
	// 1, 2, 5, 6
	fmt.Println(findPeakElement([]int{1, 2, 1, 3, 5, 6, 4}))
	// 2
	fmt.Println(findPeakElement([]int{1, 2, 3}))
	// 0
	fmt.Println(findPeakElement([]int{3, 2, 1}))
	// 0
	fmt.Println(findPeakElement([]int{2}))
}
