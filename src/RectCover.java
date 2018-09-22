/*
* 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
* */
public class RectCover {
    public int rectCover(int target) {
        if(target==1) return 1;
        else if(target==2) return 2;
        else if(target<=0) return 0;
        /*
        * 依然是斐波那契数列，设长为水平方向，宽为竖直方向，第一次若摆放为2*1，则剩余摆放方式有rectCover(n-1)种（因为竖直方向还有n-1层）；
        * 第一次若摆放为1*2，剩余摆放方式为rectCover(n-2)（因为竖直方向还有n-2层），如此递归
        * */
        else return rectCover(target-1)+rectCover(target-2);
    }
}
