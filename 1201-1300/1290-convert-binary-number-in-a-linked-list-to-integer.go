package main

import (
	"fmt"
)

/**
 * Definition for singly-linked list.
 */
type ListNode struct {
	Val  int
	Next *ListNode
}

func getDecimalValue(head *ListNode) int {
	result := 0
	for head != nil {
		result = result * 2 + head.Val
		head = head.Next
	}
	return result
}

func main() {
	head := ListNode{1, nil}
	// 1 -> 1 expected
	fmt.Println(getDecimalValue(&head))
	head.Next = &ListNode{0, nil}
	head.Next.Next = &ListNode{0, nil}
	head.Next.Next.Next = &ListNode{1, nil}
	head.Next.Next.Next.Next = &ListNode{0, nil}
	head.Next.Next.Next.Next.Next = &ListNode{0, nil}
	head.Next.Next.Next.Next.Next.Next = &ListNode{1, nil}
	head.Next.Next.Next.Next.Next.Next.Next = &ListNode{1, nil}
	// 10010011 -> 147 expected
	fmt.Println(getDecimalValue(&head))
}
