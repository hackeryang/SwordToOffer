import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
* 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
* */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class TwoIntsAppearedOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        ArrayList<Integer> list=new ArrayList<Integer>();  //利用一个列表存放不重复的两个整数
        Arrays.sort(array);
        for(int i=0;i<array.length;i++){
            if(i+1<array.length && array[i]==array[i+1]){  //排序后的数组如果出现重复的两个相邻元素，则循环游标跳过array[i+1]，从array[i+2]再开始循环
                i++;
            }else{  //如果发现相邻元素不重复的数，说明就是只出现一次的数，加入列表
                list.add(array[i]);
            }
        }
        if(list.size()!=0){  //最后列表只添加了两个数，输出列表存储的开头两个数即为结果
            num1[0]=list.get(0);
            num2[0]=list.get(1);
        }
    }

    //另一种方法，思路与FirstNotRepeatingChar.java相同
    /*public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
        for(int i=0;i<array.length;i++){
            if(hashMap.containsKey(array[i])){
                int count=hashMap.get(array[i]);
                hashMap.put(array[i],++count);
            }else{
                hashMap.put(array[i],1);
            }
        }
        for(int i=0;i<array.length;i++){
            if(hashMap.get(array[i])==1){
                if(num1[0]==0) num1[0]=array[i];
                else num2[0]=array[i];
            }
        }
    }*/
}
