import java.util.Stack;

public class MinStack {
    int min = Integer.MAX_VALUE;
    Stack <Integer>ne;
    public MinStack() {

        ne= new Stack<>();

    }

    public void push(int val) {
        if(val<=min){
            ne.push(min);
            min = val;
        }
        ne.push(val);
    }

    public void pop() {
        if(ne.pop() == min) min = ne.pop();
        else ne.pop();

    }

    public int top() {
        return ne.peek();

    }

    public int getMin() {
        return min;

    }
}