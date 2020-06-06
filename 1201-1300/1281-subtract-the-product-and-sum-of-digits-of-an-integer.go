package main

import (
	"fmt"
)


func subtractProductAndSum(n int) int {
	product := 1
	sum := 0
	for n > 0 {
		remainder := n % 10
		n /= 10
		product *= remainder
		sum += remainder
	}
	return product - sum
}


func main() {
	// 15 expected
	fmt.Println(subtractProductAndSum(234))
	// 32 expected
	fmt.Println(subtractProductAndSum(4421))
}