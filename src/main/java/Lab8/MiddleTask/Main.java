package Lab8.MiddleTask;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private static final int ARRAY_SIZE = 1_000_000;
    private static final int THRESHOLD = 20;

    public static void main(String[] args) {
        int[] array = new int[ARRAY_SIZE];
        Arrays.setAll(array, i -> (int) (Math.random() * 101));

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long result = forkJoinPool.invoke(new SumTask(array, 0, array.length));

        System.out.println("Sum: " + result);
    }

    static class SumTask extends RecursiveTask<Long> {
        private final int[] array;
        private final int start;
        private final int end;

        public SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                int mid = (start + end) / 2;
                SumTask leftTask = new SumTask(array, start, mid);
                SumTask rightTask = new SumTask(array, mid, end);
                invokeAll(leftTask, rightTask);
                return leftTask.join() + rightTask.join();
            }
        }
    }
}

