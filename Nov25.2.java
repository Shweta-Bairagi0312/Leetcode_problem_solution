public static void Range(Node root,int k1, int k2){
    if(root==null){
        return;
    }
    if(root.data>=k1 && root.data<=k2){
        Range( root.left,k1,k2);
        System.out.println(root.data+" ");
        Range( root.right,k1,k2);
    }
    if(root.data<k1){
        Range( root.right,k1,k2);
    }
    else{
        Range( root.left,k1,k2);
    }
}
