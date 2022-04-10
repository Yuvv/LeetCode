package main

import "fmt"

// 容器接水问题
func maxArea(height []int) int {
	left, right := 0, len(height)-1
	max := 0
	// 用两个指针，遍历一些可能即可
	for left < right {
		if height[left] < height[right] {
			if height[left]*(right-left) > max {
				max = height[left] * (right - left)
			}
			left++
		} else {
			if height[right]*(right-left) > max {
				max = height[right] * (right - left)
			}
			right--
		}
	}
	return max
}

func main() {
	// 49
	fmt.Println(maxArea([]int{1, 8, 6, 2, 5, 4, 8, 3, 7}))
}
