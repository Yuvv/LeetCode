package main

import "fmt"

func sumOfUnique(nums []int) int {
	sum := 0
	m := make(map[int]int)
	for _, each := range nums {
		if val, ok := m[each]; ok {
			if val > 0 {
				sum -= each
				m[each] = 0
			}
		} else {
			m[each] = 1
			sum += each
		}
	}
	return sum
}

func main() {
	// 4
	fmt.Println(sumOfUnique([]int{1, 2, 3, 2}))
	// 0
	fmt.Println(sumOfUnique([]int{1, 2, 2, 2, 1}))
}
