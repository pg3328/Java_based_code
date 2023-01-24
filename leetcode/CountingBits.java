public class CountingBits {
    public int onesInBinary(int number){
        int n = number;
        int count =0;
        while(n>0){
            int bit = n%2;
            if(bit==1) count+=1;
            n=n/2;
        }
        return count;
    }
    public int[] countBit(int n) {
        int[]  answer = new int[n+1];
        for(int i=0;i<n+1;i++){
            answer[i] = onesInBinary(i);
        }
        return answer;

    }
    public static void main(String[]args){
        CountingBits cb = new CountingBits();
        System.out.println(cb.countBit(2));
    }

}
