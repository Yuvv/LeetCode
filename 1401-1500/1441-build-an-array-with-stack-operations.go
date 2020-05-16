package main

import (
	"fmt"
)


func buildArray(target []int, n int) []string {
	targetLen := len(target)
	result := make([]string, 0, targetLen)
	tPos, iPos := 0, 1
	for tPos < targetLen /* && iPos <= n */ {
		if target[tPos] == iPos {
			result = append(result, "Push")
			tPos++
		} else {
			result = append(result, "Push", "Pop")
		}
		iPos++
	}
	return result
}


func main() {
	// ["Push","Push","Pop","Push"]
	fmt.Println(buildArray([]int{1, 3}, 3))
	// ["Push","Push","Push"]
	fmt.Println(buildArray([]int{1, 2, 3}, 3))
	// ["Push","Pop","Push","Push","Push"]
	fmt.Println(buildArray([]int{2, 3, 4}, 4))
}