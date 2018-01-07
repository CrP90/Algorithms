public class RadixSort {

    public static void main(String[] args) {
        int[] A = {69, 153, 49, 201, 43, 0, 100, 9, 77, 9};
        A = radixSort(A);
        for(int i : A)
            System.out.print(i + " ");
    }

    static int[] radixSort(int[] A)
    {
        /* Find the max number to know number of digits. */
        int maxValue = A[0];
        for(int i = 1; i < A.length; i++)
        {
            if(A[i] > maxValue)
                maxValue = A[i];
        }
        /* Do counting sort for every digit.
         * Exp is 10^i where i is current digit number. */
        for(int exp = 1; (maxValue / exp) > 0; exp *= 10)
            A = countSort(A, exp);
        return (A);
    }

    /* This method do counting sort of array according to the digit represented by exp. */
    private static int[] countSort(int[] A, int exp)
    {
        int[] output = new int[A.length];
        int[] count = new int[10];
        // Store count of occurrences in count
        for(int i = 0; i < A.length; i++)
            count[getDigit(A[i], exp)]++;
        // Change count so that count contains actual position
        // of this digit in the output
        for(int i = 1; i < A.length; i++)
            count[i] += count[i - 1];
        // Build the output array
        for(int i = (A.length - 1); i >= 0; i--)
        {
            output[count[getDigit(A[i], exp)] - 1] = A[i];
            count[getDigit(A[i], exp)]--;
        }
        return (output);
    }

    private static int getDigit(int n, int exp)
    {
        return ((n / exp) % 10);
    }
}
