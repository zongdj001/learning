package consumerlock;

import java.util.List;

public class ProducerSycn implements Runnable{
    private final int MAX_SIZE = 10;
    private List<Object> elements;
    
    public ProducerSycn(List<Object> elements) {
        this.elements = elements;
    }
    public void generateContent(Object element) throws InterruptedException {
        synchronized(elements) {
            while (elements.size() == MAX_SIZE) {// MUST use while loop, use if can make deadlock
                elements.wait();
            }
            elements.add(element);
            System.out.println(Thread.currentThread().getName() + " : conent generated " + element);
            elements.notifyAll();
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
