import java.util.Arrays;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final double GRAVITY = -9.81;

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
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
            System.out.println(Arrays.toString(generateArray(10, 3.5, 6.5)));
            System.out.println(getMean(mas));
            System.out.println(Arrays.toString(generateArray(mas)));
        }
        catch (Exception e){
            System.out.println(e);
        }

        try{
            System.out.println(Arrays.deepToString(generateMatrix(5)));
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
            return 0.5 * GRAVITY * Math.pow(fallingTime, 2) + initialVelocity * fallingTime + initialPosition;
        }
        else{
            throw new Exception("Wrong input parameters");
        }
    }

    public static int factorialForLoop(int N) throws Exception{
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

    public static double[][] generateMatrix(int N) throws Exception{
        if(N <= 0) throw Exception("Wrong input parameters");

        double[][] result = new double[N][N];
        Random rand = new Random();

        for(int i = 0; i < result.length; i++){//rows
            for(int j = 0; j < result[i].length; j++) {//collums
                result[i][j] = rand.nextDouble(100);
            }
        }
    }



}


