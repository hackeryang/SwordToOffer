/*
 * 约瑟夫环问题，总共有n个人，编号为0到n-1，随机指定一个数m，让编号为0开始的人报数，每到第m-1的那个人要出来表演并不再回到环中。
 * 下一轮从这个走掉的人下一个人开始重新计为0号，继续数到m-1。。。如此循环直到最后环中只剩下一个人。
 * 求这个最后留下来的人在第一轮中的初始编号。
 * */
public class JosephusLoop {
    public int lastRemaining(int n, int m) {
        if (n <= 0) return -1;
        if (m <= 0) return n - 1;
        if (n == 1) return 0;
        /*
         * 采用递归思想，与通过哈希值来编号分区一样，当有n个人时，在第一轮中报数为m-1的人编号为(m-1)%n。设最后留下的人编号结果为f[n]；
         * 同理已经求得n-1个人情况下最后剩下的人的编号为f[n-1]，则f[n]=(f[n-1]+m)%n，
         * 因为上一轮出列一个人后，下一个人重新从0开始编号，所以n人为第一轮，n-1人为第二轮的情况下，第二轮把每个人原来的编号都减了m，
         * 因此重新加上m就能恢复到上一轮原来的编号，如此递归下去，只剩下一个人的情况即f[1]=0
         * */
        return (lastRemaining(n - 1, m) + m) % n;
    }

    //传统思路，占用内存与算法复杂度较大
   /* public int lastRemaining(int n, int m) {
        if(n<=0) return -1;
        if(m<=0) return n-1;
        Queue<Integer> queue=new LinkedList<Integer>();  //利用一个先进先出队列存放约瑟夫环
        for(int i=0;i<n;i++){
            queue.offer(i);  //将所有人的编号加入队列
        }
        while(queue.size()>1){
            for(int i=0;i<m-1;i++){
                queue.offer(queue.poll());  //每次都从队列头上踢出m-1项（从0到m-2），再把踢出的项加回到队列尾部，这样第m项（m-1）就会出现在队列头上
            }
            queue.poll();  //踢掉队列头上的第一项，就是上一个步骤被排出来的第m项（m-1），然后在while大循环中继续这样的排列踢出流程，直到只剩下一个人
        }
        return queue.poll();  //返回队列中的最后一个人
    }*/
}
