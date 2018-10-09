/*
* 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
* */
public class IsSymmetricalBinaryTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    boolean isSymmetrical(TreeNode pRoot){
        if(pRoot==null) return true;  //空树必然“对称”
        return isSymmetrical(pRoot.left,pRoot.right);  //判断根节点的左子树和右子树是不是对称
    }

    boolean isSymmetrical(TreeNode left,TreeNode right){
        if(left==null && right==null) return true;  //只有根节点，没有左右子树，也是对称的
        if(left==null || right==null) return false;  //在有子树情况下，左子树或者右子树缺了其中一个，肯定不对称
        //如果对称，根节点左右节点的值必然相同，同时递归下去，左节点的左节点一定和右节点的右节点对称，左节点的右节点一定和右节点的左节点对称，像镜子一样
        return left.val==right.val && isSymmetrical(left.left,right.right) && isSymmetrical(left.right,right.left);
    }
}
