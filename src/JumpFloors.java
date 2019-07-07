/*
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * */
public class JumpFloors {
    public int jumpFloor(int target) {
        if (target <= 0) return 0;
        else if (target == 1) return 1;
        else if (target == 2) return 2;
            /*
             * 如果两种跳法，1阶或者2阶，假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1)；
             * 假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)；
             * 由上面两个假设可以得出总跳法为: f(n) = f(n-1) + f(n-2)；
             * 然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2；
             * 可以发现最终得出的是一个斐波那契数列。
             * */
        else return jumpFloor(target - 1) + jumpFloor(target - 2);
    }
}
