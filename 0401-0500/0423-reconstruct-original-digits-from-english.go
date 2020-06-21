package main

import (
	"fmt"
	"sort"
	"strconv"
	"strings"
)

func decreaseMap(s map[int32]int, key int32, defaultWhenAbsent int) {
	v, ok := s[key]
	if !ok {
		s[key] = defaultWhenAbsent
		v = defaultWhenAbsent
	}
	s[key] = v - 1
}

func increaseMap(s map[int32]int, key int32, defaultWhenAbsent int) {
	v, ok := s[key]
	if !ok {
		s[key] = defaultWhenAbsent
		v = defaultWhenAbsent
	}
	s[key] = v + 1
}

func originalDigits(s string) string {
	alphabetMap := make(map[int32]int)
	resultArr := make([]int, 0)
	// 第一遍剔除 z=0, w=2, u=4, x=6, g=8
	for _, c := range s {
		if c == 'z' {
			decreaseMap(alphabetMap, 'e', 0)
			decreaseMap(alphabetMap, 'r', 0)
			decreaseMap(alphabetMap, 'o', 0)
			// 0
			resultArr = append(resultArr, 0)
		} else if c == 'w' {
			decreaseMap(alphabetMap, 't', 0)
			decreaseMap(alphabetMap, 'o', 0)
			// 2
			resultArr = append(resultArr, 2)
		} else if c == 'u' {
			decreaseMap(alphabetMap, 'f', 0)
			decreaseMap(alphabetMap, 'o', 0)
			decreaseMap(alphabetMap, 'r', 0)
			// 4
			resultArr = append(resultArr, 4)
		} else if c == 'x' {
			decreaseMap(alphabetMap, 's', 0)
			decreaseMap(alphabetMap, 'i', 0)
			// 6
			resultArr = append(resultArr, 6)
		} else if c == 'g' {
			decreaseMap(alphabetMap, 'e', 0)
			decreaseMap(alphabetMap, 'i', 0)
			decreaseMap(alphabetMap, 'g', 0)
			decreaseMap(alphabetMap, 'h', 0)
			decreaseMap(alphabetMap, 't', 0)
			// 8
			resultArr = append(resultArr, 8)
		} else {
			increaseMap(alphabetMap, c, 0)
		}
	}
	// 第二遍剔除 o=1, r=3, s=7
	if _, ok := alphabetMap['o']; ok {
		for alphabetMap['o'] > 0 {
			alphabetMap['o'] -= 1
			alphabetMap['n'] -= 1
			alphabetMap['e'] -= 1
			// 1
			resultArr = append(resultArr, 1)
		}
	}
	if _, ok := alphabetMap['r']; ok {
		for alphabetMap['r'] > 0 {
			alphabetMap['t'] -= 1
			alphabetMap['h'] -= 1
			alphabetMap['r'] -= 1
			alphabetMap['e'] -= 2
			// 3
			resultArr = append(resultArr, 3)
		}
	}
	if _, ok := alphabetMap['s']; ok {
		for alphabetMap['s'] > 0 {
			alphabetMap['s'] -= 1
			alphabetMap['e'] -= 2
			alphabetMap['v'] -= 1
			alphabetMap['n'] -= 1
			// 7
			resultArr = append(resultArr, 7)
		}
	}
	// 第三遍剔除 v=5, n=9
	if _, ok := alphabetMap['v']; ok {
		for alphabetMap['v'] > 0 {
			alphabetMap['f'] -= 1
			alphabetMap['i'] -= 1
			alphabetMap['v'] -= 1
			alphabetMap['e'] -= 1
			// 5
			resultArr = append(resultArr, 5)
		}
	}
	if _, ok := alphabetMap['n']; ok {
		for alphabetMap['n'] > 0 {
			alphabetMap['n'] -= 2
			alphabetMap['i'] -= 1
			alphabetMap['e'] -= 1
			// 9
			resultArr = append(resultArr, 9)
		}
	}
	sort.Ints(resultArr)
	resultStrArr := make([]string, len(resultArr))
	for i, each := range resultArr {
		resultStrArr[i] = strconv.Itoa(each)
	}
	return strings.Join(resultStrArr, "")
}

func main() {
	// 012
	fmt.Println(originalDigits("owoztneoer"))
	// 45
	fmt.Println(originalDigits("fviefuro"))
	// 01279
	fmt.Println(originalDigits("owoztnseeoveernnine"))
}
