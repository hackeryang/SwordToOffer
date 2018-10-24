/*
* 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
* 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针next。
* 中序遍历示意图：https://uploadfiles.nowcoder.net/files/20171225/773262_1514198075109_20151104234034251
* */
public class FindNextNode {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode getNext(TreeLinkNode pNode){
        if(pNode==null) return pNode;
        if(pNode.right!=null){  //当前节点存在右子树时，切换到右子树根节点，然后不断递归查找左子树，直到最底部左下角节点
            pNode=pNode.right;
            while(pNode.left!=null) pNode=pNode.left;
            return pNode;
        }
        /*
        * 当前节点不存在右子树时，例如叶子节点，则判断自己是不是父节点的左子节点，
        * 如果不是，则递归查找父节点的父节点，直到当前节点是它的父节点的左子节点为止，返回该父节点
        * */
        while(pNode.next!=null){
            if(pNode.next.left==pNode) return pNode.next;
            pNode=pNode.next;
        }
        return null;
    }
}
