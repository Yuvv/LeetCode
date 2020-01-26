/*
 * Filename: 1323-maximum-69-number.go
 * Created Date: 2020/01/26
 * Author: Yuvv <yuvv_th@outlook.com>
 */
package main

import (
	"fmt"
	"math"
)

func maximum69Number (num int) int {
	result := 0
	lastPow, pow := -1.0, 0.0
	for num > 0 {
		remainder := num % 10
		num /= 10
		if remainder == 6 {
			result += 9 * int(math.Pow(10, pow))
			if lastPow >= 0 {
				result -= 3 * int(math.Pow(10, lastPow))
			}
			lastPow = pow
		} else {
			result += 9 * int(math.Pow(10, pow))
		}
		pow++
	}
	return result
}

func main() {
	// 9969 expected
	fmt.Println(maximum69Number(9669))
	// 9999 expected
	fmt.Println(maximum69Number(9999))
	// 9999 expected
	fmt.Println(maximum69Number(9996))
}