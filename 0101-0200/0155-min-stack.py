class MinStack:
    """
    实现一个最小栈
    https://leetcode.com/problems/min-stack/description/
    """
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = list()
        self.min_index = list()

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        self.stack.append(x)
        if len(self.min_index) == 0:
            self.min_index.append(0)
        elif self.stack[self.min_index[-1]] > x:
            self.min_index.append(len(self.stack) - 1)

    def pop(self):
        """
        :rtype: void
        """
        if len(self.stack) == 0:
            return
        if self.min_index[-1] == len(self.stack) - 1:
            del self.min_index[-1]
        del self.stack[-1]

    def top(self):
        """
        :rtype: int
        """
        if len(self.stack) == 0:
            return
        return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        if len(self.stack) == 0:
            return
        return self.stack[self.min_index[-1]]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()