public class HouseRobber {

    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        else if(nums.length==2) return Math.max(nums[0],nums[1]);
        else if (nums.length == 3) return Math.max(nums[0]+nums[2] , nums[1]);
        else{
            int min = Integer.MAX_VALUE;
            int opt[] = new int[nums.length];
            opt[0]= nums[0];
            opt[1]=nums[1];
            opt[2]=nums[2]+opt[0];
            for(int i=3;i<opt.length;i++){
                opt[i] = Math.max(opt[i-2]+nums[i] , opt[i-3]+nums[i]);
                if(opt[i]<min){
                    min = opt[i];
                }
            }
            return min;
        }
    }
}
