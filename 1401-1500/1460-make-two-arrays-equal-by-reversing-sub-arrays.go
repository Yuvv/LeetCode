package main

import (
	"fmt"
)

func canBeEqual(target []int, arr []int) bool {
	targetCountMap := make(map[int]int)
	for _, it := range(target) {
		v, ok := targetCountMap[it]
		if ok {
			targetCountMap[it] = v + 1
		} else {
			targetCountMap[it] = 1
		}
	}
	for _, it := range(arr) {
		v, ok := targetCountMap[it]
		if ok {
			if v == 0 {
				return false
			}
			targetCountMap[it] = v - 1
		} else {
			return false
		}
	}
	return true
}


func main() {
	// true expected
	fmt.Println(canBeEqual([]int {1, 2, 3, 4}, []int {2, 3, 1, 4}))
	// false expected
	fmt.Println(canBeEqual([]int {1, 2, 3, 4}, []int {2, 3, 1, 5}))
	// true expected
	fmt.Println(canBeEqual([]int {1, 1, 2, 2}, []int {2, 1, 1, 2}))
}