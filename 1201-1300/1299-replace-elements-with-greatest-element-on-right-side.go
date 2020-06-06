package main

import (
	"fmt"
)

func replaceElements(arr []int) []int {
	arrLen := len(arr)
	lastMax := arr[arrLen - 1]
	arr[arrLen - 1] = -1
	for i := arrLen - 2; i >= 0; i-- {
		curValue := arr[i]
		arr[i] = lastMax
		if curValue > lastMax {
			lastMax = curValue
		}
	}
	return arr
}

func main() {
	// [18,6,6,6,1,-1]  expected
	fmt.Println(replaceElements([]int{17, 18, 5, 4, 6, 1}))
}
