package main

import (
	"fmt"
	"strings"
)

func stringMatching(words []string) []string {
	wordLen := len(words)
	result := make([]string, 0, wordLen)
	for i := 0; i < wordLen; i++ {
		for j := 0; j < wordLen; j++ {
			if i == j {
				continue
			}
			if strings.Contains(words[j], words[i]) {
				result = append(result, words[i])
				break
			}
		}
	}
	return result
}

func main() {
	// ["as","hero"] expected
	fmt.Println(stringMatching([]string{"mass", "as", "hero", "superhero"}))
	// ["et","code"] expected
	fmt.Println(stringMatching([]string{"leetcode", "et", "code"}))
	// [] expected
	fmt.Println(stringMatching([]string{"blue", "green", "bu"}))
}
