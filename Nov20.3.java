class Solution {
    int postidx ;
    Map<Integer,Integer>map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
     map = new HashMap<>();
     for(int i = 0; i<inorder.length; i++){
        map.put(inorder[i],i);
     }
     postidx = postorder.length-1;
     return build(postorder,0,inorder.length-1);

        
       
        
    }
    public TreeNode build(int[] postorder, int start, int end){
        if(start>end){
            return null;
        }
        int rootval = postorder[postidx];
        postidx--;
        TreeNode root = new TreeNode(rootval);

        int rootidx = map.get(rootval);

        root.right =  build(postorder,rootidx+1,end);
        root.left =  build(postorder,start,rootidx-1);

        return root;

    }

   
}
