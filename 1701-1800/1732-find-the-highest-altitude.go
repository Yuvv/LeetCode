package main

import "fmt"

func largestAltitude(gain []int) int {
	cum_sum := 0
	max_val := 0
	for i := 0; i < len(gain); i++ {
		cum_sum += gain[i]
		if max_val < cum_sum {
			max_val = cum_sum
		}
	}
	return max_val
}

func main() {
	// 1 expected
	fmt.Println(largestAltitude([]int{-5, 1, 5, 0, -7}))
	// 0 expected
	fmt.Println(largestAltitude([]int{-4, -3, -2, -1, 4, 3, 2}))
}
