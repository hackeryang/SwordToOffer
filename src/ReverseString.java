import java.util.Stack;

/*
* 翻转输出句子，例如“I am a student.”反转后输出“student. a am I”
* */
public class ReverseString {
    public String reverseSentence(String str) {
        if(str.trim().equals("") && str.length()>0) return str;  //如果字符串由多个空格组成，直接返回
        Stack<String> stack=new Stack<String>();  //用后进先出栈来自动翻转字符串
        String[] strArray=str.trim().split(" ");  //先用trim()消除过多空格，以免连续两个空格时将一个空格也分为字符数组的一个元素
        for(int i=0;i<strArray.length;i++){
            stack.push(strArray[i]);
        }
        String result=stack.pop();
        while(!stack.isEmpty()){
            result+=" "+stack.pop();  //结果字符串由栈弹出的元素拼接而成，栈中的元素自动后进先出
        }
        return result;
    }
}
