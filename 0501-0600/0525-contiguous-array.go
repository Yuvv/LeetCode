package main

import (
	"fmt"
)

func findMaxLength(nums []int) int {
	// sum 首次出现的位置
	sMap := make(map[int]int)
	sMap[0] = -1
	sum := 0
	max := 0
	for i, num := range nums {
		if num == 0 {
			sum += -1
		} else {
			sum += 1
		}
		v, ok := sMap[sum]
		if ok {
			dis := i - v
			if max < dis {
				max = dis
			}
		} else {
			sMap[sum] = i
		}
	}
	return max
}

func main() {
	// 14
	fmt.Println(findMaxLength([]int{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}))
	// 2
	fmt.Println(findMaxLength([]int{0, 1, 0}))
}
