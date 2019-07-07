import java.util.LinkedList;
import java.util.Queue;

/*
 * 汇编语言中有一种移位指令叫做循环左移（ROL），用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * */
public class LeftRotateString {
    public String leftRotateString(String str, int n) {
        if (str == null || str.length() == 0) return "";
        char[] charArray = str.toCharArray();  //将字符串拆成字符数组，用于下面队列的入列出列
        Queue<Character> queue = new LinkedList<Character>();
        for (int i = 0; i < charArray.length; i++) {
            queue.offer(charArray[i]);  //将队列中排入字符数组
        }
        for (int i = 0; i < n; i++) {  //借鉴约瑟夫环的思想，每左移一次就把队列头部元素弹出再放回队列尾部，完成循环左移
            queue.offer(queue.poll());
        }
        String result = "";
        while (queue.size() != 0) {
            result += queue.poll();  //将队列排列后的结果转为字符串
        }
        return result;
    }
}
