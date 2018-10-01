/*
* 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
* 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
* 原理图解：https://uploadfiles.nowcoder.net/images/20170311/412362_1489225139482_4A47A0DB6E60853DEDFCFDF08A5CA249
* */
public class ComplicatedLinkedListCopy {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null) return null;
        RandomListNode currentNode=pHead;  //初始化一个当前所遍历的节点的游标，用于从前往后遍历链表
        while(currentNode!=null){  //当前节点存在时，在原链表中一个隔一个插入克隆节点
            RandomListNode cloneNode=new RandomListNode(currentNode.label);  //克隆一个值与当前节点相同的新节点
            RandomListNode nextNode=currentNode.next;
            currentNode.next=cloneNode;  //将当前节点下一跳指向复制克隆出来的节点
            cloneNode.next=nextNode;  //克隆节点在当前节点和当前节点原来的下一跳之间
            currentNode=nextNode;  //游标跳过中间的克隆节点到达当前节点原来的下一跳节点
        }
        currentNode=pHead;  //游标重新回到链表开头
        while(currentNode!=null){  //当前节点存在时，克隆当前节点的随机指针给克隆节点
            //currentNode.next就是当前节点的克隆节点，随机指针指向当前节点随机指向节点的下一跳，及随机指向节点的克隆节点
            currentNode.next.random=currentNode.random==null?null:currentNode.random.next;
            currentNode=currentNode.next.next;  //游标跳过当前节点的克隆节点，指向原链表的下一跳
        }
        currentNode=pHead;  //游标重新回到链表开头，准备从原链表中剥离一个个克隆节点形成一个新链表
        RandomListNode pCloneHead=pHead.next;  //指定新链表的首节点，即第一个克隆节点
        while(currentNode!=null){
            RandomListNode cloneNode=currentNode.next;  //找到当前节点的克隆节点
            currentNode.next=cloneNode.next;  //当前节点的下一跳重新指向原链表的下一跳，不再指向克隆节点
            cloneNode.next=cloneNode.next==null?null:cloneNode.next.next;  //克隆节点下一跳不再指向原链表当前节点原来的下一跳，指向下一个克隆节点，构造新链表的“链条”
            currentNode=currentNode.next;  //currentNode.next已经指向原链表当前节点的原来下一跳，跳过了克隆节点，重新链接好原链表
        }
        return pCloneHead;  //返回克隆复制的新链表首节点
    }
}
