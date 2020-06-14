package main

import (
	"fmt"
	"sort"
	"strings"
)

func arrangeWords(text string) string {
	words := strings.Split(text, " ")
	words[0] = strings.ToLower(words[0])
	sort.SliceStable(words, func(i, j int) bool {
		return len(words[i]) < len(words[j])
	})
	words[0] = string(words[0][0] - 32) + words[0][1:]
	return strings.Join(words, " ")
}

func main() {
	// "Is cool leetcode"  expected
	fmt.Println(arrangeWords("Leetcode is cool"))
	// "On and keep calm code"  expected
	fmt.Println(arrangeWords("Keep calm and code on"))
	// "A day it's nice"  expected
	fmt.Println(arrangeWords("It's a nice day"))
	// "Gbo ops jgi jry jtik ojkew rjazc ufvledv bomoeqt titttcu zdhvbpbb hrzrvhbmk cfhmiqwonj zczmepdfpm"  expected
	fmt.Println(arrangeWords("Jtik hrzrvhbmk gbo cfhmiqwonj ojkew ufvledv bomoeqt ops jgi zdhvbpbb zczmepdfpm jry rjazc titttcu"))
}
