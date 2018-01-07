/** Standard deviation  is a measure that is used to quantify the amount
 *  of variation or dispersion of a set of data values.
 */

public class StandardDeviation {

    public static void main(String[] args) {
        double[] A = {1.8, 5.0, 9.6, 10.0, 18.0};
        System.out.println(stdev(A));
    }

    /** This method returns the standard deviation of the data distribution
     *  contained in the array. */
    static double stdev(double[] array) {
        double u = mean(array); // mean of the distribution
        double total = 0;
        for (int i = 0; i < array.length; i++) {
            total += Math.pow((u - array[i]), 2);
        }
        return Math.sqrt(total / array.length);
    }

    /** This method returns the mean of an array of type double. */
    private static double mean(double[] array) {
        double sum = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            count++;
        }
        return (sum / count);
    }
}
