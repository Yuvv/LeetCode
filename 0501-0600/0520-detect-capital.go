// 判断句子中的单词是否合法
func detectCapitalUse(word string) bool {
	wordLen := len(word)
	for i := 0; i < wordLen; i++ {
		if isLowercase(word[i]) {
			for i += 1; i < wordLen; i++ {
				if !isLowercase(word[i]) {
					return false
				}
			}
		} else if isUppercase(word[i]) {
			i++
            if i >= wordLen {
                continue
            } else if isUppercase(word[i]) {
				for i += 1; i < wordLen; i++ {
					if !isUppercase(word[i]) {
						return false
					}
				}
			} else if isLowercase(word[i]) {
				for i += 1; i < wordLen; i++ {
					if !isLowercase(word[i]) {
						return false
					}
				}
			}
		}
	}
	return true
}

func isLowercase(c byte) bool {
	return c >= 'a' && c <= 'z'
}

func isUppercase(c byte) bool {
	return c >= 'A' && c <= 'Z'
}