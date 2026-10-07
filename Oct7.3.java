/* Node Structure
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {

    private int maxSum;

    private int leafCount;



    public int maxPathSum(Node root) {

        maxSum = Integer.MIN_VALUE;

        leafCount = 0;



        solve(root);



        // If the tree has fewer than 2 leaf nodes, a leaf-to-leaf path is impossible.

        if (leafCount < 2) {

            return -1;

        }



        return maxSum;

    }



    private int solve(Node node) {

        if (node == null) {

            return 0;

        }



        // Check if current node is a leaf

        if (node.left == null && node.right == null) {

            leafCount++;

            return node.data;

        }



        // Recursively compute max leaf-to-node path sums for left and right subtrees

        int leftSum = solve(node.left);

        int rightSum = solve(node.right);



        // If both children exist, we can form a valid leaf-to-leaf path through this node

        if (node.left != null && node.right != null) {

            maxSum = Math.max(maxSum, leftSum + rightSum + node.data);

            return node.data + Math.max(leftSum, rightSum);

        }



        // If only one child exists, propagate the path sum from the existing child

        return (node.left != null) ? node.data + leftSum : node.data + rightSum;

    }

}
