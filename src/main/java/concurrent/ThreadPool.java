package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ThreadPool {
    
    public static class MyTask implements Runnable {
        int a;
        int b;
        MyTask(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public void run() {
            if (b == 0) {
                System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx");
            }
            System.out.println(System.currentTimeMillis() + ":ThreadId" + Thread.currentThread().getId());
            System.out.println(a/b);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            
        }
        
    }
    public static void main(String[] args) {
       
//        
//        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
//        for (int i = 0; i < 10; i++) {
//            MyTask task = new MyTask(10, i);
//            executor.submit(task);
//        }
        System.out.println(3/ 0);
    }
    
}