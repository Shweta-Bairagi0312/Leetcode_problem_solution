class Solution {
    TreeNode nextright = null;
    
    public void flatten(TreeNode root) {
       if(root==null){
        return ;
       }
       flatten(root.right);
       flatten(root.left);

       root.left = null;
       root.right = nextright;
       nextright = root; 
        
    }
}
