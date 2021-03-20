package main

import "fmt"

func recursiveCheck(board *[][]byte, word string, sIdx, posRow, posCol int) bool {
	wLen := len(word)
	if sIdx >= wLen {
		return true
	}
	targetChar := word[sIdx]
	if (*board)[posRow][posCol] != targetChar {
		return false
	}
	// mark as used
	(*board)[posRow][posCol] = 0 - targetChar
	// check next character
	sIdx++
	nRows := len(*board)
	nCols := len((*board)[0])

	if posRow > 0 {
		// up
		if recursiveCheck(board, word, sIdx, posRow-1, posCol) {
			// unmark as used
			(*board)[posRow][posCol] = targetChar
			return true
		}
	}
	if posRow < nRows-1 {
		// bottom
		if recursiveCheck(board, word, sIdx, posRow+1, posCol) {
			// unmark as used
			(*board)[posRow][posCol] = targetChar
			return true
		}
	}
	if posCol > 0 {
		// left
		if recursiveCheck(board, word, sIdx, posRow, posCol-1) {
			// unmark as used
			(*board)[posRow][posCol] = targetChar
			return true
		}
	}
	if posCol < nCols-1 {
		// right
		if recursiveCheck(board, word, sIdx, posRow, posCol+1) {
			// unmark as used
			(*board)[posRow][posCol] = targetChar
			return true
		}
	}
	// when only one character
	if sIdx >= wLen {
		// unmark as used
		(*board)[posRow][posCol] = targetChar
		return true
	}
	// unmark as used
	(*board)[posRow][posCol] = targetChar
	return false
}

func exist(board *[][]byte, word string) bool {
	nRows := len(*board)
	nCols := len((*board)[0])
	var r bool
	for i := 0; i < nRows; i++ {
		for j := 0; j < nCols; j++ {
			r = recursiveCheck(board, word, 0, i, j)
			if r {
				return true
			}
		}
	}

	return false
}

func findWords(board [][]byte, words []string) []string {
	result := make([]string, 0)

	for _, eachWord := range words {
		if exist(&board, eachWord) {
			result = append(result, eachWord)
		}
	}

	return result
}

func main() {
	// AbcD
	fmt.Println(findWords([][]byte{{'A', 'b', 'c'}, {'b', 'c', 'D'}}, []string{"AbcD"}))
	// []
	fmt.Println(findWords([][]byte{{'A', 'b', 'c'}, {'b', 'c', 'D'}}, []string{"Abcc"}))
	// A
	fmt.Println(findWords([][]byte{{'A'}}, []string{"A"}))
}
