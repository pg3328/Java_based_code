public class Solution {

        public int minCostClimbingStairs(int[] cost) {
            int[] opt = new int[cost.length+1];
            for(int i=0;i<cost.length;i++){
                opt[i] = cost[i];
            }
            for(int j=2;j<opt.length;j++){
                if(j==cost.length)
                opt[j] = Math.min(opt[j-1],opt[j-2])+cost[j];
            }
            return opt[opt.length-1];
        }

    public static void main(String[] args) {
        int[]cost = new int[] {10,15,20};
        Solution sol = new Solution();
        sol.minCostClimbingStairs(cost);

    }
}