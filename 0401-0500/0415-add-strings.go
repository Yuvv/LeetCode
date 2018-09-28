func setSumaAndCarry(s *uint8, c *uint8) {
	if *s > '9' {
		*c = 1
		*s -= 10
	} else {
		*c = 0
	}
}

/**
 * 求字符串整数之和
 * https://leetcode.com/problems/add-strings/description/
 */
func addStrings(num1 string, num2 string) string {
	i, j := len(num1) - 1, len(num2) - 1
	var carry, sum uint8 = 0, 0
	var result string
	for i >= 0 && j >= 0 {
		sum = num1[i] + num2[j] + carry - '0'
		setSumaAndCarry(&sum, &carry)
		result = string(sum) + result
		i--
		j--
	}

	for i >= 0 {
		sum = num1[i] + carry
		setSumaAndCarry(&sum, &carry)
		result = string(sum) + result
		i--
	}

	for j >= 0 {
		sum = num2[j] + carry
		setSumaAndCarry(&sum, &carry)
		result = string(sum) + result
		j--
	}

    if carry != 0 {
		result = string(carry + '0') + result
	}

	return result
}