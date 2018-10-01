import java.util.ArrayList;
import java.util.Collections;

/*
* 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
* 输入描述：输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
* 原理图：https://uploadfiles.nowcoder.net/images/20170705/7578108_1499250116235_8F032F665EBB2978C26C4051D5B89E90
* */
public class StringDictionarySort {
    public ArrayList<String> permutation(String str) {
        ArrayList<String> result=new ArrayList<String>();  //存放字母按各种排列情况的字符串
        if(str!=null&&str.length()>0){
            permutationHelper(str.toCharArray(),0,result);
            Collections.sort(result);  //对各种排列情况输出的字符串按照字典序排序
        }
                return result;
            }

            public void permutationHelper(char[] cs, int i, ArrayList<String> list){
                if(i==cs.length-1){  //当交换索引到达字符数组最后一位，相当于字符间的交换已经完成到了字符串倒数第二位，一种情况已经交换完成，输出一种字符组合结果
                    String val=String.valueOf(cs);
                    if(!list.contains(val)){
                list.add(val);
            }
        }else{
            for(int j=i;j<cs.length;j++){
                swap(cs,i,j);  //交换当前层的元素
                permutationHelper(cs,i+1,list);  //在上一行已交换一次的基础上再对已交换元素的后面元素进行交换
                swap(cs,i,j);  //负负得正，将交换过的元素再交换回到原来的样子，相当于回退到之前的状态，避免已改变值的字符数组影响其他不同情况下的交换
            }
        }
    }

    public void swap(char[] cs,int i,int j){
        char temp=cs[i];
        cs[i]=cs[j];
        cs[j]=temp;
    }
}
