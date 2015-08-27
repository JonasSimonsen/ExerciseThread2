package exercise2;

import java.util.ArrayList;
import java.util.List;

public class FibonacciTask extends Thread {

    List<FibonacciObserver> observers = new ArrayList();
    private final long n;

    public void registerFibonacciObserver(FibonacciObserver o) {
        observers.add(o);
    }

    private static long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public FibonacciTask(long n) {
        this.n = n;
    }

    @Override
    public void run() {
        //Call the Fibonacci method from here
        //long tal = ......
        long tal = fib(n);
        for (FibonacciObserver observer : observers) {
            observer.dataReady(tal);
        }
    }
}
