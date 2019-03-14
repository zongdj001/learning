package thread.runsametime;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CyclicBarrierRunSameTimeJob implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(CyclicBarrierRunSameTimeJob.class);
    private CyclicBarrier runGater;
    public CyclicBarrierRunSameTimeJob(CyclicBarrier runGater) {
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
         } catch (BrokenBarrierException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    
}
