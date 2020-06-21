package main

import (
	"fmt"
	"strconv"
	"strings"
)

var resultArr []string
var sLen int

func recursiveRestoreIpAddresses(s string, fromIndex int, prevArr []string, count int) {
	if fromIndex >= sLen {
		return
	}
	if count == 3 {
		if sLen-fromIndex > 3 {
			return
		}
		prevArr[count] = s[fromIndex:]
		if len(prevArr[count]) > 1 && prevArr[count][0] == '0' {
			return
		}
		if v, _ := strconv.Atoi(prevArr[count]); v <= 255 {
			resultArr = append(resultArr, strings.Join(prevArr, "."))
		}
	} else {
		// 1
		prevArr[count] = s[fromIndex : fromIndex+1]
		recursiveRestoreIpAddresses(s, fromIndex+1, prevArr, count+1)
		// 2
		if fromIndex+2 < sLen {
			prevArr[count] = s[fromIndex : fromIndex+2]
			if prevArr[count][0] != '0' {
				recursiveRestoreIpAddresses(s, fromIndex+2, prevArr, count+1)
			}
		}
		// 3
		if fromIndex+3 < sLen {
			prevArr[count] = s[fromIndex : fromIndex+3]
			if prevArr[count][0] != '0' {
				if v, _ := strconv.Atoi(prevArr[count]); v <= 255 {
					recursiveRestoreIpAddresses(s, fromIndex+3, prevArr, count+1)
				}
			}
		}
	}
}

func restoreIpAddresses(s string) []string {
	resultArr = make([]string, 0)
	sLen = len(s)
	recursiveRestoreIpAddresses(s, 0, make([]string, 4), 0)
	return resultArr
}

func main() {
	// ["255.255.11.135", "255.255.111.35"]  expected
	fmt.Println(restoreIpAddresses("25525511135"))
	// ["1.213.14.15","1.213.141.5","12.13.14.15","12.13.141.5","12.131.4.15","12.131.41.5","121.3.14.15","121.3.141.5","121.31.4.15","121.31.41.5"]  expected
	fmt.Println(restoreIpAddresses("12131415"))
	// ["1.2.3.4"]  expected
	fmt.Println(restoreIpAddresses("1234"))
	// ["111.222.255.100"]  expected
	fmt.Println(restoreIpAddresses("111222255100"))
	// ["0.10.0.10","0.100.1.0"]  expected  哪有这样搞得。。。。
	fmt.Println(restoreIpAddresses("010010"))
}
