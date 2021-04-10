import java.util.Arrays;

public class CheckerBoardMain {

    public static void main(String[]args){

        //Dimension of checker board.
        int dimension = 8;

        // Instantiate Fibonacci class which holds all information about requested series.
        Fibonacci fibonacci = new Fibonacci(1, 2, (dimension*dimension) / 2);
        long[] fibonacciNumbers = fibonacci.getFibonacciNumbers();

        // Instantiate PowerSeries class which holds all information about powers of given base.
        PowerSeries powersOfTwo = new PowerSeries(2, (dimension*dimension) / 2);
        long[] powersOfTwoArray = powersOfTwo.getPowerSeries();

        // We only care about the number of digits of powers of two,
        // therefore we instantiate NumberOfDigits class to hold this information.
        // We cast returned int array from getNumberOfDigits() to long array,
        // since our checkerBoard accepts long type as parameter.
        NumberOfDigits numberOfDigitsOfPowersOfTwo = new NumberOfDigits(powersOfTwoArray);
        long[] numberOfDigitsOfPowersOfTwoArray = Arrays
                .stream(numberOfDigitsOfPowersOfTwo.getNumberOfDigits())
                .asLongStream().toArray();

        //Create checker board pattern.
        CheckerBoardDecorator.checkerBoard(fibonacciNumbers, numberOfDigitsOfPowersOfTwoArray);
    }

}
