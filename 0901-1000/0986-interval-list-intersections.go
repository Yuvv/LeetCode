package main

import "fmt"

func intervalIntersection(firstList [][]int, secondList [][]int) [][]int {
	result := make([][]int, 0)
	fi := 0
	si := 0
	fLen := len(firstList)
	sLen := len(secondList)
	for si < sLen && fi < fLen {
		if firstList[fi][1] < secondList[si][0] {
			fi++
		} else if firstList[fi][0] > secondList[si][1] {
			si++
		} else {
			// has intersection
			if firstList[fi][0] <= secondList[si][0] {
				if firstList[fi][1] >= secondList[si][1] {
					result = append(result, []int{secondList[si][0], secondList[si][1]})
					si++
				} else {
					result = append(result, []int{secondList[si][0], firstList[fi][1]})
					secondList[si][0] = firstList[fi][1] + 1
					fi++
				}
			} else {
				if firstList[fi][1] <= secondList[si][1] {
					result = append(result, []int{firstList[fi][0], firstList[fi][1]})
					fi++
				} else {
					result = append(result, []int{firstList[fi][0], secondList[si][1]})
					firstList[fi][0] = secondList[si][1] + 1
				}
			}
		}
	}

	return result
}

func main() {
	// [[1,2],[3,3]]
	fmt.Println(intervalIntersection([][]int{{1, 2}, {3, 4}}, [][]int{{1, 3}}))
	// [[3,7]]
	fmt.Println(intervalIntersection([][]int{{1, 7}}, [][]int{{3, 10}}))
	// [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
	fmt.Println(intervalIntersection([][]int{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, [][]int{{1, 5}, {8, 12}, {15, 24}, {25, 26}}))
}
