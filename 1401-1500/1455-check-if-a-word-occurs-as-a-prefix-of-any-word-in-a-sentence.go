package main

import (
	"fmt"
)

func isPrefixOfWord(sentence string, searchWord string) int {
	wordCount := 0
	searchIndex := 0
	iterIndex := 0
	sLen := len(sentence)
	wLen := len(searchWord)
	for iterIndex < sLen {
		wordCount++
		searchIndex = 0
		for searchIndex < wLen && sentence[iterIndex] != ' ' {
			if sentence[iterIndex] != searchWord[searchIndex] {
				for iterIndex < sLen && sentence[iterIndex] != ' ' {
					iterIndex++
				}
				break
			}
			iterIndex++
			searchIndex++
		}
		if searchIndex >= wLen {
			return wordCount
		}
		// 句子中的单词长度小于搜索单词长度时被提前截断，需要再+1
		if iterIndex < sLen && sentence[iterIndex] == ' ' {
			iterIndex++
		}
	}

	return -1
}

func main() {
	// `4` expected
	fmt.Println(isPrefixOfWord("i love eating burger", "burg"))
	// `2` expedcted
	fmt.Println(isPrefixOfWord("this problem is an easy problem", "pro"))
	// `-1` expedcted
	fmt.Println(isPrefixOfWord("hello from the other side", "ther"))
	// `3` expedcted
	fmt.Println(isPrefixOfWord("go is good", "good"))
}