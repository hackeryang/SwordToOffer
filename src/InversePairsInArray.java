/*
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * */
public class InversePairsInArray {
    int count;
    private static int[] aux;  //将辅助数组放在方法的外面成为全局数组，避免每调用一次方法都新建一个辅助数组，导致占用内存过大

    public int inversePairs(int[] array) {
        if (array == null || array.length == 0) return 0;
        count = 0;
        aux = new int[array.length];  //一次性分配空间，这里必须要初始化容量为a.length，否则下面for循环k<=hi情况下递增到最后会报错NullPointerException
        mergeUpToDown(array, 0, array.length - 1);  //对整个数组进行归并排序并计数逆序对的数量
        return count;  //返回计算的逆序对数量
    }

    public void mergeUpToDown(int[] a, int lo, int hi) {  //将数组a[lo..hi]排序
        if (lo >= hi) return;
        int mid = (lo + hi) >> 1;  //二进制中按位向右移一位等同于除以2
        mergeUpToDown(a, lo, mid);  //递归将数组左半边排序
        mergeUpToDown(a, mid + 1, hi);  //递归将数组右半边排序
        merge(a, lo, mid, hi);  //归并左右半边的结果
    }

    public void merge(int[] a, int lo, int mid, int hi) {  //将a[lo..mid]和a[mid+1..hi]归并
        int i = lo, j = mid + 1;  //设置两个分别从数组头部和中间位置开始的两个游标，将数组分为左右两半进行归并比较
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];  //将辅助数组填满原数组原来顺序的元素，因为最后原数组会被填入排序过的元素
        }
        for (int k = lo; k <= hi; k++) {  //将a[lo..hi]填充排序过的元素
            if (i > mid) a[k] = aux[j++];  //左半边用尽，取右半边的元素
            else if (j > hi) a[k] = aux[i++];  //右半边用尽，取左半边的元素
            else if (aux[j] < aux[i]) {  //右半边的当前元素小于左半边的当前元素，取右半边的元素
                a[k] = aux[j++];
                count += mid - i + 1;  //此时发现逆序对，计数增加mid-i+1，因为当前面的数组值array[i]大于后面数组值array[j]时；则前面数组array[i]~array[mid]多个元素都是大于array[j]的
                count = count > 1000000007 ? count % 1000000007 : count;  //如果计数过大则根据题目要求进行取模运算
            } else a[k] = aux[i++];  //右半边的当前元素大于左半边的当前元素，取左半边的元素
        }
    }
}
