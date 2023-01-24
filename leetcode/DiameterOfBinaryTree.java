public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int leftHeight = diameterOfBinaryTree(root.left);
        int rightHeight = diameterOfBinaryTree(root.right);
        int current =diameterOfBinaryTreeRec(root.left)+diameterOfBinaryTreeRec(root.right);
        return Math.max(current,Math.max(leftHeight,rightHeight))+1;

    }
    public int diameterOfBinaryTreeRec(TreeNode root) {
        if(root==null)return 0;
        return 1+Math.max(diameterOfBinaryTreeRec(root.left),diameterOfBinaryTreeRec(root.right));

    }
}
