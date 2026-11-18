class Solution {
    int preidx;
    Map<Integer, Integer>map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    map = new HashMap<>();
    for(int i = 0; i<inorder.length; i++){
        map.put(inorder[i],i);
    }
    preidx = 0;
    return split(preorder,0, inorder.length-1);
     

    }
    public TreeNode split(int[] preorder,int left, int right){
        if(left>right){
            return null;
        }

        int curroot = preorder[preidx];
        preidx++;
        TreeNode root = new TreeNode(curroot);
        int rootidx = map.get(curroot);

        root.left = split(preorder,left,rootidx-1);
        root.right = split(preorder,rootidx+1,right);

        return root;


    }
}
