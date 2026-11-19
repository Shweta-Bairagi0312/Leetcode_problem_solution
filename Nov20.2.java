class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode>Q = new LinkedList<>();
        Q.add(root);
        boolean zigzag = false;

        while(!Q.isEmpty()){
            List<Integer>list = new ArrayList<>();
            int size = Q.size();
           

            for(int i = 0; i<size; i++){
                TreeNode curr = Q.poll();
                if(zigzag){
                    list.add(0,curr.val);
                }
                else{
                    list.add(curr.val);
                }

                if(curr.left != null){
                    Q.add(curr.left);
                }
                if(curr.right != null){
                    Q.add(curr.right);
                }
            }
            res.add(list);
            zigzag = !zigzag;

        }

       
      return res;
    
        

    }
}
