public class ClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==0 || cost.length==1) return 0;
        int[] opt = new int[cost.length+1];
        opt[0]=0;
        opt[1]=0;
        for(int i=2;i<opt.length;i++){
            opt[i] = Math.min(cost[i-1]+opt[i-1] , cost[i-2]+opt[i-2]);
        }
        return opt[opt.length-1];

    }
}
