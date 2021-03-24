package main

import "fmt"

func countOdds(low int, high int) int {
	diff := (high - low) / 2
	lowIsEven := low%2 == 0
	highIsEven := high%2 == 0
	if lowIsEven && highIsEven {
		return diff
	}
	return diff + 1
}

func main() {
	// 3
	fmt.Println(countOdds(3, 7))
	// 1
	fmt.Println(countOdds(8, 10))
}
