import java.util.ArrayList;

public class Fibonacci {
    private final int count;
    private final long firstNumber;
    private final long secondNumber;

    private final long[] fibonacciNumbers;

    public Fibonacci(long firstNumber, long secondNumber, int count) {
        this.count = count;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;

        fibonacciNumbers = new long[count];

        addInitials();
        calculateFibonacci();
    }

    private void addInitials() {
        fibonacciNumbers[0] = firstNumber;
        fibonacciNumbers[1] = secondNumber;
    }

    private void calculateFibonacci() {
        for (int i = 2; i < count ; i++) {
            fibonacciNumbers[i] = fibonacciNumbers[i -1] + fibonacciNumbers[i - 2];
        }
    }

    public long[] getFibonacciNumbers() {
        return fibonacciNumbers;
    }

}
