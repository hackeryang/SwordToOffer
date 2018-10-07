import java.util.HashMap;

/*
* 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
* 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
* Parameters:
* numbers:      an array of integers
* length:       the length of array numbers
* duplication:  (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
*               Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
* 这里要特别注意~返回任意重复的一个，赋值duplication[0]
* Return value: true if the input is valid, and there are some duplications in the array number, otherwise false
* */
public class DuplicatedIntInArray {
    /*
    * 内存占用更小的解法，JVM没有用于操作boolean的字节码指令，在编译后用int的数据类型代替boolean，此时boolean占4字节。
    * boolean[]数组编译后会被byte[]数组代替，此时的boolean占1字节。
    * 计算机处理处理数据的最小单元是1字节，一般如果有效数据只占1位的话，其余7位会被0补齐。
    * 综上，boolean单独存在占4字节，在boolean[]中占1字节。
    * */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null || numbers.length==0) return false;
        boolean[] b=new boolean[length];
        for(int i=0;i<length;i++){
            if(b[numbers[i]]==true){  //默认boolean数组每个元素都是false，当i不同但是两个numbers[i]相同时，b[numbers[i]]会指向同一个元素即true
                duplication[0]=numbers[i];
                return true;
            }else{  //在没有遇到重复元素时，将遇到的boolean数组元素都置为true
                b[numbers[i]]=true;
            }
        }
        return false;
    }

    //先遍历数组，用一个HashMap存放每个数组元素出现的次数，然后找到次数超过一次的直接返回该元素，与FirstNotRepeatingChar.java思想相同
    /*public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null || numbers.length==0) return false;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int count;
        for(int i=0;i<length;i++){
            if(map.containsKey(numbers[i])){
                count=map.get(numbers[i]);
                map.put(numbers[i],++count);
            }else{
                map.put(numbers[i],1);
            }
        }
        for(int i=0;i<length;i++){
            if(map.get(numbers[i])>1){
                duplication[0]=numbers[i];
                return true;
            }
        }
        return false;
    }*/
}
