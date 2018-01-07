public class SortingAlgorithms {

    public static void main(String[] args) {
        int[] A = {103, -4, 0, -200, 69, 99, -8, 101, 23, 100, 14, -8, -13, -4, 23};
        bubbleSort(A);
        for (int i : A)
            System.out.print(i + " ");
        System.out.println();
        int[] B = {103, -4, 0, -200, 69, 99, -8, 101, 23, 100, 14, -8, -13, -4, 23};
        insertionSort(B);
        for (int i : B)
            System.out.print(i + " ");
        System.out.println();
        int[] C = {103, -4, 0, -200, 69, 99, -8, 101, 23, 100, 14, -8, -13, -4, 23};
        selectionSort(C);
        for (int i : C)
            System.out.print(i + " ");
    }
    //bubble sort algorithm
    static void bubbleSort(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = 0; j < (A.length - 1 - i); j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }
    //insertion sort algorithm
    static void insertionSort(int[] A) {
        for(int i = 1; i < A.length; i++)
        {
            int value = A[i];
            int hole = i;
            while(hole > 0 && A[hole - 1] > value)
            {
                A[hole] = A[hole - 1];
                hole--;
            }
            A[hole] = value;
        }
    }
    //selection sort algorithm
    static void selectionSort(int[] A) {
        for(int i = 0; i < (A.length - 1); i++)
        {
            int index = getSmallest((i + 1), A);
            if(A[i] > A[index])
                swapElements(i, index, A);
        }
    }
    //this method returns the smallest value from index to the end of array A
    private static int getSmallest(int index, int[] A)
    {
        int min = index++;
        while(index < A.length)
        {
            if(A[index] < A[min])
                min = index;
            index++;
        }
        return (min);
    }
    //this method swaps values of index p1 and p2
    private static void swapElements(int p1, int p2, int[] A)
    {
        int temp = A[p1];
        A[p1] = A[p2];
        A[p2] = temp;
    }
}
