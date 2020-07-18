package main

import (
	"fmt"
	"strings"
)

var MONTH_MAP = map[string]string{
	"Jan": "01",
	"Feb": "02",
	"Mar": "03",
	"Apr": "04",
	"May": "05",
	"Jun": "06",
	"Jul": "07",
	"Aug": "08",
	"Sep": "09",
	"Oct": "10",
	"Nov": "11",
	"Dec": "12",
}

func reformatDate(date string) string {
	sd := strings.Split(date, " ")
	day := sd[0][:2]
	if len(sd[0]) <= 3 {
		day = "0" + sd[0][:1]
	}
	return sd[2] + "-" + MONTH_MAP[sd[1]] + "-" + day
}

func main() {
	// 2052-10-20
	fmt.Println(reformatDate("20th Oct 2052"))
	// 1933-06-06
	fmt.Println(reformatDate("6th Jun 1933"))
	// 1960-05-26
	fmt.Println(reformatDate("26th May 1960"))
}
