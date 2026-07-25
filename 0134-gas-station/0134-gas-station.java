class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;  // total gas - total cost
        int tank     = 0;  // current tank
        int start    = 0;  // candidate starting station

        for (int i = 0; i < gas.length; i++) {
            int net = gas[i] - cost[i];
            totalGas += net;
            tank     += net;

            // Can't reach next station from start
            if (tank < 0) {
                start = i + 1;  // try next station
                tank  = 0;      // reset tank
            }
        }

        // If total gas >= total cost, start is valid
        return totalGas >= 0 ? start : -1;
    }
}