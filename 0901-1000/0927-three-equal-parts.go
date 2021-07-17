package main

import "fmt"

func findFirstPossibleJ(arr []int, beg, i int) (bool, int) {
	var j int
	k := i
	jBoundary := i + i - beg + 1
	for j = len(arr) - 1; j > jBoundary && k >= beg; j-- {
		if arr[j] != arr[k] {
			return false, -1
		}
		k--
	}
	if k < beg {
		return true, j + 1
	}
	return false, -1
}

func isMiddleOk(arr []int, i, j int) bool {
	m, n := j-1, len(arr)-1
	for m > i && n >= j {
		if arr[m] != arr[n] {
			return false
		}
		m--
		n--
	}
	for ; m > i; m-- {
		if arr[m] != 0 {
			return false
		}
	}
	for ; n >= j; n-- {
		if arr[n] != 0 {
			return false
		}
	}

	return true
}

func threeEqualParts(arr []int) []int {
	arrLen := len(arr)
	if arr[0] == 0 && arr[arrLen-1] == 0 && isMiddleOk(arr, 0, arrLen-1) {
		return []int{0, arrLen - 1}
	}
	beg := 0
	for beg < arrLen && arr[beg] == 0 {
		beg++
	}
	for i := beg; i < arrLen-2; i++ {
		// find a possible j
		ok, j := findFirstPossibleJ(arr, beg, i)
		if ok {
			for j > i+i-beg+1 {
				if isMiddleOk(arr, i, j) {
					return []int{i, j}
				}
				j--
				if arr[j] != 0 {
					break
				}
			}
		}
	}

	return []int{-1, -1}
}

func main() {
	// [0,4]
	fmt.Println(threeEqualParts([]int{0, 0, 0, 0, 0}))
	// [0,3]
	fmt.Println(threeEqualParts([]int{1, 0, 1, 0, 1}))
	// [-1,-1]
	fmt.Println(threeEqualParts([]int{1, 1, 0, 1, 1}))
	// [0,2]
	fmt.Println(threeEqualParts([]int{1, 1, 0, 0, 1}))
	// [3,6]
	fmt.Println(threeEqualParts([]int{0, 0, 1, 0, 1, 0, 1, 0}))

}
