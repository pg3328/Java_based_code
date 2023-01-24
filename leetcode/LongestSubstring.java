import java.sql.SQLOutput;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==1) return 1;
        char[] characters = s.toCharArray();
        int left =0;
        int right =1;
        int count=1;
        int maxcount=0;
        while(true){
            if(left>=characters.length||right>=characters.length) return maxcount;
            else if(characters[left]==characters[right]){
                left=left+1;
                right=left+1;
                maxcount = Math.max(count,maxcount);
                count=1;
            }
            else{

                int subleft = left;
                int flag=0;
                while(subleft< right){
                    if(characters[subleft]== characters[right]){
                        flag=1;
                        break;
                    }
                    subleft++;
                }
                if(flag==1){

                    count=1;
                    left=left+1;
                    right=left+1;
                }
                else{
                    count+=1;
                    right=right+1;
                }
                maxcount = Math.max(count,maxcount);

            }

        }

    }

    public static void main(String[] args) {
        LongestSubstring ls = new LongestSubstring();
        System.out.println(ls.lengthOfLongestSubstring("abcabcbb"));
    }
}
