import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Main {

    public static int ARRAY_SIZE = 20;
    public static int RANDOM_GENERATION = 500;

    public static void main(String[] args) {

        LongAdder report = new LongAdder();

        long[] array1 = new long[ARRAY_SIZE];
        generationArray(array1);
        Thread shop1 = new Thread(new Account(array1, report));
        shop1.start();

        long[] array2 = new long[ARRAY_SIZE];
        generationArray(array2);
        Thread shop2 = new Thread(new Account(array2, report));
        shop2.start();

        long[] array3 = new long[ARRAY_SIZE];
        generationArray(array3);
        Thread shop3 = new Thread(new Account(array3, report));
        shop3.start();

        try {
            shop1.join();
            shop2.join();
            shop3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Закрытие кассы. Выручка по всем магазинам за день составляет " + report.sum());
    }

    public static void generationArray(long[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(RANDOM_GENERATION);
        }
    }
}
