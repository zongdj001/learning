package consumerlock;

import java.util.List;

public class CosumerSync implements Runnable {
    private List<Object> elements;
    public CosumerSync(List<Object> elements) {
        this.elements = elements;
    }
    
    public  void consume() throws InterruptedException {
        while (true && !Thread.currentThread().isInterrupted()) {
            synchronized(elements) {//must synchronized at the shared object, should NOT add to mehtod
                while (elements.isEmpty()) {
                    elements.wait();
                }
                if (elements.size() == 0) {
                    System.out.println("error occur");
                }
                Object element = elements.remove(0);
                System.out.println(Thread.currentThread().getName() + ": content consumed " + element);
                elements.notifyAll();
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
