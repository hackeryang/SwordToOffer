import java.util.HashSet;

/*
* 输入两个链表，找出它们的第一个公共结点。
* */
public class FindFirstPublicNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode current1=pHead1;  //设置两个遍历两个链表的游标，初始位置在两个链表首节点
        ListNode current2=pHead2;
        HashSet<ListNode> set=new HashSet<ListNode>();  //利用HashSet存放遍历过的第一条链表
        while(current1!=null){
            set.add(current1);
            current1=current1.next;
        }
        while(current2!=null){
            if(set.contains(current2)) return current2;  //如果HashSet中存有和current2游标节点相同的第一条链表中的节点，则找到公共节点
            current2=current2.next;
        }
        return null;  //如果没找到公共节点，或公共节点为空，返回null
    }
}
