package main

import (
	"fmt"
	"sort"
)

func lastStoneWeight(stones []int) int {
	sort.Ints(stones)
	pos := len(stones) - 1
	for pos >= 1 {
		if stones[pos] == stones[pos-1] {
			stones[pos-1] = stones[pos] - stones[pos-1]
			pos -= 2
		} else {
			stones[pos-1] = stones[pos] - stones[pos-1]
			for i := pos - 1; i > 0; i-- {
				if stones[i] < stones[i-1] {
					stones[i], stones[i-1] = stones[i-1], stones[i]
				} else {
					break
				}
			}
			pos--
		}
	}
	return stones[0]
}

func main() {
	// 1
	fmt.Println(lastStoneWeight([]int{2, 7, 4, 1, 8, 1}))
	// 0
	fmt.Println(lastStoneWeight([]int{2, 2}))
}
