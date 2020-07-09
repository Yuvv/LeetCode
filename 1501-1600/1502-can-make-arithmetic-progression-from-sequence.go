package main

import (
	"fmt"
	"sort"
)

func canMakeArithmeticProgression(arr []int) bool {
	arrLen := len(arr)
	if arrLen <= 2 {
		return true
	}
	sort.Ints(arr)
	diff := arr[1] - arr[0]
	for i := 2; i < arrLen; i++ {
		if arr[i]-arr[i-1] != diff {
			return false
		}
	}
	return true
}

func main() {
	// true
	fmt.Println(canMakeArithmeticProgression([]int{3, 5, 7, 1}))
	// true
	fmt.Println(canMakeArithmeticProgression([]int{3, 5, 7, 9}))
	// false
	fmt.Println(canMakeArithmeticProgression([]int{1, 2, 4}))
	// true
	fmt.Println(canMakeArithmeticProgression([]int{-68, -96, -12, -40, 16}))
}
