/*
* 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
* 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
* 输入包括数字字母符号，可能为空，例如两次输入为+2147483647和1a33，分别的两次输出为2147483647和0
* */
public class StringToInt {
    public int strToInt(String str) {
        if(str==null || str=="" || str.length()==0) return 0;
        char[] c=str.toCharArray();
        int symbol=0,i=0;  //初始化输入的正负符号和字符数组的遍历游标
        if(c[0]=='+'){  //如果输入包含指定为正数的加号，符号为1，游标到字符数组第二位
            symbol=1;
            i=1;
        }
        if(c[0]=='-'){  //如果输入包含指定为负数的减号，符号为-1，游标到字符数组第二位
            symbol=-1;
            i=1;
        }
        int sum=0;
        for(;i<c.length;i++){
            if(c[i]<48 || c[i]>57) return 0;  //48和57分别为数字0和9的ASCII码，如果字符数组中有一个字符不在数字范围内，则直接返回0
            sum=sum*10+c[i]-48;  //上一轮的数字总和乘以10向左移一位，留出个位加上当前数字并减0的ASCII码转换为数字
        }
        if(symbol==-1) sum=0-sum;  //如果符号显示为负数，则返回总和的负数
        return sum;
    }
}
