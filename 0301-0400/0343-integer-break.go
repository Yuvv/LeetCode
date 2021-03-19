package main

import "fmt"

var RESULT_CACHE map[int]int = make(map[int]int)

func integerBreak(n int) int {
	if n == 1 {
		return 1
	}
	mx := 0
	var ok bool
	var v1, v2 int
	var r int
	for i := 1; i < n; i++ {
		v1, ok = RESULT_CACHE[i]
		if !ok {
			v1 = integerBreak(i)
			RESULT_CACHE[i] = v1
		}
		if i > v1 {
			v1 = i
		}
		v2, ok = RESULT_CACHE[n-i]
		if !ok {
			v2 = integerBreak(n - i)
			RESULT_CACHE[n-i] = v2
		}
		if n-i > v2 {
			v2 = n - i
		}
		r = v1 * v2
		if r > mx {
			mx = r
		}
	}
	return mx
}

func main() {
	// 1 expected
	fmt.Println(integerBreak(2))
	// 36 expected
	fmt.Println(integerBreak(10))
	// 18 expected
	fmt.Println(integerBreak(8))
}
