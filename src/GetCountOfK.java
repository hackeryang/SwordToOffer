/*
* 统计一个数字在排序数组中出现的次数。
* */
public class GetCountOfK {
    public int getNumberOfK(int [] array , int k) {
        if(array==null || array.length==0) return 0;
        //使用二分查找思想，分别查找数字第一次和最后一次出现的位置
        int firstK=getFirstK(array,k,0,array.length-1);
        int lastK=getLastK(array,k,0,array.length-1);
        if(firstK!=-1 && lastK!=-1) return lastK-firstK+1;  //返回重复出现次数
        return 0;  //未找到则返回0
    }

    private int getFirstK(int[] array,int k,int start,int end){
        if(start>end) return -1;
        int mid=(start+end)>>1;  //在二进制中按位右移一位相当于除以2
        if(array[mid]>k){
            return getFirstK(array,k,start,mid-1);
        }else if(array[mid]<k){
            return getFirstK(array,k,mid+1,end);
        }else if(mid-1>=0 && array[mid-1]==k){  //如果找到的中点的前一个元素也是该重复元素，说明可能前面还有几个重复元素，则以中点前一位为下一轮终点再查找一次
            return getFirstK(array,k,start,mid-1);
        }else{
            return mid;  //最终找到的中点即该元素第一次出现的地方
        }
    }

    private int getLastK(int[] array,int k,int start,int end){
        int mid=(start+end)>>1;  //在二进制中按位右移一位相当于除以2，在循环外创建变量可避免每次循环都创建一个mid变量，浪费内存
        while(start<=end){
            if(array[mid]>k){
                end=mid-1;
            }else if(array[mid]<k){
                start=mid+1;
            }else if(mid+1<array.length && array[mid+1]==k){  //如果找到的中点的后一个元素也是该重复元素，说明可能后面还有几个重复元素，则以中点后一位为下一轮起点再查找一次
                start=mid+1;
            }else{
                return mid;  //最终找到的中点即该元素最后一次出现的地方
            }
            mid=(start+end)>>1;  //每一轮二分查找结束后查找起点或终点都会变化，所以需要更新中点
        }
        return -1;  //若没找到最后出现的位置则返回-1
    }
}
