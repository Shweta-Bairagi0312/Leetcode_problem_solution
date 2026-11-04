 public static int sum(Node root){
            if(root==null){
                return 0;
            }
            int lsum = height(root.left);
            int rsum = height(root.right);
            return  lsum+rsum+root.val;

         }
