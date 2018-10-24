import java.util.ArrayList;
import java.util.Arrays;

/*
* 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
* */
public class MinKIntegers {
    public ArrayList<Integer> getLeastNumbers(int [] input, int k) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(input==null || input.length==0 || k>input.length) return list;
        Arrays.sort(input);
        for(int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }
}
