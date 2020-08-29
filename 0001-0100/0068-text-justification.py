#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0068-text-justification.py
# @Date   : 2020/08/29
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    def justFillIt(self, cur_words: List[str], max_width: int, cur_width: int, is_last_line: bool = False):
        words_count = len(cur_words)
        padding_width = max_width - cur_width
        if is_last_line:
            padding_space_len = max_width - cur_width - words_count + 1
            return ' '.join(cur_words) + (' ' * padding_space_len)

        if words_count == 1:
            return cur_words[0] + (' ' * padding_width)

        padding_space_len = int(padding_width / (words_count - 1))
        padding_space = ' ' * padding_space_len
        padding_space_to_add = padding_width - padding_space_len * (words_count - 1)

        rs = []
        for i in range(words_count):
            rs.append(cur_words[i])
            if padding_space_to_add > 0:
                padding_space_to_add -= 1
                rs.append(padding_space + ' ')
            else:
                rs.append(padding_space)
        return ''.join(rs[:-1])

    def fullJustify(self, words: List[str], max_width: int) -> List[str]:
        begin = 0
        cur_width = 0
        r_list = []
        words_len = len(words)
        for i in range(words_len):
            e_len = len(words[i])
            cur_width += e_len
            if cur_width + (i - begin) > max_width:
                r_list.append(self.justFillIt(words[begin:i], max_width, cur_width - e_len))
                cur_width = e_len
                begin = i
            elif cur_width + (i - begin) == max_width:
                r_list.append(self.justFillIt(words[begin:i + 1], max_width, cur_width))
                cur_width = 0
                begin = i + 1
            # deal with last line
            if begin < words_len and i == words_len - 1:
                r_list.append(self.justFillIt(words[begin:], max_width, cur_width, True))

        return r_list


if __name__ == "__main__":
    s = Solution()
    # [
    # "This    is    an", "example  of text", "justification.  "
    # ]
    print(s.fullJustify(["This", "is", "an", "example", "of", "text", "justification."], 16))

    # [
    # "What   must   be", "acknowledgment  ", "shall be        "
    # ]
    print(s.fullJustify(["What", "must", "be", "acknowledgment", "shall", "be"], 16))

    # [
    # "Science  is  what we", "understand      well", "enough to explain to",
    # "a  computer.  Art is", "everything  else  we", "do                  "
    # ]
    print(
        s.fullJustify([
            "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.",
            "Art", "is", "everything", "else", "we", "do"
        ], 20))

    # ["ask   not   what","your country can","do  for  you ask","what  you can do","for your country"]
    print(
        s.fullJustify([
            "ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do",
            "for", "your", "country"
        ], 16))
