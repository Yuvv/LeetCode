package main

import (
	"fmt"
)

func finalPrices(prices []int) []int {
	nLen := len(prices)
	for i := 0; i < nLen; i++ {
		for j := i + 1; j < nLen; j++ {
			if prices[j] <= prices[i] {
				prices[i] -= prices[j]
				break
			}
		}
	}
	return prices
}

func main() {
	// [1,2,3,4,5] expected
	fmt.Println(finalPrices([]int{1, 2, 3, 4, 5}))
	// [9,0,1,6] expected
	fmt.Println(finalPrices([]int{10, 1, 1, 6}))
}
