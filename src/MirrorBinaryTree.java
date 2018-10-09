/*
* 操作给定的二叉树，将其变换为原二叉树的镜像。
* */
public class MirrorBinaryTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public void Mirror(TreeNode root) {
        if(root!=null){ //当前树根节点不为空时，交换自己的左右子树根节点
            TreeNode temp=root.left;
            root.left=root.right;
            root.right=temp;
            Mirror(root.left);  //递归交换左子树的左右子树根节点
            Mirror(root.right);  //递归交换右子树的左右子树根节点
        }
    }
}
