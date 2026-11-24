pubic boolean search(TreeNode root, int key ){
    if(root==null){
        return false;
    }
    if(root.data==key){
        return true;
    }
    if(root.data>key){
        return search( root.left,key );
    }
    else{
        return search(root.right, key);
    }
    
}
