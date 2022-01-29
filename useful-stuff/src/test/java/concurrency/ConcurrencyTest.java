package concurrency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConcurrencyTest {

    /* Starting threads serially here*/
    @Test
    public void testWhenSingleThreaded() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            VictimTask victimTask = new VictimTask();
            Thread thread1 = new Thread(victimTask, "Thread1");
            Thread thread2 = new Thread(victimTask, "Thread2");
            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
            Assertions.assertEquals(10, victimTask.count);
        }
    }

    /* In case of multithreading, there is race condition */
    @Test
    public void testWhenMultiThreaded() throws InterruptedException {
        int freqOfCounterLessThan10 = 0;
        int freqOfCounterMoreThan10 = 0;
        for (int i = 0; i < 10; i++) {
            VictimTask victimTask = new VictimTask();
            Thread thread1 = new Thread(victimTask, "Thread1");
            Thread thread2 = new Thread(victimTask, "Thread2");
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            if (victimTask.count < 10) {
                ++freqOfCounterLessThan10;
            } else if (victimTask.count > 10) {
                ++freqOfCounterMoreThan10;
            }
        }
        Assertions.assertTrue(freqOfCounterLessThan10 > 0);
        Assertions.assertEquals(0, freqOfCounterMoreThan10);
    }
}
