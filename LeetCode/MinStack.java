/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack
*/
class MinStack {
    private List<Integer> stack;
    private List<Integer> minStack;
    public MinStack(){
        stack = new ArrayList<Integer>();
        minStack = new ArrayList<Integer>(); 
    }
    
    public void push(int x) {
        stack.add(x);
        if(minStack.isEmpty()){
            minStack.add(x);
        }
        else if(minStack.get(minStack.size()-1)>=x){
            minStack.add(x);
        }
    }

    public void pop() {
        if(this.top() == minStack.get(minStack.size()-1)){
            minStack.remove(minStack.size()-1);
        }
        stack.remove(stack.size()-1);
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return minStack.get(minStack.size()-1);
    }
}
