// 每 k 个字母翻转一次
func reverseStr(s string, k int) string {
    sLen := len(s)
    str := make([]byte, sLen)
    for i := 0; i < sLen;  {
        begin := i
        end := i + k - 1
        if end >= sLen {
            end = sLen -1
        }
        // first k nums
        for end >= begin {
            str[i] = s[end]
            i++
            end--
        }
        // next k nums
        for i < sLen && i < begin + 2*k {
            str[i] = s[i]
            i++
        }
    }
    return string(str)
}