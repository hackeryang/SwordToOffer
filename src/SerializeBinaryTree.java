/*
* 请实现两个函数，分别用来序列化和反序列化二叉树。
* 序列化指的是遍历二叉树为字符串；反序列化指的是依据字符串重新构造成二叉树。
* 遇到空节点序列化为“#”，序列化后节点间的数值用“，”隔开
* */
public class SerializeBinaryTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    int index=-1;  //用于遍历后面反序列化时生成的字符串数组的索引，初始化为-1是因为deserialize()一开始为index++，这样字符串数组一开始的索引index为0

    //依据前序遍历序列来序列化二叉树
    String serialize(TreeNode root) {
        StringBuilder s=new StringBuilder();
        if(root==null){
            s.append("#,");  //当在遍历二叉树时碰到空节点时，这些空节点被序列化为一个特殊的字符“#”
            return s.toString();
        }
        s.append(root.val+",");  //不断添加遍历到的当前子树根节点值
        s.append(serialize(root.left));  //递归添加序列化左子树的元素值
        s.append(serialize(root.right));  //递归添加序列化右子树的元素值
        return s.toString();  //整个二叉树序列化后，返回最后结果
    }

    TreeNode deserialize(String str) {
        index++;  //每次反序列化下一个元素之前先将索引加1
        String[] strArray=str.split(",");  //将序列化后的字符串分解成字符串数组
        TreeNode node=null;
        if(!strArray[index].equals("#")){  //当字符串数组中遍历到的二叉树节点不为空，则将字符串元素转换为二叉树节点对象
            node=new TreeNode(Integer.parseInt(strArray[index]));
            node.left=deserialize(str);  //递归序列化左子节点
            node.right=deserialize(str);  //递归序列化右子节点
        }
        return node;  //返回反序列化后的当前根节点
    }
}
