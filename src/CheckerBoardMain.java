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
        checkerBoard(dimension, fibonacciNumbers, numberOfDigitsOfPowersOfTwoArray);
    }


    private static void checkerBoard(int dimension, long[] whiteNumberArray, long[] blackNumberArray) {
        // Instantiate NumberOfDigits classes which contains all the element size information about the long arrays entered.
        // We will use the number of digits to evenly space the checkerboard.
        NumberOfDigits numberOfDigitsWhite = new NumberOfDigits(whiteNumberArray);
        NumberOfDigits numberOfDigitsBlack = new NumberOfDigits(blackNumberArray);

        //Width determined by biggest number in the board.
        int width = Math.max(numberOfDigitsWhite.getGreatestNumberOfDigit(), numberOfDigitsBlack.getGreatestNumberOfDigit());

        // Decorate topmost with one layer '--------' characters.
        decorate(dimension, width, 2);

        int whiteCount = 0;
        int blackCount = 0;
        for (int i = 1; i <= dimension; i++) {

            //Decorate top of the rows with one layer '|     |     | ...' characters.
            decorate(dimension, width, 3);

            System.out.print("| ");
            for (int j = 1; j <= dimension; j++) {

                int spaces;
                if ( (i + j) % 2 == 0) {
                    System.out.print(whiteNumberArray[whiteCount]);
                    //Subtracting the digit number of current fibonacci number from the width,
                    //which determines the required spacing.
                    spaces = width - numberOfDigitsWhite.getNumberOfDigits()[whiteCount];
                    whiteCount++;

                } else {
                    System.out.print(blackNumberArray[blackCount]);
                    spaces = width - numberOfDigitsBlack.getNumberOfDigits()[blackCount];
                    blackCount++;
                }
                for (int k = 0; k < spaces; k++) {
                    System.out.print(" ");
                }

                System.out.print(" | ");
            }

            System.out.println();
            //Decorate bottom of the rows with one layer '|     |     | ...' characters.
            decorate(dimension, width, 3);
            //Decorate bottom of the rows with one layer '|_____|_____| ...' characters.
            decorate(dimension, width, 1);

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
