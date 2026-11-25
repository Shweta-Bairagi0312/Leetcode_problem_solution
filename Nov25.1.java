public Node Delete(Node root,int val){
    if(root==null){
        return root;
    }
    if(root.data<val){
        root.right = Delete(root.right,val);
    }
    if(root.data>val){
        root.left = Delete(root.left,val);
    }
    else{
        if(root.left==null && root.right==null){
            return null;
        }
        if( root.left==null){
            return root.right;
        }
        else if(root.right==null){
            return root.left;
        }
        Node Is = InorderSucessor(root.right);
        root.data = Is.data;
        root.right = Delete(root.data,Is.data);
        
    }
    return root;
}

public Node InorderSucessor(Node root){
    while(root.left != null){
        root = root.left;
    }
    return root;
}
