/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxLevelSum(TreeNode root) {
        int maxsum  = Integer.MIN_VALUE;
        int maxlevel = 1;
        Queue<TreeNode>Q = new LinkedList<>();
        Q.add(root);
        for(int level = 1; !Q.isEmpty(); level++){
            int sum = 0;
            int s = Q.size();
            for(int i = 0; i<s; i++){
                TreeNode curr = Q.poll();
                sum += curr.val;

                if(curr.left != null){
                    Q.add(curr.left);
                }
                 if(curr.right != null){
                    Q.add(curr.right);
                }

            }
            if(maxsum<sum){
                maxsum = sum;
                maxlevel = level;
            }
        }
        return maxlevel;
    }
}
