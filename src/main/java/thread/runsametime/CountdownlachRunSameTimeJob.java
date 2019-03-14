package thread.runsametime;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountdownlachRunSameTimeJob implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountdownlachRunSameTimeJob.class);
    private CountDownLatch runGater;
    public CountdownlachRunSameTimeJob(CountDownLatch runGater) {
        this.runGater = runGater;
    }
    @Override
    public void run() {
        
        try {
            LOGGER.info("Thread - {} is ready and wait for run from time {}", Thread.currentThread().getName(), System.nanoTime());
            runGater.await();
            LOGGER.info("Thread - {} is start running at time {}", Thread.currentThread().getName(), System.nanoTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
         }
        
    }
    
    
}
