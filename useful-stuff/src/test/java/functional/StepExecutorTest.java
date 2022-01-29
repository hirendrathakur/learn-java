package functional;

import org.junit.jupiter.api.Test;

public class StepExecutorTest {

    @Test
    public void test() {
        StepExecutor step1 = () -> {
            System.out.println("Step 1 executed");
            return true;
        };

        StepExecutor step2 = () -> {
            System.out.println("Step 2 executed");
            return true;
        };

        StepExecutor step3 = () -> {
            System.out.println("Step 3 executor");
            return true;
        };

        step1.thenExecute(step2).thenExecute(step3).execute();
    }
}
