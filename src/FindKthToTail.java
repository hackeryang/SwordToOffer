/*
* 输入一个链表，输出该链表中倒数第k个结点。
* */
public class FindKthToTail {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode findKthToTail(ListNode head,int k) {
        if(head==null) return head;
        ListNode current=head;  //作为遍历链表的游标
        int num=0;  //用于计数链表最后一位的索引，即链表项数量减1
        while(current!=null){
            current=current.next;
            num++;
        }
        if(num<k) return null;  //如果倒数第k个节点的索引在整个链表之外，返回空
        ListNode current2=head;  //前面的current已经指向链表尾部，再用一个新的游标遍历链表
        for(int i=0;i<num-k;i++){  //遍历num-k-1次后，到达倒数第k个节点
            current2=current2.next;
        }
        return current2;  //现在第二个游标指向倒数第k个节点，直接返回
    }
}
