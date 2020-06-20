package main

import (
	"fmt"
	"math"
)

// 以0为首项，然后
// 1. 改变最右边的
// 2. 改变最右边第一个为1的位置的左边的
func grayCode(n int) []int {
	count := int(math.Pow(2, float64(n)))
	result := make([]int, count)
	result[0] = 0
	for i := 1; i < count; i++ {
		if i%2 == 0 {
			// 2. 改变最右边第一个为1的位置的左边的
			lastOne := result[i-1]
			curOrder := 1
			for (curOrder & lastOne) == 0 {
				curOrder <<= 1
			}
			curOrder <<= 1
			thatValue := lastOne & curOrder
			if thatValue > 0 {
				// 该位置为 1
				result[i] = lastOne & (^curOrder)
			} else {
				// 该位置为 0
				result[i] = lastOne | curOrder
			}
		} else {
			// 1. 改变最右边的
			if result[i-1]%2 == 0 {
				result[i] = result[i-1] + 1
			} else {
				result[i] = result[i-1] - 1
			}
		}
	}
	return result
}

func main() {
	// [0 1 3 2]
	fmt.Println(grayCode(2))
	// [0]
	fmt.Println(grayCode(0))
	// [0 1 3 2 6 7 5 4]
	fmt.Println(grayCode(3))
	// [0 1 3 2 6 7 5 4 12 13 15 14 10 11 9 8]
	fmt.Println(grayCode(4))
}
