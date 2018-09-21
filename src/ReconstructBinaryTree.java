/*
* 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
* 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
* 原理讲解：https://blog.csdn.net/Yeoman92/article/details/77868367
* */
public class ReconstructBinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){
        if(startPre>endPre || startIn>endIn){
            return null;
        }
        TreeNode root=new TreeNode(pre[startPre]);
        for(int i=startIn;i<=endIn;i++){  //需要确定中序遍历数组中根节点的位置，因此用中序数组作为索引
            if(in[i]==pre[startPre]){  //前序遍历数组的第一个元素一定是根节点，中序遍历数组中找到根节点位置后，根节点左边元素为左子树，右边元素为右子树
                //递归遍历左子树，截取前序数组和中叙数组的左子树部分，startPre+1为前序数组中根节点后一个元素，即左子树开始位置，startPre+(i-startIn)为前序数组中左子树结束位置，根据中序数组中根节点左边元素个数计算
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                //递归遍历右子树，截取前序数组和中叙数组的右子树部分，i+1为中序数组中根节点后一个元素，即右子树开始位置，startPre+(i-startIn)+1为前序数组中右子树开始位置，根据中序数组中根节点右边元素个数来计算
                root.right=reConstructBinaryTree(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
            }
        }
        return root;  //递归结束后返回根节点
    }
}
