package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func isPalindrome(head *ListNode) bool {
	ptr1 := head
	ptr2 := head
	count := 0
	for ptr2 != nil && ptr2.Next != nil {
		ptr1 = ptr1.Next
		ptr2 = ptr2.Next.Next
		count++
	}
	if ptr2 != nil {
		// 奇数 ptr1 进 1
		ptr1 = ptr1.Next
	}
	// 翻转前面一半
	ptr2 = head
	ptr3 := head
	for count > 0 {
		tmpPtr := ptr3.Next
		ptr3.Next = ptr2
		ptr2 = ptr3
		ptr3 = tmpPtr
		count--
	}

	for ptr1 != nil {
		if ptr1.Val != ptr2.Val {
			return false
		}
		ptr1 = ptr1.Next
		ptr2 = ptr2.Next
	}
	return true
}

func main() {
	// node1
	node := ListNode{1, &ListNode{2, nil}}
	// false
	fmt.Println(isPalindrome(&node))

	// node2
	node2 := ListNode{1, nil}
	// true
	fmt.Println(isPalindrome(&node2))
	// node3
	node3 := ListNode{1, &ListNode{1, nil}}
	// true
	fmt.Println(isPalindrome(&node3))
	// node4
	node4 := ListNode{1, &ListNode{2, &ListNode{2, &ListNode{1, nil}}}}
	// true
	fmt.Println(isPalindrome(&node4))

}
