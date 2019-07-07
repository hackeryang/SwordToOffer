import java.util.ArrayList;

/*
 * 包含的质数因子只有2、3和5的数被称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * */
public class GetUglyNumber {
    public int getUglyNumber(int index) {
        if (index <= 0) return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();  //用一个列表存放丑数
        int i2 = 0, i3 = 0, i5 = 0;  //一开始丑数为1，因此后面产生的丑数为1*2，1*3，1*5，这里分别存放乘以2的最小的数、乘以3的最小的数、乘以5的最小的数的索引
        list.add(1);
        while (list.size() < index) {
            int m2 = list.get(i2) * 2;
            int m3 = list.get(i3) * 3;
            int m5 = list.get(i5) * 5;
            //比较三个丑数中的最小值，例如第一轮中1*2，1*3和1*5中2最小，则接下来比较2*2，1*3和1*5最小为3，第三轮比较2*2，3*2和1*5，所以先比较后面再比较前面
            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);  //将比较出的最小丑数放入列表
            if (min == m2) i2++;  //如果上一轮比较中的最小丑数来源于三个比较索引中的某一个，则对应索引加一，对应下一个索引的丑数乘2，乘3或乘5后加入下一轮比较
            if (min == m3) i3++;
            if (min == m5) i5++;
        }
        return list.get(list.size() - 1);  //返回列表中最后一个丑数即为从小到大的第N个丑数
    }
}
