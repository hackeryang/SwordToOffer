/*
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * */
public class MoreThanHalfTimes {
    public int moreThanHalfNum(int[] array) {
        //数组为空与数组长度为0概念不同，先判断是否为空是因为如果对空数组求长度会报NullPointerException异常
        if (array == null || array.length == 0) return 0;
        int result = array[0];  //先将数组开头元素作为向后遍历的游标，就像士兵阵地攻守，一开始第一个数字为第一个士兵，计数为1
        int times = 1;  //初始出现次数设为1
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {  //计数为0时说明阵地上没有士兵，以新的数组当前元素值作为新的士兵，计数为1进行后续比较
                result = array[i];
                times = 1;
            } else {
                if (array[i] == result) times++;  //当阵地上有士兵时，如果遇到相同值为友军，计数加1
                else times--;  //遇到不相同元素为敌人，同归于尽计数减1
            }
        }
        times = 0;  //之前的比较后阵地上最后留下来的士兵一定是出现次数最多的，将计数重置，从数组开头重新计算出现次数
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) times++;
        }
        if (2 * times <= array.length) return 0;  //如果出现次数没超过数组一半长度，则返回0，否则返回该元素
        else return result;
    }
}
