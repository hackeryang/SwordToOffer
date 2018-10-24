import java.util.Stack;

/*
* 给定一棵二叉搜索树，请找出其中的第k小的结点。例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
* */
public class KthTreeNode {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot==null  || k==0) return null;
        Stack<TreeNode> stack=new Stack<TreeNode>();  //用栈存储最小节点遍历的路径，栈弹出的元素必然是当前最小节点
        int count=0;  //从左子树最左下角的最小节点开始计数，到K时返回第K小的节点
        TreeNode node=pRoot;  //node为往树深层遍历的游标
        do{  //当当前节点或者栈不为空时，顺着树路径向下遍历
            if(node!=null){
                stack.push(node);  //栈中不断往下存入左节点，直到遇到树底层的一个左节点再也没有左子节点为止
                node=node.left;
            }else{  //每次到达树最左下角时，游标遍历到了树底层左下角的最小节点的左节点（左节点其实不存在）即null，通过pop()重新回到最小节点
                node=stack.pop();
                /*
                * 已经找到左下角最小节点，计数加1找第2小的节点，即找最小节点的右子树，然后在该右子树中继续找左下角最小节点，
                * 没右子树则游标回到父节点继续查找父节点的右子树，如此循环直到计数为K，说明找到第K小节点
                * */
                count++;
                if(count==k) return node;
                node=node.right;
            }
        }while(node!=null || !stack.isEmpty());
        return null;  //如果没找到第K小的节点则返回空
    }
}
