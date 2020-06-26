package main

import (
	"fmt"
)

func toHex(num int) string {
	if num == 0 {
		return "0"
	}
	var ui32Num uint32
	if num > 0 {
		ui32Num = uint32(num)
	} else {
		ui32Num = ^uint32(-num) + 1
	}

	rstr := ""
	var remainder uint32
	for ui32Num > 0 {
		remainder = ui32Num % 16
		ui32Num >>= 4
		if remainder >= 10 {
			rstr = string('a'+remainder-10) + rstr
		} else {
			rstr = string('0'+remainder) + rstr
		}
	}
	return rstr
}

func main() {
	// 1a
	fmt.Println(toHex(26))
	// ffffffff
	fmt.Println(toHex(-1))
	// 6f86c
	fmt.Println(toHex(456812))
	// fff90794
	fmt.Println(toHex(-456812))
}
