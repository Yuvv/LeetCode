package main

import (
	"fmt"
)

func runningSum(nums []int) []int {
	resultNums := make([]int, len(nums))
	sum := 0
	for i, each := range nums {
		sum += each
		resultNums[i] = sum
	}
	return resultNums
}

func main() {
	// [1,2,3,4,5] expected
	fmt.Println(runningSum([]int{1, 1, 1, 1, 1}))
	// [3,4,6,16,17] expected
	fmt.Println(runningSum([]int{3, 1, 2, 10, 1}))
}
