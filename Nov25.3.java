public static void Path(Node root,ArrayList<Interger>path){
    if(root==null){
        return;
    }
    path.add(root.data);
    if(root.left==null && root.right==null){
        printpath(path);
    }
    PrintPath(root.left,path);
    PrintPath(root.right,path);
    path.remove(path.size()-1);


}
