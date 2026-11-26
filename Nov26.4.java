public static TreeNode convertMirror(TreeNode root){
    if(root==null){
        return root;
    }
    TreeNode lefts = convertMirror(root.left);
    TreeNode rights = convertMirror(root.right);

    root.left = rights;
    root.right = lefts;

    return  root;

}
