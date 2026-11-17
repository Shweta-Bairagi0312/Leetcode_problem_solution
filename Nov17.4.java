class Solution {
    int res =  0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
        
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = dfs( root.left);
        int right = dfs(root.right);

        int height = 1+Math.max(left,right);

        int dia = left+right;
        res = Math.max(res,dia);
       
        return height;
    }  
}
