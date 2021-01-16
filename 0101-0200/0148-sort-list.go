package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

// 利用快排的思想，每次构建前缀链表和后缀链表，然后拼接起来
func quickSortList(head *ListNode, tail *ListNode) (*ListNode, *ListNode) {
	if head == tail {
		return head, tail
	}
	var leftHead, leftTail *ListNode = nil, nil
	var rightHead, rightTail *ListNode = nil, nil
	targetNode := head
	cur := head.Next
	targetNode.Next = nil
	var curNext *ListNode
	for cur != nil {
		curNext = cur.Next
		if cur.Val < targetNode.Val {
			if leftHead == nil {
				leftHead = cur
				leftTail = cur
			} else {
				leftTail.Next = cur
				leftTail = leftTail.Next
			}
			// 注意这里一定要切断
			leftTail.Next = nil
		} else {
			if rightHead == nil {
				rightHead = cur
				rightTail = cur
			} else {
				rightTail.Next = cur
				rightTail = rightTail.Next
			}
			// 注意这里一定要切断
			rightTail.Next = nil
		}
		cur = curNext
	}
	if leftHead != nil && leftTail != nil {
		leftHead, leftTail = quickSortList(leftHead, leftTail)
		leftTail.Next = targetNode
	} else {
		leftHead = targetNode
	}
	if rightHead != nil && rightTail != nil {
		rightHead, rightTail = quickSortList(rightHead, rightTail)
		targetNode.Next = rightHead
	} else {
		rightTail = targetNode
	}

	return leftHead, rightTail
}

func sortList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	tail := head
	for tail.Next != nil {
		tail = tail.Next
	}

	finalHead, _ := quickSortList(head, tail)
	return finalHead
}

func printLinkedList(head *ListNode) {
	for head != nil {
		fmt.Print(head.Val)
		fmt.Print("->")
		head = head.Next
	}
	fmt.Println()
}

func main() {
	// node1
	node1 := ListNode{6, &ListNode{3, nil}}
	printLinkedList(sortList(&node1))
	// node1
	node := ListNode{1, &ListNode{3, &ListNode{2, nil}}}
	printLinkedList(sortList(&node))
	// node2
	node2 := ListNode{4, &ListNode{2, &ListNode{1, &ListNode{3, nil}}}}
	printLinkedList(sortList(&node2))
	// node3
	node3 := ListNode{-1, &ListNode{5, &ListNode{3, &ListNode{4, &ListNode{0, nil}}}}}
	printLinkedList(sortList(&node3))
	// node4
	node4 := ListNode{1, &ListNode{5, &ListNode{2, &ListNode{1, nil}}}}
	printLinkedList(sortList(&node4))
	// node5
	node5 := ListNode{9, &ListNode{1, &ListNode{2, &ListNode{9, &ListNode{1, nil}}}}}
	printLinkedList(sortList(&node5))
	// node6 [4,19,14,5,-3,1,8,5,11,15]
	node6 := ListNode{4, &ListNode{19, &ListNode{14, &ListNode{5, &ListNode{-3,
		&ListNode{1, &ListNode{8, &ListNode{5, &ListNode{11, &ListNode{15, nil}}}}}}}}}}
	printLinkedList(sortList(&node6))
}
