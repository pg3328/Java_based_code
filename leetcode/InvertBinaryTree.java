import com.sun.source.tree.Tree;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root.equals(null)) return root;
        else{
            invertTree(root.left);
            invertTree(root.right);
            TreeNode curr = root.left;
            root.left = root.right;
            root.right = curr;
            return root;
        }

    }
}
