import java.util.HashSet;

/*
* 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
* 传统解法的原理解释：https://blog.csdn.net/snow_7/article/details/52181049
* */
public class EntranceOfLoopLinkedList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //新解法，利用HashSet不能包含重复元素的特性，判断两个对象是否相同会使用equals()方法，若相等equals()返回true，同时set.add(Object)返回false
    public ListNode entryNodeOfLoop(ListNode pHead){
        HashSet<ListNode> set=new HashSet<ListNode>();
        while(pHead!=null){
            /*
            * 如果一个链表从首节点经过若干节点后进入环链表区域，环入口第一次会被加入到HashSet中，一个环遍历下来再到环入口节点时，
            * 之前HashSet中添加过环入口节点的ListNode对象，现在遇到同一个对象HashSet会拒绝添加，此时当前节点就是环入口节点。
            * 需要注意的是，相同的val值未必就代表同一个ListNode对象，例如1->1->2，两个1代表的是不同链表节点
            * */
            if(!set.add(pHead)){  //在添加前会调用Object的hashCode()方法计算哈希值，若set中不存在该哈希值则加入set，否则利用equals()判断两个Object
                return pHead;
            }
            pHead=pHead.next;
        }
        return null;
    }
}
