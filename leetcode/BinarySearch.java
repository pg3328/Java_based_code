import java.util.Arrays;

public class BinarySearch {
    public int search(int[] nums, int target) {
        return searchRec(nums,target,0,nums.length-1);
    }
    public int searchRec(int[]nums, int target, int start, int end){

        if(start>end ) return -1;
        else{
            int middle = (start+end)/2;
            if(nums[middle] == target) return middle;
            else if(nums[middle]<target) {
                return searchRec(nums,target, middle+1,end);}
        else  return searchRec(nums,target,start,middle-1);


    }}
    public static void main(String[]args){
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.search(new int[] {-1,0,3,5,9,12},12));
    }

}
