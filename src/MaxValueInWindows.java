import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
* 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
* 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
* 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
* {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
* */
public class MaxValueInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result=new ArrayList<Integer>();  //用一个列表存放每次窗口移动一位后窗口内的最大值
        if(num==null || num.length==0 || size<=0 || num.length<size) return result;
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>(size,new Comparator<Integer>(){  //利用最大值排在前的优先队列自动比较放入队列的值
            public int compare(Integer i1,Integer i2){
                return i2-i1;  //这样重写比较器的比较函数，可以使前一个值小于后一个值时返回正数，与默认情况为负数相反
            }
        });
        int count=0;  //每次加入窗口的元素数量的计数
        for(int i=0;i<num.length-size+1;i++){  //num.length-size+1为最后一个窗口的开头位置
            while(count<size){  //当计数没达到窗口大小时，朝优先队列中添加元素，形成一个窗口
                queue.add(num[i+count]);
                count++;
            }
            result.add(queue.peek());  //经过优先队列排序后，最大元素排在前，因此队列第一个元素就是最大元素
            count=0;  //一个窗口中的最大元素已经找到，清空计数和优先队列中的元素，进行下一个窗口多个元素的添加
            queue.clear();
        }
        return result;
    }
}
