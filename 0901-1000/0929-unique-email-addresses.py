from typing import List

class Solution:
    """
    email去重
    https://leetcode.com/problems/unique-email-addresses/
    """
    def numUniqueEmails(self, emails: List[str]) -> int:
        s = set()
        for email in emails:
            s.add(self.stripEmail(email))
        return len(s)

    def stripEmail(self, email: str) -> str:
        email_len = len(email)
        index = 0
        result = []
        while index < email_len and email[index] != '@':
            if email[index] == '+':
                break
            if email[index] == '.':
                index += 1
                continue
            result.append(email[index])
            index += 1

        pos = len(result)
        index = email_len - 1
        while index > 0 and email[index] != '@':
            result.insert(pos + 1, email[index])
            index -= 1
        result.insert(pos + 1, '@')
        return ''.join(result)


if __name__ == "__main__":
    s = Solution()
    # 2 exected
    print(s.numUniqueEmails(["test.email+alex@leetcode.com",
                             "test.e.m+ail+bob.cathy@leetcode.com",
                             "testemail+david@lee.tcode.com"]))
