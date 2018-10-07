import java.util.ArrayList;

/*
* 输入一个递增排序的数组和一个数字sum，在数组中查找两个数，使得他们的和正好是sum，如果有多对数字的和等于sum，输出两个数的乘积最小的。
* */
public class SumOfTwoIntsInArray {
    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list=new ArrayList<Integer>();  //使用一个列表存放相加等于sum且乘积最小的两个数
        if(array==null || array.length<2) return list;
        int i=0,j=array.length-1;  //使用一头一尾两个游标向中间遍历
        while(i<j){
            if(array[i]+array[j]==sum){
                list.add(array[i]);
                list.add(array[j]);
                return list;
            }else if(array[i]+array[j]>sum){  //当相加的和大于sum时，右边游标向左移
                j--;
            }else{  //当相加的和小于sum时，左边游标向右移，乘积是倒抛物线，越远离对称轴乘积越小，所以最终遇到的第一组两个数一定是乘积最小
                i++;
            }
        }
        return list;
    }
}
