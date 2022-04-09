package main

import (
	"fmt"
)

func isOk(nums []int, nPart, maxSum int) bool {
	cnt := 0
	sum := 0
	for _, num := range nums {
		if num > maxSum {
			return false
		}
		if sum+num > maxSum {
			cnt++
			sum = num
		} else {
			sum += num
		}
	}
	if sum > 0 {
		cnt++
	}
	return cnt <= nPart
}

func splitArray(nums []int, m int) int {
	sum := 0
	for _, num := range nums {
		sum += num
	}
	if m == 1 {
		return sum
	}
	min, max := sum/m, sum
	for min < max-1 {
		mid := (min + max) / 2
		if isOk(nums, m, mid) {
			max = mid
		} else {
			min = mid + 1
		}
	}
	if isOk(nums, m, min) {
		return min
	}

	return max
}

func main() {
	// 9
	fmt.Println(splitArray([]int{1, 2, 3, 4, 5}, 2))
	// 18
	fmt.Println(splitArray([]int{7, 2, 5, 10, 8}, 2))
	// 4
	fmt.Println(splitArray([]int{1, 4, 4}, 3))
}
