package functional;

public interface StepExecutor {

    boolean execute();

    default StepExecutor thenExecute(StepExecutor after) {
        boolean executionResult = this.execute();
        if (executionResult) {
            return after;
        } else {
            return () -> false;
        }
    }
}
