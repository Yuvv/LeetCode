package main

import (
	"fmt"
)

func thousandSeparator(n int) string {
	if n == 0 {
		return "0"
	}
	str := ""
	for n > 0 {
		remainder := n % 1000
		n /= 1000
		if n > 0 {
			str = fmt.Sprintf(".%03d", remainder) + str
		} else {
			str = fmt.Sprintf("%d", remainder) + str
		}
	}
	return str
}

func main() {
	// 0
	fmt.Println(thousandSeparator(0))
	// 998
	fmt.Println(thousandSeparator(998))
	// 1.234
	fmt.Println(thousandSeparator(1234))
	// 10.050
	fmt.Println(thousandSeparator(10050))
}
