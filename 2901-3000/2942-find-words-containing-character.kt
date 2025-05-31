
class Solution {
    fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
        val results = mutableListOf<Int>()
        for ((idx, word) in words.withIndex()) {
            if (word.contains(x)) {
                results.add(idx)
            }
        }
        return results
    }
}

fun main() {
    val s = Solution()
    // [0,1]
    println(s.findWordsContaining(arrayOf("leet", "code"), 'e'))
    // [0,2]
    println(s.findWordsContaining(arrayOf("abc", "bcd", "aaaa", "cbc"), 'a'))
}