package main

import "fmt"

func threeConsecutiveOdds(arr []int) bool {
	nLen := len(arr)
	if nLen < 3 {
		return false
	}
	searchEnd := nLen - 2
	i := 0
	for i < searchEnd {
		if (arr[i+2] & 1) == 0 {
			i += 3
		} else if (arr[i+1] & 1) == 0 {
			i += 2
		} else if (arr[i] & 1) == 0 {
			i += 1
		} else {
			return true
		}
	}

	return false
}

func main() {
	// false
	fmt.Println(threeConsecutiveOdds([]int{2, 6, 4, 1}))
	// true
	fmt.Println(threeConsecutiveOdds([]int{11, 2, 34, 3, 4, 5, 7, 23, 12}))
}
