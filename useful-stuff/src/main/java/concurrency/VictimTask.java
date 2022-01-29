package concurrency;

public class VictimTask implements Runnable {
    public int count;

    public VictimTask() {
        this.count = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            runSomeDummyProcess();
            ++count;
        }
    }

    private void runSomeDummyProcess() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
