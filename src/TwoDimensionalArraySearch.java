/*
* 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
* 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
* */
public class TwoDimensionalArraySearch {
    public boolean Find(int target, int [][] array) {
        boolean contain=false;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                if(target==array[i][j]){
                    contain=true;
                }
            }
        }
        return contain;
    }
}
