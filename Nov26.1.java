public static boolean isValid(Node root, Node min, Node max){
    if(root==null){
        return true;
    }
    if(min != null &&  root.data <= min.data){
        return false;
    }
    if(max != null &&  root.data >= max.data){
        return false;
    }
    return isValid(root.left,min,root) && isValid(root.right,root,max);
}
