package producerconsumer;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerLock implements Runnable{
    private final int MAX_SIZE = 10;
    private List<Object> elements;
    private Condition isNotFullCondtion;
    private Condition isNotEmptyCondition;
    ReentrantLock lock;
    
    public ProducerLock(List<Object> elements, ReentrantLock lock, Condition isNotFull, Condition isNotEmpty) {
        this.lock = lock;
        this.elements = elements;
        this.isNotFullCondtion = isNotFull;
        this.isNotEmptyCondition = isNotEmpty;
    }
    public void generateContent(Object element) throws InterruptedException {
        lock.lock();
        try {
            while (elements.size() == MAX_SIZE) {// MUST use while loop, use if can make deadlock
                isNotFullCondtion.await();
            }
            elements.add(element);
            System.out.println(Thread.currentThread().getName() + " : conent generated " + element);
            isNotEmptyCondition.signalAll();
            
        } finally {
            lock.unlock();
        }
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                generateContent("element " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
