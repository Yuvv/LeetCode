package main

import (
	"fmt"
)

func repeatedNTimes(A []int) int {
	arrLen := len(A)
	halfArrLen := arrLen / 2
	m := make(map[int]int)
	for _, it := range A {
		v, ok := m[it]
		if !ok {
			v = 0
		}
		m[it] = v + 1
		if m[it] == halfArrLen {
			return it
		}

	}
	return -1
}

func main() {
	// 3
	fmt.Println(repeatedNTimes([]int{1, 2, 3, 3}))
	// 2
	fmt.Println(repeatedNTimes([]int{2, 1, 2, 5, 3, 2}))
	// 5
	fmt.Println(repeatedNTimes([]int{5, 1, 5, 2, 5, 3, 5, 4}))
}
