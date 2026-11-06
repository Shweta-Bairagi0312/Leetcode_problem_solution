public static boolean isSubtree(Node root, Node subroot){
    if(root==null){
        return false;
    }
    if(root.data==subroot.data){
        if(isIdenticial(root,subroot)){
            return true;
        }
    }
    boolean left = isSubtree(root.left,subroot);
    boolean right = isSubtree(root.right,subroot);

    return left||right;

}

public static boolean isIdentical(Node root,Node subroot){
    if(root==null && subroot==null){
        return true;
    }
    else if(root==null || subroot = null || root.data != subroot.data){
        return false;
    }
    if(!isIdentical(root.left,subroot)){
        return false;
    }
    if(!isIdentical(root.right,subroot)){
        return false;
    }
    return true;



}
