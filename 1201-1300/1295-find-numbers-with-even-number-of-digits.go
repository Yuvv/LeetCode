package main

import (
	"fmt"
	"math"
)

func findNumbers(nums []int) int {
	count := 0
	for _, num := range(nums) {
		r := int(math.Log10(float64(num)))
		if r % 2 == 1 {
			count += 1
		}
	}
	return count
}

func main() {
	// 2 expected
	fmt.Println(findNumbers([]int{12, 345, 2, 6, 7896}))
	// 1 expected
	fmt.Println(findNumbers([]int{555, 901, 482, 1771}))
	// 2 expected
	fmt.Println(findNumbers([]int{999999, 999, 9999, 99999}))
}
