/*
* 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
* 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
* 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和(子向量的长度至少是1)
* */
public class BiggestSumOfSubArray {  //使用动态规划的思想
    public int findGreatestSumOfSubArray(int[] array) {
        if(array==null || array.length==0) return 0;
        int result=array[0];  //存放最大连续子序列的和
        int currentMax=array[0];  //存放当前元素为末尾元素的子数组的最大值
        /*
        * F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
        * F（i）=max（F（i-1）+array[i] ， array[i]）
        * res：所有子数组的和的最大值
        * res=max（res，F（i））
        * 如数组[6, -3, -2, 7, -15, 1, 2, 2]
        * 初始状态：F（0）=6，res=6
        * i=1：
        * F（1）=max（F（0）-3，-3）=max（6-3，-3）=3
        * res=max（F（1），res）=max（3，6）=6
        * i=2：
        * F（2）=max（F（1）-2，-2）=max（3-2，-2）=1
        * res=max（F（2），res）=max（1，6）=6
        * */
        for(int i=1;i<array.length;i++){
            currentMax=Math.max(currentMax+array[i],array[i]);
            result=Math.max(currentMax,result);
        }
        return result;
    }
}
