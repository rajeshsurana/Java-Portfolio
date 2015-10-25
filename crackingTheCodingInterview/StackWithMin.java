/*
How would you design a stack which, in addition to push and pop, also has a
function min which returns the minimum element? Push, pop and min should all
operate in 0(1) time.
*/

import java.util.Stack;
public class StackWithMin extends Stack<Integer>{
	private Stack<Integer> s2;
	public StackWithMin(){
		s2 = new Stack<Integer>();
    }
    public void push(int value){
        // Push to s2 only if less than equal to min on top
        if(value <= min()){
        s2.push(value);
    }
    super.push(value);
    }

    public Integer pop(){
        // If top of stack is equal to min value in our s2
        if(super.peek() == s2.peek()){
            s2.pop();
    }
    return super.pop();
    }

    public Integer min(){
        // If empty return max value
        if(s2.isEmpty()){
            return Integer.MAX_VALUE;
    }
    return s2.peek();
    }

    public static void main(String[] args){
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(15);
        stackWithMin.push(13);
        stackWithMin.push(20);
        System.out.println(stackWithMin.min()); // 13
        System.out.println(stackWithMin.pop()); // 20
        System.out.println(stackWithMin.pop()); // 13
        System.out.println(stackWithMin.min()); // 15
    }
}