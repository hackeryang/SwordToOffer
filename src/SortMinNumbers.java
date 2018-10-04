import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
* 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
* 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
* */
public class SortMinNumbers {
    public String printMinNumber(int [] numbers) {
        String str="";
        ArrayList<Integer> list=new ArrayList<Integer>();  //将数组中的元素都放入一个列表中便于利用列表的排序方法
        for(int i=0;i<numbers.length;i++){
            list.add(numbers[i]);
        }
        Collections.sort(list,new Comparator<Integer>(){  //通过比较器将list列表中的元素进行排序
            public int compare(Integer str1,Integer str2){
                String s1=str1+""+str2;  //通过引号""将整数对象转化为字符串
                String s2=str2+""+str1;
                return s1.compareTo(s2);  //比较两个整数互相颠倒后拼接成的两个大整数的大小
            }
        });
        for(int j:list){
            str+=j;  //将列表中从小到大排序过的元素都以字符串形式拼接，形成拼接的最小整数
        }
        return str;
    }
}
