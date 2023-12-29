package Lab8;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int numThreads = 8;

        long iterations = 1000000000L;

        long startTime = System.currentTimeMillis();
        ResultContainer[] results = new ResultContainer[numThreads];

        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            results[i] = new ResultContainer();
            threads[i] = new Thread(new MonteCarloPiTask(iterations / numThreads, results[i]));
            threads[i].start();
        }

        try {
            for (int i = 0; i < numThreads; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long totalPointsInsideCircle = 0;
        for (int i = 0; i < numThreads; i++) {
            totalPointsInsideCircle += results[i].pointsInsideCircle;
        }
        long endTime = System.currentTimeMillis();

        double piApproximation = 4.0 * totalPointsInsideCircle/iterations;
        System.out.printf("PI is %.5f%n", piApproximation);
        System.out.println("THREADS " + numThreads);
        System.out.println("ITERATIONS " + iterations);
        System.out.println("TIME " + (endTime - startTime) + "ms");
    }

    static class ResultContainer {
        long pointsInsideCircle = 0;
    }

    static class MonteCarloPiTask implements Runnable {
        private final long iterations;
        private final ResultContainer resultContainer;

        public MonteCarloPiTask(long iterations, ResultContainer resultContainer) {
            this.iterations = iterations;
            this.resultContainer = resultContainer;
        }

        @Override
        public void run() {
            Random random = new Random();
            long pointsInsideCircle = 0;

            for (long i = 0; i < iterations; i++) {
                double x = random.nextDouble();
                double y = random.nextDouble();
                double distance = x * x + y * y;

                if (distance <= 1.0) {
                    pointsInsideCircle++;
                }
            }

            resultContainer.pointsInsideCircle = pointsInsideCircle;
        }
    }
}

