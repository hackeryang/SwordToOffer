/*
* 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
* */
public class IntToBinaryCount {
    public int NumberOf1(int n) {
        String str="";
        int count=0;
        for(int i=31;i>=0;i--){
            str=str+(n>>>i&1);  //将整数每一个高位右移至相应的最低位再“与”1，结果转换为字符串从左到右排列输出，依然是原来的二进制
        }
        char[] charArray=str.toCharArray();
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]=='1'){
                count++;
            }
        }
        return count;
    }
}
