/*
* 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
* 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
* 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
* */
public class RobotRange {
    public int movingCount(int threshold, int rows, int cols){
        boolean[][] visited=new boolean[rows][cols];  //初始化一个标志位数组，存放哪些位置机器人已经走过
        return countSteps(threshold,rows,cols,0,0,visited);  //从矩阵左上角开始计算能达到的格子数
    }

    private int countSteps(int threshold,int rows,int cols,int i,int j,boolean[][] visited){
        if(i<0 || i>=rows || j<0 || j>=cols || bitSum(i)+bitSum(j)>threshold || visited[i][j]){
            return 0;  //如果行和列的索引超出标志位二维数组的范围，或者走到这一位置发现这位置已经走过了，或者格子二维坐标的各位上的数字相加大于阈值，返回0
        }
        visited[i][j]=true;  //走到当前位置，把标记位置为true
        //递归计算自己这一步（+1）和左右下上四周位置的步数，就是总的能到达的格子数
        return countSteps(threshold,rows,cols,i-1,j,visited)
                +countSteps(threshold,rows,cols,i+1,j,visited)
                +countSteps(threshold,rows,cols,i,j-1,visited)
                +countSteps(threshold,rows,cols,i,j+1,visited)
                +1;
    }

    private int bitSum(int t){
        int count=0;
        while(t!=0){  //还有某个位的数字没有加进去时，对坐标以10求余，这样count就能累加从个位开始每一位上的数字，再把坐标除以10把上一位移到个位继续计算
            count+=t%10;
            t/=10;
        }
        return count;
    }
}
