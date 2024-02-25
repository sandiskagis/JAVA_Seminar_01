import java.util.Arrays;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final double GRAVITY = -9.81;

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!\n");
        System.out.println("Exercise 0\n");

        String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt",
                "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron",
                "Kate"};
        int[] times = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393,
                299, 343, 317, 265};


        int nameSize = names.length;
        int timeSize = times.length;

        if (nameSize == timeSize) {
            for (int i = 0; i < nameSize; i++) {
                //[Name, <time>];
                System.out.println("[" + names[i] + ", <" + times[i] + ">]:");
            }
        }

        try{
            System.out.println(positionCalc(10, 0, 100));
        }
        catch(Exception ex){
            System.out.println(ex);
        }

        System.out.println("Programmas strādā");

        try{
            System.out.println(factorialForLoop(4));
        }
        catch(Exception ex){
            System.out.println(ex);
        }

        System.out.println("Programmas strādā");

        try{
            double[] mas = generateArray(10, 0, 10);
            System.out.println(Arrays.toString(mas));
            System.out.println(getMean(mas));
            System.out.println(Arrays.toString(arraySort(mas)));
            System.out.println(getMin(mas));
            System.out.println(getMax(mas));
        }
        catch (Exception e){
            System.out.println(e);
        }

        try{
            double[][] matrix = generateMatrix(5);
            System.out.println(Arrays.deepToString(generateMatrix(5)));
            System.out.println(getProduct(matrix, 2, 3));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try{
            System.out.println("\nExercise 5\nPart 1\n");
            System.out.println(Arrays.toString(coinFlip(10)));
            System.out.println(Arrays.toString(coinFlip(100)));
            System.out.println(Arrays.toString(coinFlip(10000)));
            System.out.println("\nExercise 5\nPart 2\n");
            System.out.println(Arrays.toString(rollDice(100)));
            System.out.println("\nExercise 5\nPart 3\n");
            System.out.println(roll2Dices());
            System.out.println("\nExercise 6\n");
            System.out.println(getTextFromBytes(byteArray));
            System.out.println("\nExercise 7\n");
            System.out.println(pascalsTriangle(7));
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static double positionCalc(double initialVelocity, double
            initialPosition, double fallingTime) throws Exception{
        if (initialVelocity >= 0 && initialVelocity < 299792458
                && initialPosition >= 0 && initialPosition < 20000
                && fallingTime >= 0 && fallingTime < 80000) {
            //x(t) = 0.5 × a*t^2 + v_0*t + x_0
            System.out.println("\nExercise 1\n");
            return 0.5 * GRAVITY * Math.pow(fallingTime, 2) + initialVelocity * fallingTime + initialPosition;
        }
        else{
            throw new Exception("Wrong input parameters");
        }
    }

    public static int factorialForLoop(int N) throws Exception{
        System.out.println("\nExercise 2\n");
        int result = 1;
        if(N >= 1){
            for(int i = 1; i <= N; i++){
                result *= i;
            }
            return result;
        }
        else if(N == 0){
            return 1;
        }
        else{
            throw new Exception("Wrong input parameters");
        }
    }

    public static double[] generateArray(int N, double lower, double upper)throws Exception{
        System.out.println("\nExercise 3\n");
        if(N <= 0 || (upper < lower)) throw new Exception("Wrong input parameters");

        double[] result = new double[N];
        Random rand = new Random();
        for(int i = 0; i < result.length;i++) {
            result[i] = rand.nextDouble(lower, upper);
        }

        return result;
    }

    public static double getMean(double[] array) throws Exception{
        if(array == null) throw new Exception("Wrong input parameters");

        double sum = 0;
        //tips mainigais : masivaNosaukums
        for(double temp : array){
            sum += temp;
        }

        return sum/array.length;

    }

    public static double[] arraySort(double[] array) throws Exception{
        Arrays.sort(array);

        return array;
    }


    public static double getMin(double[] array) throws Exception {
        if (array == null) throw new Exception("Wrong input parameters");

        return Arrays.stream(array).min().getAsDouble();

    }


    public static double getMax(double[] array) throws Exception {
        if (array == null) throw new Exception("Wrong input parameters");

        return Arrays.stream(array).max().getAsDouble();

    }


    public static double[][] generateMatrix(int N) throws Exception{
        System.out.println("\nExercise 4\n");
        if(N <= 0) throw new Exception("Wrong input parameters");

        double[][] result = new double[N][N];
        Random rand = new Random();

        for(int i = 0; i < result.length; i++){//rows
            for(int j = 0; j < result[i].length; j++) {//collums
                result[i][j] = rand.nextDouble(100);
            }
        }

        return result;

    }


    public static double getProduct(double[][] matrix, int i, int j) throws Exception{
        if(i <= 0 || j <= 0) throw new Exception("Wrong input parameters");

        //get the i row into new array
        double[] rowValues = new double[matrix[0].length];

        for(int k = 0; k < matrix[i].length; k++){
            rowValues[k] = matrix[i][k];
        }

        //get j column into new array
        double[] columnValues = new double[matrix.length];

        for(int k = 0; k < matrix[1].length; k++){
            columnValues[k] = matrix[k][j];
        }

        //calculate dot product
        double dotProduct = 0.0;

        for(i = 0; i < rowValues.length; i++){
            dotProduct += rowValues[i] * columnValues[i];
        }

        return dotProduct;

    }


    public static double[] coinFlip(int N) throws Exception {
        if (N <= 0) throw new Exception("Wrong input parameters");

        double heads = 0.0;
        double tails = 0.0;

        double[] flipValues = new double[N];
        Random rand = new Random();

        for(int i = 0; i < N; i++){
            flipValues[i] = rand.nextInt(2);

            if(flipValues[i] == 0)
                heads++;
            else
                tails++;
        }

        double ratio = heads/tails;
        double values[] = new double[3];
        values[0] = heads;
        values[1] = tails;
        values[2] = ratio;

        return values;

    }


    public static int[] rollDice(int N) throws Exception {
        if (N <= 0) throw new Exception("Wrong input parameters");

        int[] diceValue = new int[N];
        Random rand = new Random();
        int[] histogram = new int[6];

        for(int i = 0; i < N; i++){
            diceValue[i] = rand.nextInt(6) + 1;
        }

        for(int i = 0; i < histogram.length; i++){
            histogram[i] = valueOccurrences(i + 1, diceValue);
        }

        return histogram;

    }

    public static int valueOccurrences(int value, int[] array) throws Exception {
        if (value < 1 || value > 6) throw new Exception("Wrong input parameters");
        int count = 0;

        for(int i = 0; i < array.length; i++){
            if(array[i] == value) {
                count++;
            }
        }
        return count;
    }


    public static int roll2Dices(){
        int dice1 = 0;
        int dice2 = 0;
        int count = 0;

        Random rand = new Random();

        do{
            dice1 = rand.nextInt(6) + 1;
            dice2 = rand.nextInt(6) + 1;
            count++;
        } while (dice1 != 6 || dice2 != 6);

        return count;
    }


    public static byte[] byteArray = {72, 101, 108, 108, 111, 33, 32, 77, 121, 32, 115, 107, 105, 108, 108, 115, 32, 97, 114, 101, 32, 103, 114, 101, 97, 116, 32, 97, 108, 114, 101, 97, 100, 121, 33};
    public static String getTextFromBytes(byte[] array) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            sb.append((char) array[i]);
        }

        return sb.toString();

    }


    public static String pascalsTriangle(int level) throws Exception {
        if (level < 1) throw new Exception("Wrong input parameters");

        int[][] pascalsTriangle = new int[level][];

        //malejie elementi vienmer bus 1, tos saliek masiivaa
        for (int i = 0; i < level; i++) {
            pascalsTriangle[i] = new int[i + 1];
            pascalsTriangle[i][0] = 1; //katras rindas 1. elements ir 1
            pascalsTriangle[i][i] = 1; //katras rindas pedejais elements ir 1

            // aizpilda vidu masiivaaa
            for (int j = 1; j < i; j++) {
                pascalsTriangle[i][j] = pascalsTriangle[i - 1][j - 1] + pascalsTriangle[i - 1][j];
            }
        }

        //si koda dala panemta no interneta
        // iegust pedeja limena vertibas
        StringBuilder lastLevelValues = new StringBuilder();
        for (int i = 0; i < pascalsTriangle[level - 1].length; i++) {
            int value = pascalsTriangle[level - 1][i];
            lastLevelValues.append(value).append(" ");
        }

        return lastLevelValues.toString();
    }

}


