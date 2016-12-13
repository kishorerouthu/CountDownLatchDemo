package com.tutorial.concurrency;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by kishore on 12/12/16.
 */
public class Task implements Runnable {

    private RandomGeneratorClient client;
    private CountDownLatch latch;
    private RandomPair randomPair;

    public Task(RandomGeneratorClient client, CountDownLatch latch, RandomPair randomPair) {
        this.client = client;
        this.latch = latch;
        this.randomPair = randomPair;
    }

    public void run() {
        Integer limit = randomPair.getLimit();
        try {
            Integer result = client.invoke(limit);
            if (result != null)
                randomPair.setResult(result);
        } catch (URISyntaxException e) {
            // log exception stack trace for this task for further reference
        } catch (IOException e) {
            // log exception stack trace for this task for further reference
        } finally {
            latch.countDown();
            // count down indicates that current task has been finished
        }
    }
}
