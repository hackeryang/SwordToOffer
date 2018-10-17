/*
* 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
* 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
* */
public class TwoDimensionalArraySearch {
    //二分查找解法，把每一行看成有序递增的数组，利用二分查找，通过遍历每一行得到答案，时间复杂度是mlogn
    public boolean find(int target, int [][] array) {
        for(int i=0;i<array.length;i++){
            int low=0,high=array[i].length-1;
            while(low<=high){
                int mid=(low+high)>>1;  //在二进制中按位右移一位相当于十进制的除以2
                if(target>array[i][mid]){
                    low=mid+1;
                }else if(target<array[i][mid]){
                    high=mid-1;
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    //利用二维数组由上到下，由左到右递增的规律，算法复杂度为O(m+n)
    public boolean Find(int target, int [][] array) {
        int i=array.length-1,j=0;
        while(i>=0 && j<array[0].length){  //选取左下角元素开始与target比较，当target小于元素a[row][col]时，那么target必定在元素a所在行的上方
            if(target<array[i][j]){
                i--;
            }else if(target>array[i][j]){  //当target大于元素a[row][col]时，那么target必定在元素a所在列的右边
                j++;
            }else{
                return true;
            }
        }
        return false;
    }
}
