/**
 * 加油站
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int leave = gas[i] - cost[i];
            total += leave;
            sum += leave;
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        
        return total >= 0 ? start : -1;
    }
}