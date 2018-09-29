// 判断回文串，忽略大小写，只看字母和数字（条件贼恶心）
func isPalindrome(s string) bool {
    begin, end := 0, len(s) - 1
    for begin < end {
        for begin < end {
            if (s[begin] >= 'A' && s[begin] <= 'Z') || (s[begin] >= 'a' && s[begin] <= 'z') || (s[begin] >= '0' && s[begin] <= '9') {
                break;
            }
            begin++
        }
        for begin < end {
            if (s[end] >= 'A' && s[end] <= 'Z') || (s[end] >= 'a' && s[end] <= 'z') || (s[end] >= '0' && s[end] <= '9') {
                break;
            }
            end--
        }
        if (s[begin] >= '0' && s[begin] <= '9' || s[end] >= '0' && s[end] <= '9') && s[end] != s[begin] {
            return false
        } else if s[begin] != s[end] && s[begin] - 32 != s[end] && s[begin] + 32 != s[end] {
            return false
        }
        begin++
        end--
    }
    return true
}
