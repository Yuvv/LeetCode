package main

import "fmt"

func getMaximumGenerated(n int) int {
	if n <= 0 {
		return 0
	}
	max := 1
	arr := make([]int, n+1)
	arr[0] = 0
	arr[1] = 1
	even, odd := 0, 1
	i := 1
	for even < n && odd < n {
		even = 2 * i
		odd = even + 1
		if even <= n {
			arr[even] = arr[i]
			if arr[even] > max {
				max = arr[even]
			}
		}
		if odd <= n {
			arr[odd] = arr[i] + arr[i+1]
			if arr[odd] > max {
				max = arr[odd]
			}
		}
		i++
	}
    return max
}


func main() {
	// 3
	fmt.Println(getMaximumGenerated(7))
	// 1
	fmt.Println(getMaximumGenerated(2))
}