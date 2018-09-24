/*
* 输入一个链表，反转链表后，输出新链表的表头。
* */
public class ReverseList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        ListNode first=head;  //初始化首节点，从原链表的首节点开始反转操作
        ListNode reverse=null;  //用一个新的空链表存放反转后的链表
        while(first!=null){  //当原链表的节点没有被剥离完时不断循环
            ListNode second=first.next;  //初始化原链表首节点的下一个节点
            first.next=reverse;  //原链表首节点的下一个节点链接到新链表的首节点处
            reverse=first;  //下一跳节点链接完成后，将原链表首节点放入到新链表中，成为新链表的首节点
            first=second;  //从原链表中剥离掉原首节点，原链表首节点的下一个节点成为新的原链表首节点，用于下一次循环
        }
        return reverse;  //返回插入到新链表的首节点，即原链表的最后一个节点
    }
}
