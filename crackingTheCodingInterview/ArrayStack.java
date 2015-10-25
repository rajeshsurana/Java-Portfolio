/*
Describe how you could use a single array to implement three stacks.
*/
public class ArrayStack{
    private final int stackSize = 100;
    private int[] stack = new int[stackSize *3];
    private int[] stackTop = {-1, -1, -1};
    
    // Stack numbers are 0, 1, 2
    public boolean push(int stackNum, int value){
        // Check for wrong Stack Number
        if(stackNum > 2 || stackNum < 0){
            System.out.println("Wrong stack number.");
            return false;
        }
        
        // Check if stack is full
        if(stackTop[stackNum] +1 >= stackSize){
            System.out.println("Array is already full.");
            return false;
        }
        
        // Push to stack
        stackTop[stackNum]++;
        stack[absTopStack(stackNum)] = value;
        return true;
    }
    
    public int pop(int stackNum){
        // Check for wrong Stack Number
        if(stackNum > 2 || stackNum < 0){
            System.out.println("Wrong stack number.");
            return -1;
        }
        
        // Check for empty stack 
        if(isEmpty(stackNum)){
            System.out.println("Empty stack : " + stackNum);
            return -1;
        }
        
        // Pop stack
        int value = stack[absTopStack(stackNum)];
        stack[absTopStack(stackNum)] = 0;
        stackTop[stackNum]--;
        return value;
    }
    
    public int peek(int stackNum){
        // Check if empty
        if(isEmpty(stackNum) ){
            System.out.println("Empty stack : " + stackNum);
            return -1;
        }
        return stack[absTopStack(stackNum)];
    }
    
    public boolean isEmpty(int stackNum){
        return stackTop[stackNum] == -1;
    }
    
    private int absTopStack(int stackNum){
        return stackNum * stackSize + stackTop[stackNum];
    }
    
    public static void main(String[] args){
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push(0, 4);
        arrayStack.push(1, 4);
        arrayStack.push(0, 5);
        arrayStack.push(0, 6);
        System.out.println(arrayStack.peek(0));
        System.out.println(arrayStack.pop(1));
        System.out.println(arrayStack.pop(1));
    }
}

