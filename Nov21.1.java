class Solution {
    public int widthOfBinaryTree(TreeNode root) {
      if(root==null){
        return 0;
      }
      Queue<Pair<TreeNode,Integer>>Q = new LinkedList<>();
      int maxwidth = 0;
      Q.add(new Pair<>(root,0));

      while(!Q.isEmpty()){
        int size = Q.size();
        int index = 0;
        int start = Q.peek().getValue();

        for(int i = 0; i<size; i++){
            Pair<TreeNode,Integer>pair = Q.poll();
            TreeNode curr = pair.getKey();
            index = pair.getValue();

            if(curr.left != null){
                Q.add(new Pair<>(curr.left,2*index));
            }
            if(curr.right != null){
                Q.add(new Pair<>(curr.right,2*index+1));
            }
        } 
        maxwidth = Math.max(maxwidth,index-start+1);

      }
      return maxwidth;

    }
}
