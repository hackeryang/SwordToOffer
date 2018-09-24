import java.util.Stack;

/*
* 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
* */
public class MinStack {
    Stack<Integer> data=new Stack<Integer>();  //初始化一个数据栈来存放所有元素
    Stack<Integer> min=new Stack<Integer>();  //初始化一个辅助栈存放依次存放最小元素
    Integer temp=null;  //不能用int，只有Integer对象才能为空
    public void push(int node) {
        if(temp!=null){
            if(node<=temp){  //当有比辅助栈min中的栈顶元素更小或等于的元素时，将更小元素放入辅助栈以及数据栈，否则只放入数据栈
                temp=node;
                min.push(node);
            }
            data.push(node);
        }else{  //当一开始temp值为空时，第一个元素可以放入最小栈和数据栈中
            temp=node;
            min.push(node);
            data.push(node);
        }
    }

    public void pop() {
        int dataNumber=data.pop();
        int minNumber=min.pop();
        if(dataNumber!=minNumber) min.push(minNumber);  //如果数据栈中出栈的元素并非最小元素，再把最小元素放回辅助栈
    }

    public int top() {
        return data.peek();  //检查数据栈中的栈顶元素但不出栈
    }

    public int min() {
        return min.peek();  //检查辅助栈中的栈顶元素但不出栈，即最小元素
    }
}
