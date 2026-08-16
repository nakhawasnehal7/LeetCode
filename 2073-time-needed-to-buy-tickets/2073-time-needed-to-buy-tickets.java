class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;

        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                // Before or AT k: buys min(tickets[i], tickets[k])
                time += Math.min(tickets[i], tickets[k]);
            } else {
                // After k: buys min(tickets[i], tickets[k]-1)
                time += Math.min(tickets[i], tickets[k] - 1);
            }
        }

        return time;
    }
}