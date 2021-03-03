package main

import (
	"fmt"
)

func swapVal(nums []int, begin, end int) {
	tmp := nums[end]
	nums[end] = nums[begin]
	nums[begin] = tmp
}

func findKthLargest(nums []int, k int) int {
	nLen := len(nums)
	targetIndex := k - 1
	begin, end := 0, nLen-1
	preValIdx := -1
	for preValIdx != targetIndex {
		val := nums[(begin+end)/2]
		for begin < end {
			for begin < end && nums[begin] > val {
				begin++
			}
			for begin < end && nums[end] < val {
				end--
			}
			// swap values
			if begin < end {
				swapVal(nums, begin, end)
			}
			// deal with duplicated values
			if begin < end && nums[begin] == val && nums[end] == val {
				i := begin + 1
				for i < end && nums[i] == val {
					i++
				}
				if i < end {
					swapVal(nums, begin, i)
				} else {
					if begin <= targetIndex && end >= targetIndex {
						begin = targetIndex
						end = targetIndex
					} else {
						if begin < k {
							begin = end
						} else {
							end = begin
						}
					}
				}
			}
		}
		// set value
		nums[begin] = val

		// sort sub arrays
		curValIdx := begin
		if begin > targetIndex {
			if preValIdx >= 0 {
				if preValIdx < targetIndex {
					end = begin - 1
					begin = preValIdx + 1
					// 此时不用变了
					curValIdx = preValIdx
				} else {
					if preValIdx > begin {
						end = begin - 1
					} else {
						end = preValIdx - 1
						// 此时不用变了
						curValIdx = preValIdx
					}
					begin = 0
				}
			} else {
				end = begin - 1
				begin = 0
			}
		} else if begin < targetIndex {
			if preValIdx >= 0 {
				if preValIdx > targetIndex {
					end = preValIdx - 1
					begin = begin + 1
					// 此时不用变了
					curValIdx = preValIdx
				} else {
					end = nLen - 1
					if preValIdx > begin {
						begin = preValIdx + 1
						// 此时不用变了
						curValIdx = preValIdx
					} else {
						begin = begin + 1
					}
				}
			} else {
				begin = begin + 1
				end = nLen - 1
			}
		}
		preValIdx = curValIdx
	}
	return nums[targetIndex]
}

func main() {
	// 5 expected
	fmt.Println(findKthLargest([]int{3, 2, 1, 5, 6, 4}, 2))
	// 4 expected
	fmt.Println(findKthLargest([]int{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4))
	// 2 expected
	fmt.Println(findKthLargest([]int{3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6}, 20))
}
