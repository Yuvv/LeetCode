// 判断是否可以通过一个字符串创建另一个字符串
// https://leetcode.com/problems/ransom-note/description/
func canConstruct(ransomNote string, magazine string) bool {
    aLen := len(ransomNote)
    bLen := len(magazine)
    if aLen > bLen {
        return false
    }
    m := make(map[byte]int)
    for i := 0; i < bLen; i++ {
        v, ok := m[magazine[i]]
        if ok {
            m[magazine[i]] = v + 1
        } else {
            m[magazine[i]] = 1
        }
    }
    for i := 0; i < aLen; i++ {
        v, ok := m[ransomNote[i]]
        if ok && v > 0 {
            m[ransomNote[i]] = v - 1
        } else {
            return false
        }
    }
    return true
}