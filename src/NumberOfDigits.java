public class NumberOfDigits {
    //This array will hold the number of digits of each element in the given input array.
    private final int[] numberOfDigits;
    // This field will hold the greatest number of digit.
    private int greatestNumberOfDigit;

    private final long[] inputArray;

    public NumberOfDigits(long[] inputArray) {
        this.inputArray = inputArray;
        numberOfDigits = new int[inputArray.length];

        // Initial value of greatest number of digit
        greatestNumberOfDigit = 0;

        calculateNumberOfDigits();
    }

    private void calculateNumberOfDigits() {
        int tempNumberOfDigit;

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == 0) {
                tempNumberOfDigit = 1;
            } else if (inputArray[i] < 0){
                tempNumberOfDigit = (int) Math.log10(Math.abs(inputArray[i])) + 2;
            } else {
                tempNumberOfDigit = (int) Math.log10(inputArray[i]) + 1;
            }

            numberOfDigits[i] = tempNumberOfDigit;

            if (tempNumberOfDigit > greatestNumberOfDigit) {
                greatestNumberOfDigit = tempNumberOfDigit;
            }
        }
    }

    public int[] getNumberOfDigits() {
        return numberOfDigits;
    }

    public int getGreatestNumberOfDigit() {
        return greatestNumberOfDigit;
    }
}
