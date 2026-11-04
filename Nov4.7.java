public static int count(Node root){
            if(root==null){
                return 0;
            }
            int leftc = count(root.left);
            int rightc = count(root.right);
            return leftc+rightc+1;

        }
