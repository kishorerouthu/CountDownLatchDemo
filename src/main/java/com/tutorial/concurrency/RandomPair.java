package com.tutorial.concurrency;

/**
 * Created by kishore on 12/12/16.
 */
public class RandomPair {

    private Integer limit;
    private Integer result;

    public RandomPair(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RandomPair{" +
                "limit=" + limit +
                ", result=" + result +
                '}';
    }
}
