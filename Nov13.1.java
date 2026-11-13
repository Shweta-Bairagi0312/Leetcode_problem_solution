class Solution {
    public int maxLevelSum(TreeNode root) {
        int maxsum = Integer.MIN_VALUE;
        int maxlevel = 1;
        Queue<TreeNode>Q = new LinkedList<>();
        Q.add(root);
        for(int level = 1;!Q.isEmpty(); level++){
            int sum = 0;
            for(int s = Q.size(); s>0;s--){
                TreeNode curr = Q.poll();
                sum += curr.val;
                if(curr.left != null){
                    Q.add(curr.left);
                }
                if(curr.right != null){
                    Q.add(curr.right);
                }
            }
            if(maxsum<sum){
                maxsum = sum;
                maxlevel = level;
            }

        }
        return maxlevel;
    }
}
