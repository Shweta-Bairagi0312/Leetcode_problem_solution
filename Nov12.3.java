class Solution {
    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int maxlevel = 1;
        Queue<TreeNode>q =  new LinkedList<>();
        q.offer(root);
        for(int level = 1; !q.isEmpty(); level++){
            int sum = 0;
            for(int sz = q.size(); sz>0; sz--){
                TreeNode node =  q.poll();
                sum += node.val;
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            if(max<sum){
                max =  sum;
                maxlevel = level;
            }


        }

        return maxlevel;
        
    }
}
