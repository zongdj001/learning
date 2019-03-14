package producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class ProduceConsumer {
    public static void main(String[] args) {
        List<Object> elements = new ArrayList<>();
       
        ProducerSycn generator = new ProducerSycn(elements);
        CosumerSync consumer = new CosumerSync(elements);
        
        Thread producerThread = new Thread(generator, "produce1");
        Thread producerThread2 = new Thread(generator, "produce2");
       
        producerThread2.start();
        
        Thread consumeThread2 = new Thread(consumer, "consumer2");
        
        Thread consumeThread3 = new Thread(consumer, "consumer3");
    
        Thread consumeThread4 = new Thread(consumer, "consumer4");
            
        consumeThread2.start();
        consumeThread3.start();
        consumeThread4.start();
        producerThread.start();
        
        
    }
}
