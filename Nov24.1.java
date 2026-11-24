public class Build{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }

    }
    public static Node insert(Node root, int val){
        if(root==null){
            root = new Node(root.data);
            return root;
        }
        if(root.data>val){
            root.left = insert(root.left, int val);

        }
        if(root.data<val){
            root.right = insert(root.right, int val);

        }
        return root;

    }
    public static void main(String[]args){
        int[]val = {5,1,3,4,2,7};
        Node root = null;

        for(int i = 0; i<val.length; i++){
            root = insert(root, val[i]);
        }
    }
}
