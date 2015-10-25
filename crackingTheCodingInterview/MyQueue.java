/*
Implement a MyQueue class which implements a queue using two stacks.
*/

import java.util.*;
public class MyQueue<T>{
    private Stack<T> oldStack = new Stack<T>();
    private Stack<T> newStack = new Stack<T>();
    
    public int size(){
        return oldStack.size() + newStack.size();
    }
    
    // add to new stack
    public void enqueue(T value){
        newStack.push(value);
    }
    
    public T dequeue(){
        stackShift();
        return oldStack.pop();
    }
    public T front(){
        stackShift();
        return oldStack.peek();
    } 
    
    // Whenever we need to pop or peek update 
    // oldStack if its empty
    private void stackShift(){
        if(oldStack.isEmpty()){
            while(!newStack.isEmpty()){
                oldStack.push(newStack.pop());
            }
        }
    }
    public static void main(String[] args){
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.enqueue(25);
        queue.enqueue(27);
        System.out.println(queue.front()); // 25
        System.out.println(queue.dequeue()); // 25
        System.out.println(queue.dequeue()); // 27
        System.out.println(queue.dequeue()); // Exception
    }
}