class Solution {
    // Function to find the least absolute difference between any node
    // value of the BST and the given integer.
    static int minDiff(Node root, int K) {
        // Write your code here
        Node curr = root;
        int ans = Integer.MAX_VALUE;
        while (curr != null) {
            ans = Math.min(ans, Math.abs(K - curr.data));
            if(curr.data == K) return 0;
            else if (curr.data < K) curr = curr.right;
            else curr = curr.left;
        }
        return ans;
    }
}
