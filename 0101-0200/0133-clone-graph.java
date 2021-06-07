import java.util.*;


class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

/*
 * 0133-clone-graph.java
 *
 * @author Yuvv <yuvv_th@outlook.com>
 * @date 2021/06/07
 */
public class Solution {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
         Map<Node, Node> oldNewNodeMap = new HashMap<>();
        Node newNode = new Node(node.val);
        oldNewNodeMap.put(node, newNode);
        recursiveClone(node, oldNewNodeMap);

        return newNode;
    }

    public void recursiveClone(Node oldNode, Map<Node, Node> oldNewNodeMap) {
        if (oldNode.neighbors == null || oldNode.neighbors.isEmpty()) {
            return;
        }
        Node newNode = oldNewNodeMap.get(oldNode);
        for (Node curOldNode : oldNode.neighbors) {
            Node curNewNode = oldNewNodeMap.get(curOldNode);
            if (curNewNode == null) {
                curNewNode = new Node(curOldNode.val);
                oldNewNodeMap.put(curOldNode, curNewNode);
                recursiveClone(curOldNode, oldNewNodeMap);
            }
            newNode.neighbors.add(curNewNode);
        }
    }
}