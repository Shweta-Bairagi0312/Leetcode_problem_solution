public boolean search(TreeNode root, int key) {
    if (root == null) {
        return false;
    }

    if (root.data == key) {
        return true;
    }

    boolean leftside = search(root.left, key);
    boolean rightside = search(root.right, key);

    return leftside || rightside;
}
