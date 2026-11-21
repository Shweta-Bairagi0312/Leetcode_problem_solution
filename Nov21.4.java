class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    public int dfs(TreeNode root, int maxval){
        if(root==null){
            return 0;
        }
        int count = 0;
        if(root.val>=maxval){
            count = 1;
        }
        maxval = Math.max(maxval,root.val);

        count += dfs(root.left,maxval);
        count += dfs(root.right,maxval);

        return count;
    }
}
