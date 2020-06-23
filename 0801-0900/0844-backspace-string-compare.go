package main

import (
	"fmt"
)

func scanString(s string) ([]byte, int) {
	si, sLen := 0, len(s)
	siArr := make([]byte, sLen)
	for i := 0; i < sLen; i++ {
		if s[i] == '#' {
			si--
			if si < 0 {
				si = 0
			}
		} else {
			siArr[si] = s[i]
			si++
		}
	}
	return siArr, si
}

func backspaceCompare(S string, T string) bool {
	s, si := scanString(S)
	t, ti := scanString(T)
	if si != ti {
		return false
	}
	for i := 0; i < si; i++ {
		if s[i] != t[i] {
			return false
		}
	}
	return true
}

func main() {
	// true
	fmt.Println(backspaceCompare("ab#c", "ad#c"))
	// true
	fmt.Println(backspaceCompare("ab##", "c#d#"))
	// true
	fmt.Println(backspaceCompare("a##c", "#a#c"))
	// true
	fmt.Println(backspaceCompare("a#c", "b"))
}
