import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
* 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
* */
public class PrintBinaryTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //更简单的递归方法
    ArrayList<ArrayList<Integer> > print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > result=new ArrayList<ArrayList<Integer> >();  //用包含多个列表的总列表存储最终结果
        printLines(pRoot,1,result);
        return result;
    }

    private void printLines(TreeNode root,int depth,ArrayList<ArrayList<Integer> > list){
        if(root==null) return;
        if(depth>list.size()) list.add(new ArrayList<Integer>());  //如果遍历到的二叉树层数比结果列表中子列表的数目多，就开辟一个新子列表存放这一层的节点值
        list.get(depth-1).add(root.val);  //列表是从0开始索引的，depth从1开始索引，为了匹配所以depth-1，在结果列表的对应子列表中插入每一层的节点值
        printLines(root.left,depth+1,list);  //递归存放当前根节点的左子节点
        printLines(root.right,depth+1,list);  //递归存放当前根节点的右子节点
    }

    //思路与PrintBinaryTreeZigzag.java相同，去掉了之字形打印的逻辑
    /*ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > result=new ArrayList<ArrayList<Integer> >();
        if(pRoot==null) return result;
        ArrayList<Integer> list=new ArrayList<Integer>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(null);
        queue.offer(pRoot);
        while(queue.size()!=1){
            TreeNode node=queue.poll();
            if(node==null){
                Iterator<TreeNode> iter=queue.iterator();
                while(iter.hasNext()){
                    TreeNode temp=(TreeNode)iter.next();
                    list.add(temp.val);
                }
                result.add(new ArrayList<Integer>(list));
                list.clear();
                queue.offer(null);
                continue;
            }
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return result;
    }*/
}
