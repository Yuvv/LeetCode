package main

import (
	"fmt"
	"math"
)

func getDivisors(num int) (int, int) {
	max := int(math.Sqrt(float64(num)))
	result := make([]int, 2)
	ri := 0
	for i := 2; i <= max; i++ {
		if num%i == 0 {
			if ri >= 2 {
				return 0, 0
			}
			result[ri] = i
			ri++
			result[ri] = num / i
			ri++
			if result[0] == result[1] {
				return 0, 0
			}
		}
	}
	return result[0], result[1]
}

func sumFourDivisors(nums []int) int {
	result := 0
	var a, b int
	for _, num := range nums {
		a, b = getDivisors(num)
		if a > 0 && b > 0 {
			result += a
			result += b
			result += num
			result += 1
		}
	}
	return result
}

func main() {
	// 32
	fmt.Println(sumFourDivisors([]int{21, 7, 4}))
	// 44
	fmt.Println(sumFourDivisors([]int{21, 4, 7, 2, 5, 6, 12345, 7684, 23, 54, 99}))
}
