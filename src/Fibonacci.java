/*
* 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
* */
public class Fibonacci {
    public int fibonacci(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int f=0,g=1;
        for(int i=0;i<n;i++){
            f=f+g;  //前一项加后一项
            g=f-g;  //已经求和过的f减去g，会得到求和前的f，赋值给g
        }
        return f;
    }
}
