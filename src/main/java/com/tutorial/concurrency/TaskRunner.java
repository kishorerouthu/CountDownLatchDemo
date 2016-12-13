package com.tutorial.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kishore on 13/12/16.
 */
public class TaskRunner {

    public static void main(String[] args) {
        int count = 200;
        ExecutorService service = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(count);
        RandomGeneratorClient client = new RandomGeneratorClient();

        List<RandomPair> randomPairs = generateData(count);
        for (RandomPair randomPair : randomPairs) {
            service.execute(new Task(client, latch, randomPair));
        }

        System.out.println("Wait until count down to zero " + latch.getCount());
        System.out.println(randomPairs);

        service.shutdown();
    }

    private static List<RandomPair> generateData(int count) {
        List<RandomPair> results = new ArrayList<RandomPair>(count);
        for (int i = 0; i < count; i++)
            results.add(new RandomPair(i));
        return results;
    }
}
