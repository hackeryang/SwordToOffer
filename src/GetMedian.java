import java.util.ArrayList;
import java.util.Collections;

/*
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * */
public class GetMedian {
    ArrayList<Integer> list = new ArrayList<Integer>();

    public void insert(Integer num) {
        list.add(num);
    }

    public Double getMedian() {
        Collections.sort(list);  //将列表排序
        int length = list.size();
        if ((length & 1) == 1) {  //在二进制中，奇数的最低位一定为1，所以逻辑与1，1前面所有高位都补0，这样最低位不为0时一定是奇数
            return new Double(list.get(length / 2));  //当列表长度为奇数，直接返回中间的值
        } else {  //如果列表长度为偶数，则为了保留求平均结果的小数，将中间两个数都转换为double
            return new Double((double) (list.get(length / 2 - 1) + (double) list.get(length / 2)) / 2);
        }
    }
}
