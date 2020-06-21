package main

import (
	"fmt"
	"strings"
)

func lengthLongestPath(input string) int {
	// 先添加换行，作为结束符号
	input = input + "\n"
	strLen := len(input)
	// 长度栈
	stack := make([]int, 100)
	stack[0] = -1

	stackPos := 1     // 栈当前可以写入的位置
	curMaxLen := 0    // 最大长度
	lastDirBegin := 0 // 上一个目录开始位置
	for i := 0; i < strLen; i++ {
		if input[i] == '\n' {
			// 最后加1是加的间隔符
			curLen := i - lastDirBegin + stack[stackPos-1] + 1
			name := input[lastDirBegin:i]
			lastDirBegin = i + 1
			if strings.Contains(name, ".") {
				// is file
				if curLen > curMaxLen {
					curMaxLen = curLen
				}
			} else {
				// is dir
				stack[stackPos] = curLen
			}
			stackPos = 1
		} else if input[i] == '\t' {
			stackPos++
			lastDirBegin++
		}
	}
	// 最大长度=目录+文件名长度再加上目录间隔符个数
	return curMaxLen
}

func main() {
	// 20 expected
	fmt.Println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"))
	// 32 expected
	fmt.Println(lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"))
	// 27 expecetd
	fmt.Println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext\naaaaaaaaaaaaaaaaaaaaa\n\ta.exe"))
}
