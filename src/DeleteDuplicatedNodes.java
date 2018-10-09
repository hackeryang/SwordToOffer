/*
* 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
* 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
* */
public class DeleteDuplicatedNodes {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null || pHead.next==null) return pHead;
        ListNode first=new ListNode(0);  //在原链表头节点前面再加入一个头节点，随便取值，它的值不会与后面节点比较
        first.next=pHead;  //将多出来的头节点链接原头节点，从新头节点开始遍历可以处理原链表首节点就重复的情况
        ListNode pre=first;  //pre游标指向当前确定不重复的节点，current为遍历游标，一直往后遍历
        ListNode current=pHead;  //遍历游标由原链表首节点开始遍历，所以新头节点的值不会加入比较
        while(current!=null){
            if(current.next!=null && current.val==current.next.val){
                while(current.next!=null && current.val==current.next.val){  //当前节点后面若有多个重复节点，就一直往后遍历
                    current=current.next;
                }
                pre.next=current.next;  //上面循环后current指向最后一个重复的节点，所以current.next指向接下来第一个不重复的节点，将pre的下一跳指向这个不重复节点
                current=current.next;  //pre的下一跳跳过所有重复节点，链接到后面第一个不重复节点后，继续从下一跳节点遍历
            }else{  //如果没有重复节点，就把pre后移一位，并且current游标也指向下一个节点，从下一个节点继续遍历判断
                pre=pre.next;
                current=current.next;
            }
        }
        return first.next;
    }
}
