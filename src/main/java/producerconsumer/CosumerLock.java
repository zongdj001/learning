package producerconsumer;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CosumerLock implements Runnable {

    private List<Object> elements;
    
    private ReentrantLock lock;
    private Condition isNotFullCondtion;
    private Condition isEmptyCondition;
    public CosumerLock(List<Object> elements, ReentrantLock lock, Condition isFull, Condition isEmpty) {
        this.elements = elements;
        this.lock = lock;
        this.isNotFullCondtion = isFull;
        this.isEmptyCondition = isEmpty;
    }
    
    public  void consume() throws InterruptedException {
        while (true && !Thread.currentThread().isInterrupted()) {
            
            lock.lock();
            try {
                while (elements.isEmpty()) {
                    isEmptyCondition.await();
                }  
                Object element = elements.remove(0);
                
                System.out.println(Thread.currentThread().getName() + ": content consumed " + element);
                isNotFullCondtion.signalAll();
                
            } finally {
                lock.unlock();
            }
            
        }
        
    }

    @Override
    public void run() {
        try {
            consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }

}
