/*
Imagine a (literal) stack of plates. If the stack gets too high, it migh t topple. Therefore,
in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetOf-
Stacks should be composed of several stacks and should create a new stack once
the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.
pop () should behave identically to a single stack (that is, pop () should return the
same values as it would if there were just a single stack).
*/

import java.util.*;
public class SetOfStacks{
	private ArrayList<Stack> stacks = new ArrayList<Stack>();
	public void push(Integer value){
		Stack<Integer> last = getLastStack();
		if(last != null && !last.isFull()){
        last.push(value);
        }else{
            Stack<Integer> stack = new Stack<Integer>();
            last.push(value);
            stacks.add(last);
        }
    }

    public Integer pop(){
        Stack<Integer> last = getLastStack();
        if(last == null || last.isEmpty()){
            return -1;
        }
        Integer value = last.pop();
        if(last.isEmpty()){
            stacks.remove(stacks.size()-1);
        }
        return value;
    }
    
    private Stack<Integer> getLastStack(){
        if(stacks.size()==0) return null;
        return (Stack<Integer>) stacks.get(stacks.size()-1);
    }
}