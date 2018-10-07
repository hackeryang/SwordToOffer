import java.util.ArrayList;

/*
* 找出所有和为sum的连续正数序列，例如一组连续正数和为100的序列:18,19,20,21,22，或者9~16
* */
public class SumOfSequentialInts {
    public ArrayList<ArrayList<Integer> > findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > result=new ArrayList<>();  //用一个列表存放包含连续多个正整数的多个列表
        /*
        * 设连续正整数序列的长度为n，这是一个公差为1的等差数列，为了让n尽量大使序列从1开始，则根据等差数列求和公式可得sum=(1+n)*n/2，可得n<sqrt(2*sum)。
        * 因此例如sum=100时，只需遍历n=14~2的情况，当n=8时，得到序列[9,10,11,12,13,14,15,16]；当n=5时，得到序列[18,19,20,21,22]。
        * */
        for(int n=(int)Math.sqrt(sum*2);n>=2;n--){
            //n&1为1说明是n为奇数，此时序列中间的数为序列的平均值，所以sum%n=0；当n为偶数时，例如4,5,6,7，平均值为5.5，小数部分为0.5说明余数是除数的一半，因此(sum%n)*2=n
            if((n&1)==1 && (sum%n)==0 || (sum%n)*2==n){
                ArrayList<Integer> list=new ArrayList<Integer>();  //用一个列表存放求和为sum的多个连续正整数
                for(int j=0,k=(sum/n)-(n-1)/2;j<n;j++,k++){  //sum/n为序列的中间值，因此往前减去序列长度的一半(n-1)/2就是该序列的起始值
                    list.add(k);
                }
                result.add(list);  //找到一种情况的n，并将该n时的连续正整数序列存入list后，将该list存入result列表
            }
        }
        return result;
    }
}
