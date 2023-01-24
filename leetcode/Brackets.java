import java.util.Stack;

public class Brackets {
    public boolean isValid(String s) {
        char [] ar = s.toCharArray();
        if(ar.length<=1) return false;
        else{
            int [] array = new int[ar.length];
            for(int i=0;i<ar.length;i++){
                switch (ar[i]){
                    case '(' : array[i] =1;break;
                    case '{' :  array[i] =2; break;
                    case '[' :  array[i] =3;break;
                    case ')' :  array[i] =-1;break;
                    case '}' :  array[i] =-2;break;
                    case ']' :  array[i] =-3;break;
                }

            }
            Stack<Integer> stack = new Stack <>();
            for (int k : array) {
                if (k>0)
                    stack.push(k);
                else {
                    if(stack.isEmpty()) return false;
                    if(Math.abs(k)!=stack.peek()) return false;
                    stack.pop();
                }
            }
            return true;
        }
    }
    public static void main(String[]args){
        String s = "()";
        Brackets br = new Brackets();
        System.out.println(br.isValid(s));
    }
}
