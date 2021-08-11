package main

import (
	"fmt"
	"sort"
)

func canReorderDoubled(arr []int) bool {
	m := make(map[int]int)
	var target, cnt int
	var ok bool

	sort.Ints(arr)
	for _, v := range arr {
		if v%2 == 0 {
			target = v / 2
			cnt, ok = m[target]
			if ok && cnt > 0 {
				m[target] = cnt - 1
				continue
			}
		}
		target = v * 2
		cnt, ok = m[target]
		if ok && cnt > 0 {
			m[target] = cnt - 1
			continue
		}

		// otherwise
		m[v] = m[v] + 1
	}

	for _, v := range m {
		if v > 0 {
			return false
		}
	}
	return true
}

func main() {
	// false
	fmt.Println(canReorderDoubled([]int{3, 1, 3, 6}))
	// false
	fmt.Println(canReorderDoubled([]int{2, 1, 2, 6}))
	// true
	fmt.Println(canReorderDoubled([]int{4, -2, 2, -4}))
	// false
	fmt.Println(canReorderDoubled([]int{1, 2, 4, 16, 8, 4}))
	// true
	fmt.Println(canReorderDoubled([]int{-1, 4, 6, 8, -4, 6, -6, 3, -2, 3, -3, -8}))
	// true
	fmt.Println(canReorderDoubled([]int{4, 6, 8, -4, 6, -6, -2, 3, -8, -1, 3, -3}))
}
