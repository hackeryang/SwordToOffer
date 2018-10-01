/*
* 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
* */
public class ConvertBinaryTreeToLinkedList {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode leftLast=null;  //用于放置根节点左子树的最后一个节点，即左子树的最大节点
    TreeNode head=null;  //链表的首节点，即根节点左子树的最小节点
    public TreeNode Convert(TreeNode root) {
        ConvertSubtree(root);
        return head;  //返回链表首节点，即二叉树中左下角最小节点
    }

    private void ConvertSubtree(TreeNode root){
        if(root==null) return;
        ConvertSubtree(root.left);  //递归转换左子树
        if(leftLast==null){  //如果没有左子树，则左侧最后一个节点即为当前根节点自己，链表首节点也是自己，一般发生在左侧叶子节点
            leftLast=root;
            head=root;
        }else{  //建立双向链接，左子树最后一个节点的右链接指向根节点，根节点的左链接指向左子树最大节点，然后将左侧最大节点设为根节点，作为链表前半部分最大节点
            leftLast.right=root;
            root.left=leftLast;
            leftLast=root;
        }
        ConvertSubtree(root.right);  //递归转换右子树
    }
}
