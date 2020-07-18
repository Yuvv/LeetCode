package main

import (
	"fmt"
)

func numIdenticalPairs(nums []int) int {
	m := map[int]int{}
	for _, num := range nums {
		if v, ok := m[num]; ok {
			m[num] = v + 1
		} else {
			m[num] = 1
		}
	}
	totalCount := 0
	for _, v := range m {
		if v > 1 {
			totalCount += (v - 1) * v / 2
		}
	}
	return totalCount
}

func main() {
	// 6
	fmt.Println(numIdenticalPairs([]int{1, 1, 1, 1}))
	// 4
	fmt.Println(numIdenticalPairs([]int{1, 2, 3, 1, 1, 3}))
}
