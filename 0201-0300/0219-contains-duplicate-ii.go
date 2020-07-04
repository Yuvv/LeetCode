package main

import (
	"fmt"
)

func containsNearbyDuplicate(nums []int, k int) bool {
	m := make(map[int]int)
	for i, num := range nums {
		v, ok := m[num]
		if ok && (i-v) <= k {
			return true
		} else {
			m[num] = i
		}
	}
	return false
}

func main() {
	// true
	fmt.Println(containsNearbyDuplicate([]int{1, 2, 3, 1}, 3))
	// true
	fmt.Println(containsNearbyDuplicate([]int{1, 0, 1, 1}, 1))
	// false
	fmt.Println(containsNearbyDuplicate([]int{1, 2, 3, 1, 2, 3}, 2))
}
