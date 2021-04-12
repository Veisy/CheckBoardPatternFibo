import java.util.Random;

public class CheckerBoardMain {

    public static void main(String[]args){

        final int ARRAY_SIZE_BOUND = 100;

        Random random = new Random();
        int arraySize = random.nextInt(ARRAY_SIZE_BOUND);
        double[] randomDoubleArray = new double[arraySize];
        for (int i = 0; i < randomDoubleArray.length; i++) {
            randomDoubleArray[i] = random.nextDouble();
        }

        // Create checker board pattern.
        // This version only accepts one double array.
        CheckerBoardDecorator.checkerBoard(randomDoubleArray);
    }

}
