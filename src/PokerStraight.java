import java.util.Arrays;

/*
* 判断一组牌（以数组的形式）是不是顺子，其中大小王可以作为癞子变成任何数（用0表示），A为1，J为11，Q为12，K为13
* */
public class PokerStraight {
    public boolean isContinuous(int [] numbers) {
        int numOfZero=0,numOfInterval=0;  //初始化癞子数量和需要使用癞子的数量（0的数量以及排序后前后元素相差超过1的总间隔数）
        if(numbers==null || numbers.length==0) return false;
        Arrays.sort(numbers);
        for(int i=0;i<numbers.length-1;i++){  //这里游标i只遍历到numbers.length-1是因为下面有numbers[i+1]，如果是numbers.length最后numbers[i+1]会报空指针异常
            if(numbers[i]==0){  //如果遇到一个0就把癞子数量加1
                numOfZero++;
            }else if(numbers[i]==numbers[i+1]){  //如果遇到相邻前后元素相同说明遇到对子，一定不是顺子
                return false;
            }else{  //没遇到对子和癞子的时候，累加计算需要的癞子总数目，还需要减1是因为顺子是等差数列，相邻元素本来就差1，这个1不能算进去，差2以上每多1才需要1个癞子
                numOfInterval+=numbers[i+1]-numbers[i]-1;
            }
        }
        if(numOfZero>=numOfInterval) return true;  //如果癞子的数量足以补充数字的差值，则为顺子，否则就不是
        else return false;
    }
}
