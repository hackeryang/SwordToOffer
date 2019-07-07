/*
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * */
public class HasSubtree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;  //设置匹配标志位，匹配成功设为true
        if (root1 != null && root2 != null) {  //仅当root1和root2不为空树时比较，否则直接返回false
            if (root1.val == root2.val) {  //当二叉树root1和root2的根节点值相同时，比较它们的子树是否完全一致
                result = doesTree1HasTree2(root1, root2);
            }
            if (!result) {  //如果在root1的根节点处没有找到和root2根节点的值相同的节点，递归查找root1的左子树里是否有和root2根节点的值相同的节点
                result = hasSubtree(root1.left, root2);
            }
            if (!result) {  //如果在root1的左子树中没有找到和root2根节点的值相同的节点，递归查找root1的右子树里是否有和root2根节点的值相同的节点
                result = hasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {  //如果二叉树root2已经被遍历完，此时root1不管有没有遍历完，都说明匹配，二叉树root2是root1的子树
            return true;
        }
        if (root1 == null && root2 != null) {  //如果二叉树root1已经被遍历完，而root2没有被遍历完，说明root1里不包含root2
            return false;
        }
        if (root1.val != root2.val) {  //在递归遍历的比较过程中，也许root1中某个子树前面一些节点与root2的前面一些节点一致，但只要有中间一个节点的值不一致，说明root2不是root1的子树
            return false;
        }
        return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);  //在root1当前子树根节点与root2根节点值相同时，递归比较它们的左子树和右子树是否都一致
    }
}
