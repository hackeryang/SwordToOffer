/*
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * */
public class HasPathInMatrix {
    /*
     * 回溯法基本思想：
     * 0.根据给定数组，初始化一个标志位数组，初始化为false，表示未走过，true表示已经走过，不能走第二次
     * 1.根据行数和列数，遍历数组，先找到一个与str字符串的第一个元素相匹配的矩阵元素，进入judge
     * 2.根据i和j先确定一维数组的位置，因为给定的matrix是一个一维数组
     * 3.确定递归终止条件：越界，当前找到的矩阵值不等于数组对应位置的值，已经走过的，这三类情况，都直接false，说明这条路不通
     * 4.若k，即待判定的字符串str的索引已经判断到了最后一位，此时说明是匹配成功的
     * 5.递归不断地寻找周围四个格子是否符合条件，只要有一个格子符合条件，就继续再找这个符合条件的格子的四周是否存在符合条件的格子，直到k到达末尾或者不满足递归条件就停止。
     * 6.走到这一步，说明本次路径是不成功的，要还原一下标志位数组index处的标志位，进入下一轮的判断。
     * */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] flag = new boolean[matrix.length];  //初始化标志位数组，默认每个元素都没经过，因此默认值都是false
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {  //循环遍历二维数组，找到起点等于str第一个元素的值，再递归判断上下左右四周是否有符合条件的
                if (judge(matrix, i, j, rows, cols, flag, str, 0)) {
                    return true;  //若找到一条完全匹配的路径，返回true
                }
            }
        }
        return false;  //如果整个矩阵中都没有找到一条完全匹配的路径，返回false
    }

    //judge(初始矩阵，索引行坐标i，索引纵坐标j，矩阵行数，矩阵列数，标志位数组，待判断的字符串，待判断字符串的索引[初始为0即先判断字符串的第一位])
    private boolean judge(char[] matrix, int i, int j, int rows, int cols, boolean[] flag, char[] str, int k) {
        int index = i * cols + j;  //根据i和j计算当前元素在matrix中的位置（行和列数是模拟出来的，实际上matrix是一维数组）
        if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[index] != str[k] || flag[index] == true) {
            return false;  //如果数组索引超过矩阵行和列的有效范围，矩阵数组当前元素不等于待匹配字符串中第k个元素，或者当前元素之前路径已经遇到过，返回false
        }
        if (k == str.length - 1) return true;  //若k已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true
        flag[index] = true;  //当前元素遇到过了，在标志位数组对应位置设为true
        //回溯，递归寻找matrix当前位置的左右下上四周位置的下一个元素是否匹配，每次找到了就给k加一匹配str的下一个字符，找不到就回退还原一个元素尝试其他方向
        if (judge(matrix, i - 1, j, rows, cols, flag, str, k + 1) ||
                judge(matrix, i + 1, j, rows, cols, flag, str, k + 1) ||
                judge(matrix, i, j - 1, rows, cols, flag, str, k + 1) ||
                judge(matrix, i, j + 1, rows, cols, flag, str, k + 1)) {
            return true;
        }
        //走到这，说明这一条路径到该元素处不通，没有匹配到str的第k处字符，就还原回退一个位置，从上一个元素再试四周其他的路径，被回退的元素标志位置为false，且此路径判断为false
        flag[index] = false;
        return false;
    }
}
