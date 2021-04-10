public class CheckerBoardMain {

    public static void main(String[]args){

        //Dimension of checker board.
        int dimension = 8;

        // Instantiate Fibonacci class which holds all information about requested series.
        Fibonacci fibonacci = new Fibonacci(1, 2, dimension * dimension);
        long[] fibonacciNumbers = fibonacci.getFibonacciNumbers();

        // Create checker board pattern.
        // This version only accepts one array.
        CheckerBoardDecorator.checkerBoard(fibonacciNumbers);
    }

}
