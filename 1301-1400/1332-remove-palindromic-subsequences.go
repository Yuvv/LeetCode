/*
 * Filename: 1332-remove-palindromic-subsequences.go
 * Created Date: 2020/01/26
 * Author: Yuvv <yuvv_th@outlook.com>
 */
package main

import (
	"fmt"
)

func removePalindromeSub(s string) int {
	sLen := len(s)
	if sLen == 0 {
		return 0
	}
	isPalindrome := true
	begin, end := 0, sLen - 1
	for begin <= end {
		if s[begin] != s[end] {
			isPalindrome = false
		}
		begin++
		end--
	}

	if isPalindrome {
		return 1
	}
	return 2
}


func main() {
	// 1 expected
	fmt.Println(removePalindromeSub("ababa"))
	// 2 expected
	fmt.Println(removePalindromeSub("abb"))
	// 2 expected
	fmt.Println(removePalindromeSub("baabb"))
	// 2 expected
	fmt.Println(removePalindromeSub("bbaab"))
	// 0 expected
	fmt.Println(removePalindromeSub(""))
}

