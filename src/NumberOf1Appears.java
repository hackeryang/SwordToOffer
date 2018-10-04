/*
* 求出任意非负整数区间中1出现的次数（从1到n中1出现的次数），例如1~13中包含1的数字有1、10、11、12、13因此共出现6次
* */
public class NumberOf1Appears {
    public int numberOf1Between1AndN(int n) {
        int count=0;
        StringBuffer allNums=new StringBuffer();
        for(int i=1;i<n+1;i++){
            allNums.append(i);
        }
        for(int i=0;i<allNums.length();i++){
            if(allNums.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }
}
