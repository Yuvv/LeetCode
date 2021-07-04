package main

import (
	"fmt"
	"math"
)

func constructRectangle(area int) []int {
	w := int(math.Sqrt(float64(area)))

	for area%w != 0 {
		w--
	}
	l := area / w
	return []int{l, w}
}

func main() {
	// [2,2]
	fmt.Println(constructRectangle(4))
	// [37,1]
	fmt.Println(constructRectangle(37))
	// [427,286]
	fmt.Println(constructRectangle(122122))
}
