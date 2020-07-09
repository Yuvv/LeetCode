package main

import (
	"fmt"
)

func xorOperation(n int, start int) int {
	r := start
	for i := 1; i < n; i++ {
		r ^= (start + 2*i)
	}
	return r
}

func main() {
	// 8
	fmt.Println(xorOperation(5, 0))
	// 8
	fmt.Println(xorOperation(4, 3))
	// 7
	fmt.Println(xorOperation(1, 7))
	// 2
	fmt.Println(xorOperation(10, 5))
}
