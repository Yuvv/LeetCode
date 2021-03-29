package main

import "fmt"

func numPairsDivisibleBy60(time []int) int {
	result := 0
	count_map := make(map[int]int)

	for _, each := range time {
		each %= 60
		value, ok := count_map[each]
		if !ok {
			value = 0
		} else if each == 0 {
			result += value
		}
		if each != 0 {
			value2, ok2 := count_map[60-each]
			if ok2 {
				result += value2
			}
		}

		count_map[each] = value + 1
	}

	return result
}

func main() {
	// 3
	fmt.Println(numPairsDivisibleBy60([]int{30, 20, 150, 100, 40}))
	// 3
	fmt.Println(numPairsDivisibleBy60([]int{60, 60, 60}))
}
