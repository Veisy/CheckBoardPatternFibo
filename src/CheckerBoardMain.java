public class CheckerBoardMain {

    public static void main(String[]args){

        //Dimension of checker board.
        int dimension = 8;

        // Instantiate Fibonacci class which holds all information about requested series.
        Fibonacci fibonacci = new Fibonacci(1, 2, (dimension*dimension));
        long[] fibonacciNumbers = fibonacci.getFibonacciNumbers();

        //Create checker board pattern.
        checkerBoard(dimension, fibonacciNumbers);
    }


    private static void checkerBoard(int dimension, long[] numberArray) {
        // Instantiate NumberOfDigits class which contains all the information about the long array entered.
        // We will use the number of digits of fibonacci numbers to evenly space the checkerboard.
        NumberOfDigits numberOfDigits = new NumberOfDigits(numberArray);

        // Decorate topmost with one layer '--------' characters.
        decorate(dimension, numberOfDigits.getGreatestNumberOfDigit(), 2);
        for (int i = 1; i <= dimension; i++) {

            //Decorate top of the rows with two layer '|     |     | ...' characters.
            for (int j = 0; j < 2; j++) {
                decorate(dimension, numberOfDigits.getGreatestNumberOfDigit(), 3);
            }

            System.out.print("| ");
            for (int j = 1; j <= dimension; j++) {
                int currentIndex = (i-1)*dimension + (j-1);
                System.out.print(numberArray[currentIndex]);

                //Calculate the amount of space by subtracting the maximum number of digits from the number of existing digits.
                int spaces = numberOfDigits.getGreatestNumberOfDigit() - numberOfDigits.getNumberOfDigits()[currentIndex];
                for (int k = 0; k < spaces; k++) {
                    System.out.print(" ");
                }

                System.out.print(" | ");
            }

            System.out.println();
            //Decorate bottom of the rows with one layer '|     |     | ...' characters.
            decorate(dimension, numberOfDigits.getGreatestNumberOfDigit(), 3);
            //Decorate bottom of the rows with one layer '|_____|_____| ...' characters.
            decorate(dimension, numberOfDigits.getGreatestNumberOfDigit(), 1);

        }
    }

    private static void decorate(int dimension, int width, int decorationOption) {
        String decorationElement1;
        String decorationElement2 = "|";

        if (decorationOption == 1 || decorationOption == 2) {
            decorationElement1 = "_";
            if(decorationOption == 2) {
                decorationElement2 = "_";
            }
        } else {
            decorationElement1 = " ";
        }

        System.out.print(decorationElement2);

        // This is just calculating the number of dash character.
        for (int j = 0; j < dimension; j++) {
            for (int k = 0; k <= width + 1; k++) {
                System.out.print(decorationElement1);
            }
            System.out.print(decorationElement2);
        }
        System.out.println();
    }

}
