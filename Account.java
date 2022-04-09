import java.util.concurrent.atomic.LongAdder;

public class Account implements Runnable {

    private final long[] array;
    private final LongAdder report;

    public Account(long[] array, LongAdder report) {
        this.array = array;
        this.report = report;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            report.add(array[i]);
        }
    }
}
