/*
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * */
public class ReorderArray {
    public void reorderArray(int[] array) {
        if (array.length == 0 || array.length == 1) return;  //数组中没有元素或只有一个元素不需要排序
        int oddCount = 0, oddBegin = 0;  //对奇数个数进行计数，作为第一个偶数放置的索引位置，计数索引处前面的元素都是奇数
        int[] tempArray = new int[array.length];  //将排序后的元素放在一个辅助数组中
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) oddCount++;  //奇数的二进制最低位一定是1，遇到奇数就把计数器加1
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) tempArray[oddBegin++] = array[i];  //如果遇到奇数就从辅助数组开头放置
            else tempArray[oddCount++] = array[i];  //如果遇到偶数就跳过奇数个数的索引数，从辅助数组后面开始放置偶数
        }
        System.arraycopy(tempArray, 0, array, 0, array.length);  //将辅助数组的所有元素复制替换掉原数组中的元素
    }
}
