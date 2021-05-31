/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func sortedListToBST(head *ListNode) *TreeNode {
    nodes := make([]int, 0)
    for head != nil {
        nodes = append(nodes, head.Val)
        head = head.Next
    }
    return sortedArrayToBST(nodes)
}

 func sortedArrayToBST(nums []int) *TreeNode {
    if len(nums) == 0 {
        return nil
    } else if len(nums) == 1 {
        return &(TreeNode{nums[0], nil, nil})
    }
    return arrToBST(nums, 0, len(nums) - 1)
}

func arrToBST(nums []int, begin int, end int) *TreeNode {
    if begin > end {
        return nil
    } else if begin == end {
        return &(TreeNode{nums[begin], nil, nil})
    }
    mid := (begin + end) / 2
    node := TreeNode{nums[mid], nil, nil}
    node.Left = arrToBST(nums, begin, mid - 1)
    node.Right = arrToBST(nums, mid + 1, end)
    return &node
}