/*
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * */
public class SumHarder {
    public int sum(int n) {
        int result = n;
        /*
         * 利用逻辑与的短路特性实现递归终止。当n=0时，执行到判断n>0时直接返回false，不会再进行与号后面的运算，最后那一轮的result会返回0。
         * 当n>0时，利用递归执行与号后面的累加求和。
         * */
        boolean ans = (n > 0) && ((result += sum(n - 1)) > 0);
        return result;
    }
}
