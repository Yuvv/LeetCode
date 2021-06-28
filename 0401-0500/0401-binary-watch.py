#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# @File   : 0401-binary-watch.py
# @Date   : 2021/06/28
# @Author : Yuvv <yuvv_th@outlook.com>

from typing import List


class Solution:
    NUM_HOURS = [['0'], ['1', '2', '4', '8'], ['3', '5', '6', '9', '10'], ['7', '11']]
    NUM_MINUTES = [['00'], ['01', '02', '04', '08', '16', '32'],
                   ['03', '05', '06', '09', '10', '12', '17', '18', '20', '24', '33', '34', '36', '40', '48'],
                   ['07', '11', '13', '14', '19', '21', '22', '25', '26', '28', '35', '37', '38', '41', '42',
                    '44', '49', '50', '52', '56'],
                   ['15', '23', '27', '29', '30', '39', '43', '45', '46', '51', '53', '54', '57', '58'],
                   ['31', '47', '55', '59']]

    def readBinaryWatch(self, turnedOn: int) -> List[str]:
        result = []
        if turnedOn >= 9:
            return result
        for i in range(min(turnedOn + 1, 4)):
            j = turnedOn - i
            if j > 5:
                continue
            for h in Solution.NUM_HOURS[i]:
                for m in Solution.NUM_MINUTES[j]:
                    result.append(h + ':' + m)
        return result


if __name__ == '__main__':
    s = Solution()
    # []
    print(s.readBinaryWatch(9))
    # ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
    print(s.readBinaryWatch(1))
