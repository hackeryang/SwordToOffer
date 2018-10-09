import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/*
* 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
* */
public class PrintBinaryTreeZigzag {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > result=new ArrayList<ArrayList<Integer> >();  //利用存放多个列表的列表存放最终结果
        if(pRoot==null) return result;
        ArrayList<Integer> list=new ArrayList<Integer>();  //利用一个列表存放每一层的顺序或逆序二叉树元素
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();  //利用双向链表进行顺序和逆序的遍历，模拟队列
        queue.addLast(null);  //将null作为每层的分隔符
        queue.addLast(pRoot);  //一开始先放入根节点
        boolean leftToRight=true;  //第一层只有根节点，算是从左到右遍历

        while(queue.size()!=1){  //当“队列”中至少包含一个层分隔符和一个元素时，执行遍历操作
            TreeNode node=queue.removeFirst();  //node作为遍历一层层二叉树元素的游标
            if(node==null){  //当“队列”中在这一层弹出的第一个元素是层分隔符时，检查遍历顺序应该从左往右还是从右往左
                Iterator<TreeNode> iter=null;
                if(leftToRight){  //如果遍历方式表明从左往右，则将“队列”迭代器置为顺序迭代器
                    iter=queue.iterator();
                }else{  //如果遍历方式为从右往左，则将“队列”迭代器置为逆序迭代器
                    iter=queue.descendingIterator();
                }
                leftToRight=!leftToRight;  //下一层遍历时与这一层遍历方式相反，所以要改变遍历方式
                while(iter.hasNext()){  //当迭代器表明“队列”中还有下一个元素，将元素值添加进包含这一层元素的列表中
                    TreeNode temp=(TreeNode)iter.next();
                    list.add(temp.val);
                }
                result.add(new ArrayList<Integer>(list));  //这一层元素添加到列表中后，将该列表添加到结果总列表中，这里要添加新列表对象，否则每一层都指向同一个list
                list.clear();  //为了节省内存，list作为方法的全局变量，所以一层用过后要将list清空用来存放下一层的元素
                queue.addLast(null);  //这一层遍历完后，再插入一个层分隔符
                continue;  //当“队列”遍历到层分隔符null时，此时没指向任何节点元素，就不存在左右子树节点，跳过下面的if判断进行“队列”中下一个元素的判断
            }
            if(node.left!=null){  //当前node游标遍历到的元素不是层分隔符，是节点而且该节点有左右子节点时，将左右子节点添加进“队列”
                queue.addLast(node.left);
            }
            if(node.right!=null){
                queue.addLast(node.right);
            }
        }
        return result;
    }
}
