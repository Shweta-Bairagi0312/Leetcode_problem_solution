class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;

        
    }
    public void helper(TreeNode root, int path){
        if(root==null){
            return;
        }
        path = path*10+root.val;
        if(root.left==null && root.right==null){
            sum += path;
        }
        helper(root.left, path);
        helper(root.right, path);

    }
}
