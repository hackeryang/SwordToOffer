/*
* 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
* */
public class DepthOfBinaryTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public int treeDepth(TreeNode root) {
        if(root==null) return 0;
        int leftDepth=treeDepth(root.left);  //递归求出当前根节点左子树和右子树的深度
        int rightDepth=treeDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;  //从底向上递归返回左右子树深度的较大值，加1即当前根节点的深度
    }
}
