package queue;

import java.util.Stack;

public class MyQueue <T> {
    
    private Stack<T> statckNewest;
    private Stack<T> stackOldest;
    
    public MyQueue () {
        statckNewest = new Stack<T>();
        stackOldest = new Stack<T>();
    }
    
    public int size() {
        return stackOldest.size() + statckNewest.size();
    }
    
    public void add(T ele) {
        statckNewest.push(ele);
    }
    
    public T peek() {
        shiftStatcks();
        return stackOldest.peek();
    }
    private void shiftStatcks() {
        if (stackOldest.isEmpty()) {
            while(!statckNewest.isEmpty()) {
                stackOldest.push(statckNewest.pop());
            }
        }
    }
    public T remove() {
        shiftStatcks();
        return stackOldest.pop();
    }
    
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<Integer>();
        
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        System.out.println(myQueue.peek());
        
        System.out.println(myQueue.remove());
        
        myQueue.add(4);
        
        System.out.println(myQueue.remove());
        System.out.println(myQueue.remove());
        System.out.println(myQueue.remove());
        
    }

}
