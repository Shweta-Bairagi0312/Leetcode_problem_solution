class Solution {
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer>list = new ArrayList<>();
       if(root==null){
        return list;
       }
       Queue<TreeNode>Q = new LinkedList<>();
       Q.add(root);
       int lastval = 0;
       while(!Q.isEmpty()){
      
        int s = Q.size();
        for(int i = 0; i<s; i++){
            TreeNode curr = Q.poll();
            lastval = curr.val;

            if(curr.left != null){
                Q.add(curr.left);

            }
            if(curr.right != null){
                Q.add(curr.right);

            }

        }
        list.add(lastval);

       }
       return list;
    }
}
