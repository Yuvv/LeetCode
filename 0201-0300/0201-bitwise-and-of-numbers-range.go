package main

import (
	"fmt"
)

// 找相同的前缀
func rangeBitwiseAnd(m int, n int) int {
	om := m
	i := 0
	for m != n {
		m >>= 1
		n >>= 1
		i++
	}
	return om >> i << i
}

func main() {
	// 4
	fmt.Println(rangeBitwiseAnd(5, 7))
	// 0
	fmt.Println(rangeBitwiseAnd(0, 1))
	// 1024
	fmt.Println(rangeBitwiseAnd(1203, 1304))
	// 0
	fmt.Println(rangeBitwiseAnd(123456, 223654))
}
