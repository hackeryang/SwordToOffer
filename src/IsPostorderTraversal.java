/*
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * */
public class IsPostorderTraversal {
    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) return false;
        if (sequence.length == 1) return true;
        return isPostorderTraversal(sequence, 0, sequence.length - 1);
    }

    private boolean isPostorderTraversal(int[] a, int start, int end) {
        if (start >= end) return true;  //如果从底往上递归的过程到最后开始和结束索引相遇，说明已经遍历到根节点，整个数组确实为后序遍历二叉树
        int i = start;  //后序遍历是先左节点，再右节点，最后根节点，因此数组开头元素一定是二叉树左下角最小节点，sequence[end]一定是根节点
        while (a[i] < a[end]) i++;  //从二叉树左下角的最小节点开始与根节点比较，如果左子树所有节点全都小于根节点，索引i会加到根节点左子树右下角的最大节点
        for (int j = i; j < end; j++) {  //在根节点右子树上不断从底部向上与根节点比较，只要有一个右子树节点小于根节点，就一定不是后序遍历二叉树
            if (a[j] < a[end]) return false;
        }
        //递归检查根节点的左子树根节点和右子树根节点下面是否也符合左子树都小于根节点，右子树都大于根节点的特性，如果全都满足则整个数组都是后序遍历二叉树
        return isPostorderTraversal(a, 0, i - 1) && isPostorderTraversal(a, i, end - 1);
    }
}
