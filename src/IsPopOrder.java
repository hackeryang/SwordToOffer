import java.util.Stack;

/*
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * */
public class IsPopOrder {
    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) return false;
        Stack<Integer> stack = new Stack<Integer>();  //使用辅助栈存放pushA压入栈的数组元素
        int popIndex = 0;  //用来标识popA弹出栈元素的索引
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);  //如果栈顶元素不等于popA中当前索引的要出栈的元素，则继续将pushA中的元素入栈
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {  //当栈非空并且栈顶元素等于popA中当前索引的要出栈的元素
                stack.pop();  //将元素出栈
                popIndex++;  //将索引指向popA中下一个将要出栈的元素
            }
        }
        return stack.isEmpty();  //如果栈最后为空，说明popA中的元素的确是栈的出栈顺序，如果栈最后不为空说明不是
    }
}
