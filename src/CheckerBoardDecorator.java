final public class CheckerBoardDecorator {

    private CheckerBoardDecorator() {}

    public static void checkerBoard(long[] numberArray) {

        // Take the root of the number length to obtain dimension.
        int dimension = (int) Math.ceil(Math.sqrt(numberArray.length)) ;

        // Instantiate NumberOfDigits class which contains all the element size information about the long array entered.
        // We will use the number of digits to evenly space the checkerboard.
        NumberOfDigits numberOfDigits = new NumberOfDigits(numberArray);

        //Width determined by biggest number in the board.
        int width = numberOfDigits.getGreatestNumberOfDigit();

        // Decorate topmost with one layer '--------' characters.
        decorate(dimension, width, 2);

        for (int i = 0; i < dimension; i++) {

            //Decorate top of the rows with one layer '|     |     | ...' characters.
            decorate(dimension, width, 3);

            System.out.print("| ");
            for (int j = 0; j < dimension; j++) {

                int space = fillNumber(numberArray, numberOfDigits, width, (i * dimension) + j);

                for (int k = 0; k < space; k++) {
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

    // Fill the board with a number.
    private static int fillNumber(long[] numberArray, NumberOfDigits digitNumbersOfNumberArray, int width, int position) {
        // Default values to use when there is no input.
        int space = width - 1;
        String fillWith = "-";

        if (numberArray.length > position) {
            fillWith = String.valueOf(numberArray[position]);
            //Subtracting the digit number of current fibonacci number from the width,
            //which determines the required spacing.
            space = width - digitNumbersOfNumberArray.getNumberOfDigits()[position];

        }
        System.out.print(fillWith);
        return space;
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
