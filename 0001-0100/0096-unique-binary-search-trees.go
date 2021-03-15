package main

import "fmt"

func recurisiveNumTrees(n int, cache *map[int]int) int {
	if n == 1 || n == 0 {
		return 1
	}
	v, ok := (*cache)[n]
	if ok {
		return v
	}
	var r, l int
	result := 0
	for i := 0; i < n; i++ {
		r, ok = (*cache)[i]
		if !ok {
			r = recurisiveNumTrees(i, cache)
			(*cache)[i] = r
		}
		ln := n - 1 - i
		l, ok = (*cache)[ln]
		if !ok {
			l = recurisiveNumTrees(ln, cache)
			(*cache)[ln] = l
		}
		result += r * l
	}
	(*cache)[n] = result
	return result
}

func numTrees(n int) int {
	m := make(map[int]int, n)
	return recurisiveNumTrees(n, &m)
}

func main() {
	// 5 expected
	fmt.Println(numTrees(3))
	// 1 expected
	fmt.Println(numTrees(1))
	// 2 expected
	fmt.Println(numTrees(2))
}
