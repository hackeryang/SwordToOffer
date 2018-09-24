/*
* 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
* */
public class MergeTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.val<=list2.val){  //利用归并排序的递归思想，将两个链表的较小节点链接起来
            list1.next=Merge(list1.next,list2);  //如果list1当前节点小于list2当前节点，链表放入较小节点并将索引往后一个节点，与list2的原较大节点继续比较
            return list1;
        }else{
            list2.next=Merge(list2.next,list1);  //如果list2当前节点小于list1当前节点，链表放入较小节点并将索引往后一个节点，与list1的原较大节点继续比较
            return list2;
        }
    }
}
